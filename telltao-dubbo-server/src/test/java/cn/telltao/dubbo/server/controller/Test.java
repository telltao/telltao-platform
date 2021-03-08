package cn.telltao.dubbo.server.controller;

import org.junit.Assert;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author telltao
 * @Date 2020/12/22 09:26
 */
public class Test {

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

        TreeMap<Integer,Integer> treeMap = new TreeMap();
        for (int i = 0; i < numbers.length; i++) {
            if (treeMap.containsKey(numNumber)) {
                //找出给定的数字的重复数字
                return (int)treeMap.get(numNumber);
            }
            treeMap.put(i,numbers[i]);
        }
        //判断数字是否超过 N-1
        if (treeMap.containsKey(numbers.length-1)) {
            Object num = treeMap.get(numbers.length - 1);
            return (int) num;
        }
        return treeMap.firstKey();
    }
















    public static void main(String[] args) {

        int [] num  = new int[] {1,2,3,4,5};
        Assert.assertEquals(1,findStrangeNum(num, 1));
        System.out.println("返回数字为1,验证通过");

        int [] num2  = new int[] {1,3,2,4};
        Assert.assertEquals(3,findStrangeNum(num2, 8));
        System.out.println("返回数字为3,验证通过");

        int [] num3  = new int[] {1,3,2,4,-1,7};
        Assert.assertEquals(-1,findStrangeNum(num3, 8));
        System.out.println("返回数字为-1,验证通过");

        int [] num4  = new int[] {-1,-3,-2,-4,-1,7};
        Assert.assertEquals(-1,findStrangeNum(num4, 8));
        System.out.println("返回数字为-1,验证通过");

    }

}
