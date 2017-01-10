package com.brianway.learning.algorithms.lectures.sort;

/**
 * Created by brian on 16/11/4.
 *
 * 基数排序
 * 保证元素均小于等于2000
 */
public class RadixSort {
    private int[] radix = {1, 10, 100, 1000};

    public int[] radixSort(int[] A, int n) {
        if (A == null || n == 0) {
            return null;
        }
        int total = radix.length;
        int[][] bucket = new int[10][n];
        int[] count = new int[10];
        int number = 0;

        for (int position = 0; position < total; position++) {
            for (int i = 0; i < n; i++) {
                number = getNumber(A[i], position);
                bucket[number][count[number]++] = A[i];
            }
            int i = n - 1;
            for (int k = 9; k >= 0; k--) {
                while (count[k] > 0) {
                    A[i--] = bucket[k][--count[k]];
                }

            }
        }
        return A;
    }

    private int getNumber(int num, int i) {
        num = num / radix[i];
        return num % 10;
    }

    public static void main(String[] args) {
        int[] a = {1023, 345, 1678, 478, 432, 98, 10, 29, 5};
        int[] b = new RadixSort().radixSort(a, a.length);
        for (int i : b) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
