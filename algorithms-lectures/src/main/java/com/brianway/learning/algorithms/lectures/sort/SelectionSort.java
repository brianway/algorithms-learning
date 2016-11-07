package com.brianway.learning.algorithms.lectures.sort;

/**
 * Created by brian on 16/11/3.
 *
 * 选择排序
 */

public class SelectionSort {
    public int[] selectionSort(int[] A, int n) {
        if (n == 0 || A == null) {
            return null;
        }
        int min = 0;
        for (int i = 0; i < n; i++) {
            min = i;
            for (int j = i; j < n; j++) {
                if (A[j] < A[min]) {
                    min = j;
                }
            }
            swap(A, min, i);
        }

        return A;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}