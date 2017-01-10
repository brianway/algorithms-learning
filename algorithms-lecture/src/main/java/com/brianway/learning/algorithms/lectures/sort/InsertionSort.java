package com.brianway.learning.algorithms.lectures.sort;

/**
 * Created by brian on 16/11/3.
 *
 * 插入排序
 */
public class InsertionSort {
    public int[] insertionSort(int[] A, int n) {
        if (n == 0 || A == null) {
            return null;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j > 0 && A[j - 1] > A[j]; j--) {
                swap(A, j, j - 1);
            }
//            打印中间态
//            for (int ii : A) {
//                System.out.print(ii + ",");
//            }
//            System.out.println();
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
        int[] b = new InsertionSort().insertionSort(a, a.length);
        for (int i : b) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
