package com.brianway.learning.algorithms.lectures.bit;

/**
 * Created by brian on 16/11/18.
 *
 * 有一个整型数组A，其中只有一个数出现了奇数次，其他的数都出现了偶数次，请打印这个数。
 * 要求时间复杂度为O(N)，额外空间复杂度为O(1)。
 * 给定整形数组A及它的大小n，请返回题目所求数字。
 *
 * 测试样例：
 * [1,2,3,2,1],5
 * 返回：3
 */
public class OddAppearance {
    public int findOdd(int[] A, int n) {
        if (A == null || n % 2 != 1) {
            throw new RuntimeException("error param");
        }
        int base = 0;
        for (int i = 0; i < n; i++) {
            base = base ^ A[i];
        }

        return base;
    }
}
