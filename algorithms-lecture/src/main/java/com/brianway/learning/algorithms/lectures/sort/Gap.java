package com.brianway.learning.algorithms.lectures.sort;

/**
 * Created by brian on 16/11/7.
 *
 * 有一个整形数组A，请设计一个复杂度为O(n)的算法，算出排序后相邻两数的最大差值。
 * 给定一个int数组A和A的大小n，请返回最大的差值。保证数组元素多于1个。
 *
 * TODO 直接传delta不行,当数组较大(几百个)时会出错
 * TODO F1
 */
public class Gap {
    public int maxGap(int[] A, int n) {
        if (A == null || n == 0) {
            return 0;
        }

        int max = A[0];
        int min = A[0];
        for (int i = 0; i < n; i++) {
            if (A[i] > max) {
                max = A[i];
            }
            if (A[i] < min) {
                min = A[i];
            }
        }

        int[] maxs = new int[n + 1];
        int[] mins = new int[n + 1];
        boolean[] hasNum = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            int bid = getBucketId(A[i], n, min, max);
            if (!hasNum[bid]) {
                maxs[bid] = A[i];
                mins[bid] = A[i];
                hasNum[bid] = true;
            } else {
                maxs[bid] = Math.max(maxs[bid], A[i]);
                mins[bid] = Math.min(mins[bid], A[i]);
            }
        }

        int lastMax = min;
        int result = 0;
        for (int i = 0; i <= n; i++) {
            if (hasNum[i]) {
                result = Math.max(result, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }

        return result;

    }

//    //double delta = (max - min) / n;
//    private int getBucketId(int num, int min, double delta) {
//        double d = (num - min) / delta;
//        return (int) d;
//    }

    public int getBucketId(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }

    public static void main(String[] args) {
        int[] a = {7778, 9763, 347, 8793, 4297};
        int b = new Gap().maxGap(a, 5);
        System.out.println(b);
    }
}
