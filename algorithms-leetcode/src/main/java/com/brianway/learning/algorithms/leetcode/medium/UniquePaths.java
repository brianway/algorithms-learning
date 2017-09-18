package com.brianway.learning.algorithms.leetcode.medium;

/**
 * Created by Brian on 2017/9/18.
 * LeetCode 62. Unique Paths
 * Question:https://leetcode.com/problems/unique-paths/description/
 * 关键题设： only move either down or right at any point in time
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        return 0;
    }

    /**
     * dp[i][j] 表示到达该点的路径数目
     * 第 (i,j) 的方块只能有上边或者左边到达，故
     *
     * dp[i][j] = dp[i-1][j]+dp[i][j-1]
     * (其中 1<=i<=m,1<=j<=n)
     *
     * 时间复杂度 O(m*n)
     * 空间复杂度 O(m*n)
     */
    public class UniquePaths0 extends UniquePaths {
        @Override
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m + 1][n + 1];
            dp[0][1] = 1;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m][n];
        }
    }

    /**
     * 优化空间复杂度
     * 使用一维数组存 dp
     *
     * 注意：
     * dp[1] = 1 表示每一行的第一列都只有一种路径，即从上边下来
     * 这个逻辑上是递推来的： dp[i][1] = dp[i-1][1] （因为没有左边）
     * 但代码体现出来的是直接初始化了，这点在 LeetCode 63. Unique Paths II 中要尤为注意
     *
     * 时间复杂度 O(m*n)
     * 空间复杂度 O(n)
     */
    public class UniquePaths1 extends UniquePaths {
        @Override
        public int uniquePaths(int m, int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            for (int i = 1; i <= m; i++) {
                for (int j = 2; j <= n; j++) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
            return dp[n];
        }
    }
}
