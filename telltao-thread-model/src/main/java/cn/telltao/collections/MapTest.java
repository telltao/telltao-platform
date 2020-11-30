package cn.telltao.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created By telltao
 * telltao@qq.com
 *  将键映射到值的对象。 映射不能包含重复的键； 每个键最多可以映射到一个值。
 *  该接口代替了Dictionary类，后者是一个完全抽象的类，而不是一个接口。
 *
 * @Date 2020/11/30 11:18
 */
public class MapTest {


    /**
     * <pre>
     * Created By Liu Tao
     *  telltao@qq.com
     *  基于哈希表的Map接口的实现。 此实现提供所有可选的映射操作，并允许null值和null键。
     * （ HashMap类与Hashtable大致等效，不同之处在于它是不同步的，并且允许为null。）
     *  此类不保证映射的顺序。 特别是，它不能保证顺序会随着时间的推移保持恒定。
     *
     * </pre>
     * @date 2020/11/30 12:03
     */
   static void  hashMap () {
       HashMap map = new HashMap(16);


    }

    /**
     * <pre>
     * Created By Liu Tao
     *  telltao@qq.com
     *  创建一个线程安全的map 它如何保证线程安全呢?
     *  1,整个 ConcurrentHashMap 由一个个 Segment 组成
     *  2,Segment 代表”部分“或”一段“的 意思，所以很多地方都会将其描述为分段锁。
     *  3,简单理解就是，ConcurrentHashMap 是一个 Segment 数组，
     *      Segment 通过继承 ReentrantLock 来进行加锁，所以每次需要加锁的操作锁住的是一个 segment，
     *      这样只要保证每 个 Segment 是线程安全的，也就实现了全局的线程安全。
     * </pre>
     * @date 2020/11/30 16:23
     */
    static void concurrentHashMap() {

       ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("qwe","12");

    }

    public static void main(String[] args) {


    }

}
