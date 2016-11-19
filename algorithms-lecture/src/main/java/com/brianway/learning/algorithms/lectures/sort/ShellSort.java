package com.brianway.learning.algorithms.lectures.sort;

/**
 * Created by brian on 16/11/4.
 *
 * 希尔排序
 */
public class ShellSort {
    public int[] shellSort(int[] A, int n) {
        if (A == null || n == 0) {
            return null;
        }
        int h = 1;
        while (h < n / 3) h = 3 * h + 1;

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && A[j] < A[j - h]; j -= h) {
                    swap(A, j, j - h);
                }
//                for (int x : A) {
//                    System.out.print(x + ",");
//                }
//                System.out.println();
            }

            h = h / 3;
        }
        return A;

    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {54, 35, 48, 36, 27, 12, 44, 44, 8, 14, 26, 17, 28};
        int[] b = new ShellSort().shellSort(a, 13);
        for (int i : b) {
            System.out.print(i + ",");
        }
        System.out.println();

        int[] c = {32, 103, 24, 88, 95, 70, 97, 15, 102, 6, 79, 46, 51, 37, 93, 108, 9, 58, 53, 58, 79, 36, 58, 91, 78, 58, 61, 81};
        for (int i : new ShellSort().shellSort(c, 28)) {
            System.out.print(i + ",");
        }
    }
}
