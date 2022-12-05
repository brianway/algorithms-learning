package com.brianway.learning.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 73. Set Matrix Zeroes
 * Question: https://leetcode.com/problems/set-matrix-zeroes/
 * 关键题设:  无
 *
 * @auther brian
 * @since 2022/12/5 19:36
 */
public class SetMatrixZeroes {
    /**
     * 非最优解, m*n的矩阵
     * <p>
     * 时间复杂度 O(m*n)
     * 空间复杂度 O(m+n)
     */
    class Solution {
        public void setZeroes(int[][] matrix) {
            Map<Integer, Boolean> rows = new HashMap<>();
            List<Integer> cols = new ArrayList<>();
            int m = matrix.length;
            int n = matrix[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        rows.put(i, true);
                        cols.add(j);
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                if (rows.get(i) != null) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = 0;
                    }
                } else {
                    for (int j : cols) {
                        matrix[i][j] = 0;
                    }
                }
            }

        }
    }
}
