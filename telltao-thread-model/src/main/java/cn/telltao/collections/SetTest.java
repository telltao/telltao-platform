package cn.telltao.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * Created By LiuTao
 *  Set 不可修改的集合 元素无法添加或删除
 *  他们不允许使用null元素
 *  他们在创建时拒绝重复的元素 也就是说 多个重复的会被覆盖
 *  HashSet  不可重复的集合
 *  TreeSet  有序的集合
 *  LinkHashSet 有序的集合
 *
 * @Date 2020/11/26 15:54
 */
public class SetTest {

    static void hashSet() {
        //HashSet 底层用的是HashMap 此类只可有切只有一个null
        //
        HashSet set = new HashSet();
        //由于Set是不可重复的 如果再次添加重复的 将会添加失败 .add方法返回false
        set.add("qew");
        set.add("qew");
        //set.stream().map(->set.add("q"));
    }

    static void treeSet() {
        //基于 TreeMap的实现
        //TreeSet(有序) 是二叉树实现的,Treeset中的数据是自动排好序的，不允许放入null值。
        TreeSet treeSet = new TreeSet();
        //此add remove contains 操作的算法时间复杂度为 对数阶O(logN) 有且只有一个while循环
        System.out.println(" treeSet add  " + treeSet.add("qwe"));
        // O(logN)
        System.out.println(" treeSet contains  " + treeSet.contains("qwe"));
        // O(logN)
        System.out.println(" treeSet remove  " + treeSet.remove("qwe"));


    }

    /**
     * LinkHashSet(HashSet+LinkedHashMap)
     * 它是一组有序的集合
     * 适用场景: 退货 发货 需要按照顺序发货 按照顺序退货等
     *
     * Set接口的哈希表和链表实现，具有可预测的迭代顺序。
     * 此实现与HashSet不同之处在于，它维护贯穿其所有条目的双向链接列表。
     * 此链表定义了迭代顺序，即将元素插入集合的顺序（ insert-order ）。
     * 请注意，如果将元素重新插入到集合中，则插入顺序不会受到影响。
     * （元件e重新插入一组s如果s.add(e) ，当被调用s.contains(e)将返回true调用之前立即）。
     *
     */

    static void linkHashSet() {

        LinkedHashSet hashSet = new LinkedHashSet();
        //不可重复
        hashSet.add("qwe");
        hashSet.add("qwe");
        System.out.println("linkHashSet  " + hashSet.size());
        System.out.println("linkHashSet  " + hashSet.remove("qwe"));


    }


    public static void main(String [] args) {
        hashSet();
        treeSet();
        linkHashSet();

    }
}
