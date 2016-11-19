package com.brianway.learning.algorithms.lectures.sort;

/**
 * Created by brian on 16/11/4.
 *
 * 计数排序
 */
public class CountingSort {
    public int[] countingSort(int[] A, int n) {
        if (A == null || n == 0) {
            return null;
        }

        int min = A[0];
        int max = A[0];
        for (int i = 0; i < n; i++) {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }

        int[] bucket = new int[max - min + 1];
        for (int i = 0; i < n; i++) {
            bucket[A[i] - min]++;
        }
        int i = 0;
        for (int j = 0; j <= max - min; j++) {
            for (int count = bucket[j]; count > 0; count--) {
                A[i++] = j + min;
            }
        }

        return A;
    }

}
