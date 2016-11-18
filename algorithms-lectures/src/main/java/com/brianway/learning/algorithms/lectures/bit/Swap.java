package com.brianway.learning.algorithms.lectures.bit;

/**
 * Created by brian on 16/11/18.
 * 请编写一个算法，不用任何额外变量交换两个整数的值。
 * 给定一个数组num，其中包含两个值，请不用任何额外变量交换这两个值，并将交换后的数组返回。
 *
 * 测试样例：
 * [1,2]
 * 返回：[2,1]
 */
public class Swap {
    public int[] getSwap(int[] num) {
        if (num == null || num.length != 2) {
            return null;
        }

        num[0] = num[0] ^ num[1];
        num[1] = num[0] ^ num[1];
        num[0] = num[0] ^ num[1];

        return num;
    }

    public static void main(String[] args) {
        int a = 2;

        System.out.println(a);
    }
}
