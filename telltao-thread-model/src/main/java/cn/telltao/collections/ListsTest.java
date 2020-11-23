package cn.telltao.collections;

import java.util.*;

/**
 * Created By LiuTao
 * 负责对List集合框架下的 ArrayList Vector LinkedList 类的测试方法
 * @Date 2020/11/22 15:59
 */
public class ListsTest {


    /**
     * <pre>
     * Created By Liu Tao
     *  ArrayList的底层是一个数组
     *  优点: 查找和遍历循环
     *  缺点: 插入和删除
     * </pre>
     * @date 2020/11/22 19:18
     * @param
     * @return
     */
    void arrayList() {
       var list =  new ArrayList<>();

    }


   /**
    * <pre>
    * Created By Liu Tao
    *  telltao@qq.com
    *  Vector 的底层是一个数组
    *  优点:支持线程同步 避免多线程竞争
    *  缺点: 实现同步需要很高的花费 访问比ArrayList慢
    * </pre>
    * @date 2020/11/22 19:42
    * @param
    * @return
    */
    void vector() {
        var vector = new Vector<>();
        vector.add("qwe");
    }

    /**
     * <pre>
     * Created By Liu Tao
     *  telltao@qq.com
     *  LinkedList的底层是一个链表
     *  优点: 插入 删除
     *  缺点: 随机访问 遍历比较慢
     * </pre>
     * @date 2020/11/23 18:29
     * @param
     * @return
     */
    void linkedList() {
        var linkList = new LinkedList<>();

    }


    public static void main(String[] args) {

        var list = new ArrayList(16);
        list.add("qwe");
        list.add("123");
        //对list进行翻转的
        Collections.reverse(list);

       var list1 = new ArrayList(16);

        Collections.addAll(list1,new String[list.size()]);
        // 使用copy方法的时候 需要将两个list中的大小设置一致才可以copy
        // 以线性时间运行 时间复杂度是 O (n)
        Collections.copy(list1,list);
        list.forEach(item ->{
            System.out.println(item);
        });
    }
}
