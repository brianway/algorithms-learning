package com.brianway.learning.algorithms.lectures.arithmetic;

import java.util.Random;

/**
 * Created by brian on 16/11/19.
 *
 * 给定一个长度为N且没有重复元素的数组arr和一个整数M，实现函数等概率随机打印arr中的M个数。
 */
public class RandomPrint {
    public int[] print(int[] arr, int N, int M) {
        if (arr == null || M > N || N == 0) {
            throw new RuntimeException("error param");
        }

        int[] res = new int[M];
        Random rand = new Random();
        int m = 0;
        for (int i = 0; i < M; i++) {
            m = rand.nextInt(N - i);

            res[i] = arr[m];
            arr[m] = arr[N - 1 - i];
            arr[N - 1 - i] = res[i];
        }

        return res;

    }

    public static void main(String[] args) {
        RandomPrint rp = new RandomPrint();
        int[] a = {29, 24, 17, 1, 3, 11, 8, 19, 12, 15, 10, 28, 20, 18, 2, 26, 14, 7, 22, 27, 23, 5, 6, 9, 21, 16, 25, 4, 13};
        int[] b = rp.print(a, a.length, 10);
        for (int i : b) {
            System.out.print(i + ",");
        }
    }
}

