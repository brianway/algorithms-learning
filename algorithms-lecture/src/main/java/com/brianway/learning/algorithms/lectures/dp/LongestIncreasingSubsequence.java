package com.brianway.learning.algorithms.lectures.dp;

/**
 * Created by brian on 16/11/20.
 *
 * 这是一个经典的LIS(即最长上升子序列)问题，
 * 请设计一个尽量优的解法求出序列的最长上升子序列的长度。
 * 给定一个序列A及它的长度n(长度小于等于500)，请返回LIS的长度。
 *
 * 测试样例：
 * [1,4,2,5,3],5
 * 返回：3
 */
public class LongestIncreasingSubsequence {
    public int getLIS(int[] A, int n) {
        int[] up = new int[n];
        up[0] = 1;
        for (int i = 1; i < n; i++) {
            up[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && up[j] >= up[i]) {
                    up[i] = up[j] + 1;
                }
            }
        }

        int max = 1;
        for (int i = 0; i < n; i++) {
            if (up[i] > max) {
                max = up[i];
            }
        }
        return max;
    }
}
