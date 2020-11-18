package cn.telltao.threadlocal;

import java.util.HashMap;

/**
 * Created By LiuTao
 * 第一种实现的ThreadLocal
 * @Date 2020/11/17 17:35
 */
public class MyThreadLocal<T> {

    static HashMap<Thread,HashMap<MyThreadLocal<?>,Object>> threadLocalMap = new HashMap<>();


    /**
     * <pre>
     * Created By Liu Tao
     *  会产生共享空间 会有临界区 所以需要对此方法进行加锁
     *  TODO 此时会产生一个新的问题 HashMap为静态强绑定 并且直接存储了 MyThreadLocal的引用 无法进行垃圾回收
     * </pre>
     * @date 2020/11/18 17:50
     * @param
     * @return
     */
    synchronized static HashMap<MyThreadLocal<?>,Object> getMap() {
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
        HashMap<MyThreadLocal<?>,Object> map = getMap();
        if (!map.containsKey(this)) {
            map.put(this,initialValues());
        }

        return (T) map.get(this);
    }

    public void set(T v) {
        HashMap<MyThreadLocal<?>, Object> map = getMap();
        map.put(this,v);

    }

}
