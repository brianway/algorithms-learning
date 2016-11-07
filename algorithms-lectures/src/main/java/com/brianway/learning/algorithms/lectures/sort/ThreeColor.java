package com.brianway.learning.algorithms.lectures.sort;

/**
 * Created by brian on 16/11/7.
 *
 * 荷兰旗问题
 *
 * 有一个只由0，1，2三种元素构成的整数数组，请使用交换、原地排序而不是使用计数进行排序。
 * 给定一个只含0，1，2的整数数组A及它的大小，请返回排序后的数组。保证数组大小小于等于500。
 */
public class ThreeColor {
    public int[] sortThreeColor(int[] A, int n) {
        if (A == null || n == 0) {
            return null;
        }

        int lo = -1;
        int hi = n;
        int mid = 0;
        while (mid < hi) {
            if (A[mid] < 1) {
                swap(A, ++lo, mid++);
            } else if (A[mid] > 1) {
                swap(A, --hi, mid);
            } else {
                mid++;
            }

        }

        return A;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 1, 0, 2, 2};
        int[] b = new ThreeColor().sortThreeColor(a, 6);
        for (int i : b) {
            System.out.print(i + ",");
        }
        System.out.println();
        int[] c = {1, 2, 0, 2};
        int[] d = new ThreeColor().sortThreeColor(c, 4);
        for (int i : d) {
            System.out.print(i + ",");
        }
        System.out.println();
        int[] e = {2, 2, 0, 2, 0};
        int[] f = new ThreeColor().sortThreeColor(e, 5);
        for (int i : f) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
