package com.brianway.learning.algorithms.leetcode.medium;

/**
 * LeetCode 64. Minimum Path Sum
 * Question: https://leetcode.com/problems/minimum-path-sum/
 * 关键题设:  无
 *
 * @auther brian
 * @since 2022/12/4 23:07
 */
public class MinimumPathSum {
    /**
     * DP
     * 直接使用一维数组解决
     * <p>
     * 注意第一排初始化。题设是从最左上 到 最 右下。
     */
    class Solution {
        public int minPathSum(int[][] grid) {
            int[] dp = new int[grid[0].length];
            // 初始化
            dp[0] = grid[0][0];
            for (int j = 1; j < grid[0].length; j++) {
                dp[j] = dp[j - 1] + grid[0][j];
            }

            for (int i = 1; i < grid.length; i++) {
                dp[0] = dp[0] + grid[i][0];
                for (int j = 1; j < grid[0].length; j++) {
                    dp[j] = Math.min(dp[j - 1] + grid[i][j], dp[j] + grid[i][j]);
                }
            }
            return dp[grid[0].length - 1];
        }
    }
}
