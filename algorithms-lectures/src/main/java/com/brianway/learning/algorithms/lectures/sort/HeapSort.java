package com.brianway.learning.algorithms.lectures.sort;

/**
 * Created by brian on 16/11/4.
 *
 * 堆排序
 */
public class HeapSort {
    public int[] heapSort(int[] A, int n) {
        if (A == null || n == 0) {
            return null;
        }
        for (int i = n / 2 - 1; i >= 0; i--) {
            sink(A, i, n);
        }
        int last = n - 1;
        while (last > 0) {
            swap(A, 0, last--);
            sink(A, 0, last + 1);
        }
        return A;
    }

    public void sink(int[] a, int i, int len) {
        while (2 * (i + 1) - 1 < len) {
            int child = 2 * (i + 1) - 1;
            if (child < len - 1 && a[child] < a[child + 1]) {
                child++;
            }
            if (a[i] >= a[child]) {
                break;
            }

            swap(a, i, child);
            i = child;
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {54, 35, 48, 36, 27, 12, 44, 44, 8, 14, 26, 17, 28};
        int[] b = new HeapSort().heapSort(a, 13);
        for (int i : b) {
            System.out.print(i + ",");
        }
        System.out.println();

        int[] c = {32, 103, 24, 88, 95, 70, 97, 15, 102, 6, 79, 46, 51, 37, 93, 108, 9, 58, 53, 58, 79, 36, 58, 91, 78, 58, 61, 81};
        for (int i : new HeapSort().heapSort(c, 28)) {
            System.out.print(i + ",");
        }
    }
}
