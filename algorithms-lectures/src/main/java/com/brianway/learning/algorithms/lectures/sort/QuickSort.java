package com.brianway.learning.algorithms.lectures.sort;

import java.util.Random;

/**
 * Created by brian on 16/11/3.
 *
 * 快速排序
 */
public class QuickSort {
    private static Random random = new Random();

    public int[] quickSort(int[] A, int n) {
        if (n == 0 || A == null) {
            return null;
        }

        sort(A, 0, n - 1);
        return A;
    }

    private void sort(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int mid = partition(a, lo, hi);
        sort(a, lo, mid - 1);
        sort(a, mid + 1, hi);
    }

    private int partition(int[] a, int lo, int hi) {
        int key = a[lo];
        int left = lo + 1;
        int right = hi;
        while (true) {
            while (a[left] <= key && left < hi) {
                left++;
            }

            while (a[right] >= key && right > lo) {
                right--;
            }

            if (left >= right) {
                break;
            }

            swap(a, left, right);

        }
        swap(a, lo, right);
        return right;

    }

    /*
    //partition另一种写法
    private int partition(int[] a, int lo, int hi) {
        int key = a[lo];
        int left = lo;
        int right = hi;
        //assert left < right;

        while (left < right) {
            while (left < right && a[right] > key) {
                right--;
            }
            if (left < right) {
                a[left++] = a[right];
            }

            while (left < right && a[left] < key) {
                left++;
            }

            if (left < right) {
                a[right--] = a[left];
            }
        }
        a[left] = key;
        return left;
    }
    */

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {54, 35, 48, 36, 27, 12, 44, 44, 8, 14, 26, 17, 28};
        int[] b = new QuickSort().quickSort(a, 13);
        for (int i : b) {
            System.out.print(i + ",");
        }
        System.out.println();

        int[] c = {32, 103, 24, 88, 95, 70, 97, 15, 102, 6, 79, 46, 51, 37, 93, 108, 9, 58, 53, 58, 79, 36, 58, 91, 78, 58, 61, 81};
        for (int i : new QuickSort().quickSort(c, 28)) {
            System.out.print(i + ",");
        }
    }
}
