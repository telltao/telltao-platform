package cn.telltao.threadlocal;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created By LiuTao
 * 第二种实现的ThreadLocal 改进版
 * @Date 2020/11/17 17:35
 */
public class MyThreadLocal2<T> {

    static HashMap<Thread,HashMap<Integer,Object>> threadLocalMap = new HashMap<>();

    static AtomicInteger atomic = new AtomicInteger();
    // 1640531527  高德纳提出的一个哈希算法
    Integer threadLocalHash = atomic.addAndGet(0x61c88647);

    synchronized static HashMap<Integer,Object> getMap() {
        Thread thread = Thread.currentThread();
        if (!threadLocalMap.containsKey(thread)) {
            threadLocalMap.put(thread,new HashMap<>());
        }
        return threadLocalMap.get(thread);
    }


    protected T initialValues() {

        return null;
    }

    public T get() {
        HashMap<Integer, Object> map = getMap();
        if (!map.containsKey(this.threadLocalHash)) {
            map.put(this.threadLocalHash,initialValues());
        }

        return (T) map.get(this.threadLocalHash);
    }

    public void set(T v) {
        HashMap<Integer, Object> map = getMap();
        map.put(this.threadLocalHash,v);

    }

}
