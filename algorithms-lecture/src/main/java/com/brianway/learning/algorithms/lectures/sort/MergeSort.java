package com.brianway.learning.algorithms.lectures.sort;

/**
 * Created by brian on 16/11/3.
 *
 * 归并排序
 */
public class MergeSort {
    public int[] mergeSort(int[] A, int n) {
        if (n == 0 || A == null) {
            return null;
        }
        int[] help = new int[n];
        int end;
        for (int size = 1; size < n; size = size * 2) {
            for (int i = 0; i + size < n; i = i + 2 * size) {
                end = Math.min(n, i + 2 * size);
                merge(A, help, i, i + size, end);
            }
        }
        return A;
    }

    private void merge(int[] a, int[] help, int lo, int mid, int hi) {
        for (int i = lo; i < hi; i++) {
            help[i] = a[i];
        }
        int left = lo;
        int right = mid;
        for (int i = lo; i < hi; i++) {
            if (left == mid) {
                a[i] = help[right++];
            } else if (right == hi) {
                a[i] = help[left++];
            } else if (help[right] < help[left]) {
                a[i] = help[right++];
            } else {
                a[i] = help[left++];
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 6, 7, 2, 1, 8, 9};
        int[] sort = new MergeSort().mergeSort(a, a.length);
        for (int i : sort) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

}
