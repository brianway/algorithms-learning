package com.brianway.learning.algorithms.lectures.sort;

/**
 * Created by brian on 16/11/3.
 */
public class InsertionSort {
    public int[] insertionSort(int[] A, int n) {
        if (n == 0 || A == null) {
            return null;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (A[j] < A[j - 1]) {
                    swap(A, j, j - 1);
                }
            }
        }
        return A;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
