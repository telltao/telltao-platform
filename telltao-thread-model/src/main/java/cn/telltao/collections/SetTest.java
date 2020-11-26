package cn.telltao.collections;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created By LiuTao
 *  Set 不可修改的集合 元素无法添加或删除
 *  他们不允许使用null元素
 *  他们在创建时拒绝重复的元素 也就是说 多个重复的会被覆盖
 *  HashSet  不可重复的集合
 *  TreeSet
 *  AbstractSet: 抽象类的
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
        //TreeSet 是二叉树实现的,Treeset中的数据是自动排好序的，不允许放入null值。
        TreeSet treeSet = new TreeSet();
        //此add remove contains 操作的算法时间复杂度为 对数阶O(logN) 有且只有一个while循环
        System.out.println(" treeSet add  " + treeSet.add("qwe"));
        // O(logN)
        System.out.println(" treeSet contains  " + treeSet.contains("qwe"));
        // O(logN)
        System.out.println(" treeSet remove  " + treeSet.remove("qwe"));


    }


    public static void main(String [] args) {
        hashSet();
        treeSet();
    }
}
