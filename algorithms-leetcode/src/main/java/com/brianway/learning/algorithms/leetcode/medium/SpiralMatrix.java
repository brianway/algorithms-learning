package com.brianway.learning.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 54. Spiral Matrix
 * Question: https://leetcode.com/problems/spiral-matrix/
 * 关键题设:  无
 *
 * @auther brian
 * @since 2022/12/4 21:25
 */
public class SpiralMatrix {

    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            List<Integer> result = new ArrayList<>();
            int startRow = 0;
            int startCol = 0;
            while (m > 0 && n > 0) {
                // 只剩 一行或者 一列 时，单独处理
                if (m == 1) {
                    for (int j = 0; j <= n - 1; j++) {
                        result.add(matrix[startRow][startCol + j]);
                    }
                    break;
                }
                if (n == 1) {
                    for (int i = 0; i <= m - 1; i++) {
                        result.add(matrix[startRow + i][startCol + n - 1]);
                    }
                    break;
                }

                // 否则，可以拆成四个方向

                // 左->右
                for (int j = 0; j < n - 1; j++) {
                    result.add(matrix[startRow][startCol + j]);
                }
                // 上->下
                for (int i = 0; i < m - 1; i++) {
                    result.add(matrix[startRow + i][startCol + n - 1]);
                }
                // 右->左
                for (int j = n - 1; j > 0; j--) {
                    result.add(matrix[startRow + m - 1][startCol + j]);
                }
                // 下->上
                for (int i = m - 1; i > 0; i--) {
                    result.add(matrix[startRow + i][startCol]);
                }

                startRow++;
                startCol++;
                m = m - 2;
                n = n - 2;
            }

            return result;
        }
    }
}
