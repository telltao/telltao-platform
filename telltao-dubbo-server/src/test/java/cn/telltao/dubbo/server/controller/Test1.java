package cn.telltao.dubbo.server.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author telltao
 * @Date 2020/12/22 09:26
 */
public class Test1 {

    /**
     * 5，寻找异常数字。给 N 个整数，其中：
     * * N-1 个数字是从 1， 2， 3， ... N-1；
     * * 另外一个数字是任意一个其它数字：可以在 1 到 N-1之间，也可以之外。
     * 举例：1 3 2 3 里面 3是个重复数字，所以是3
     * 1 3 2 4 里面 4 超过 N-1，所以是 4
     * 1 3 2 -1 里面是 -1
     * 请实现一个函数，找出这个其它数字。并完成相关单元测试（15分）
     * 函数声明：int findStrangeNum(int* numbers, int numNumber)
     */

    static int findStrangeNum(int [] numbers, int numNumber) {
        if (numbers.length <=0) {
            new IllegalArgumentException("参数不可为空!");
        }

        TreeMap treeMap = new TreeMap();

        List<Integer> numberList = new ArrayList();
        for (int i = 0; i < numbers.length; i++) {
            if (treeMap.containsKey(numbers[i])) {
                //找出给定的数字的重复数字
                return (int)numberList.get(numNumber);
            }
            treeMap.put(numbers[i],null);

        }
        //找出给定的数字的重复数字
        if (numberList.contains(numNumber)) {
            return (int)numberList.get(numNumber);
        }
        //判断数字是否超过 N-1
        if (numberList.contains(numbers.length-1)) {
            Object num = numberList.get(numbers.length - 1);
            return (int)num;
        }
        //使用冒泡排序 将最小的显示为第一个
        for (int i =0; i< numbers.length -1; i++) {
            for ( int j = 0; j < numbers.length-1-i; j++) {
                if (numbers[j] > numbers[j+1] ) {
                    int temp = numbers [j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }

        for (int i = 0,length = numbers.length; i < length; i++) {
            //第一个为异常数字
            return numbers[i];
        }
        return 0;
    }

    public static void main(String[] args) {

        int [] num  = new int[] {1,2,3,4,5};
        System.out.println("num返回的数字为:"+findStrangeNum(num, 1));
        int [] num2  = new int[] {1,3,2,4};
        System.out.println("num2返回的数字为:"+findStrangeNum(num2, 8));
        int [] num3  = new int[] {1,3,2,4,-1,7};
        System.out.println("num3返回的数字为:"+findStrangeNum(num3, 8));

        //Assert.assertNotEquals(0,findStrangeNum(num, 8));
    }

}
