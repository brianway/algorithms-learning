package com.brianway.learning.algorithms.leetcode.medium;

/**
 * Created by Brian on 2017/9/6.
 * LeetCode 221. Maximal Square
 * Question: https://leetcode.com/problems/maximal-square/description/
 * 关键题设：the largest square containing only 1's
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        return 0;
    }

    /**
     * 动态规划
     * dp(i,j) 代表有右下角索引为 (i,j) 的正方形的最大边长
     * dp(i, j)=min(dp(i−1, j), dp(i−1, j−1), dp(i, j−1))+1.
     *
     * 写代码时可以使用小 trick 来避免初始化：
     * dp大小申请为 (rows+1)＊(cols+1), i,j 从 1 开始取，从而避免越界
     *
     * 时间复杂度 O(mn)
     * 空间复杂度 O(mn)
     */
    public class MaximalSquare0 extends MaximalSquare {
        @Override
        public int maximalSquare(char[][] matrix) {
            if (matrix == null || matrix.length <= 0) {
                return 0;
            }
            int rows = matrix.length;
            int cols = matrix[0].length;
            int[][] dp = new int[rows + 1][cols + 1];
            int maxSide = 0;
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= cols; j++) {
                    if (matrix[i - 1][j - 1] == '1') {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                        maxSide = Math.max(maxSide, dp[i][j]);
                    }
                }
            }
            return maxSide * maxSide;
        }
    }

    /**
     * 优化版本的动态规划
     * 由于每次只用到了临近的数据，所以不用二维矩阵存 dp,使用一维的数组即可
     *
     * 时间复杂度 O(mn)
     * 空间复杂度 O(n)
     */
    public class MaximalSquare1 extends MaximalSquare {
        @Override
        public int maximalSquare(char[][] matrix) {
            if (matrix == null || matrix.length <= 0) {
                return 0;
            }
            int rows = matrix.length;
            int cols = matrix[0].length;
            int[] dp = new int[cols + 1];
            int maxSide = 0;
            int prev = 0;//old dp[j-1]
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= cols; j++) {
                    int tmp = dp[j];
                    if (matrix[i - 1][j - 1] == '1') {
                        //等式右边  dp[j]是上一行的值，dp[j - 1]是本行的刚更新的值，prev 是上一行的 dp[j-1] 的值
                        dp[j] = Math.min(Math.min(prev, dp[j - 1]), dp[j]) + 1;
                        maxSide = Math.max(maxSide, dp[j]);
                    } else {
                        dp[j] = 0;
                    }
                    prev = tmp;
                }
            }
            return maxSide * maxSide;
        }
    }

}
