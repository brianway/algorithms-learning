package com.brianway.learning.algorithms.leetcode.medium;

/**
 * LeetCode 48. Rotate Image
 * Question: https://leetcode.com/problems/rotate-image/
 * 关键题设:  in-place
 *
 * @auther brian
 * @since 2022/12/1 23:43
 */
public class RotateImage {

    public void rotate(int[][] matrix) {

    }

    /**
     * 纯数学推导：
     * 假设矩阵为n*n
     * 则顺时针旋转90度相当于先沿对角线反转，再沿垂直中线反转
     * 即
     * 1. swap (i,j), (j,i)
     * 2. swap (i,j), (i ,n-1-j)
     */
    public class RotateImage0 extends RotateImage {
        @Override
        public void rotate(int[][] matrix) {
            int n = matrix.length;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 上右 三角
                    if (i < j) {
                        swap(matrix, i, j, j, i);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n / 2; j++) {
                    swap(matrix, i, j, i, n - 1 - j);
                }
            }

        }

        public void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
            int tmp = matrix[i1][j1];
            matrix[i1][j1] = matrix[i2][j2];
            matrix[i2][j2] = tmp;
        }
    }

    // TODO 一题多解
}
