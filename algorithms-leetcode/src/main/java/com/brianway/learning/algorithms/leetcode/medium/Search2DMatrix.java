package com.brianway.learning.algorithms.leetcode.medium;

/**
 * LeetCode 74. Search a 2D Matrix
 * Question: https://leetcode.com/problems/search-a-2d-matrix/
 * 关键题设:  无
 *
 * @auther brian
 * @since 2022/12/5 19:52
 */
public class Search2DMatrix {
    /**
     * 二分查找
     * 将二维数组看成一维的，index -> matrix[i][j]
     * <p>
     * 时间复杂度 O(log m*n)
     * 空间复杂度 O(1)
     */
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            // index: 0~m*n
            int m = matrix.length;
            int n = matrix[0].length;
            int left = 0;
            int right = m * n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (getValue(matrix, mid, n) == target) {
                    return true;
                } else if (getValue(matrix, mid, n) < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return false;
        }

        private int getValue(int[][] matrix, int index, int n) {
            int i = index / n;
            int j = index % n;
            return matrix[i][j];
        }
    }
}
