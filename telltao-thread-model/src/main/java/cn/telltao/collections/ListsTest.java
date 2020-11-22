package cn.telltao.collections;

import java.util.*;

/**
 * Created By LiuTao
 * 负责对List集合框架下的 ArrayList Vector LinkedList 类的测试方法
 * @Date 2020/11/22 15:59
 */
public class ListsTest {
    public static void main(String[] args) {
        new ArrayList<>();
        //ArrayList特点
        var list = new ArrayList(16);
        var list1 = new LinkedList<>();
        list.add("qwe");
        list.add(123);
        //对list进行翻转
        Collections.reverse(list);
        Collections.copy(list,list1);
        list.forEach(item ->{
            System.out.println(item);
        });
    }
}
