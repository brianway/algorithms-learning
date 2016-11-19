package com.brianway.learning.algorithms.lectures.binarysearch;

/**
 * Created by brian on 16/11/15.
 *
 * 如果更快的求一个整数k的n次方。如果两个整数相乘并得到结果的时间复杂度为O(1)，
 * 得到整数k的N次方的过程请实现时间复杂度为O(logN)的方法。
 * 给定k和n，请返回k的n次方，为了防止溢出，请返回结果Mod 1000000007的值。
 *
 * 测试样例：
 * 2,3
 * 返回：8
 */
public class QuickPower {
    public int getPower(int k, int N) {
        long tmp = k;
        long res = 1;
        long divisor = 1000000007;
        for (; N != 0; N >>= 1) {
            if ((N & 1) != 0) {
                res = res * tmp % divisor;
            }

            tmp = tmp * tmp % divisor;

        }

        return (int) res;
    }
}
