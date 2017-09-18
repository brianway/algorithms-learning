package com.brianway.learning.algorithms.leetcode.medium;

/**
 * Created by Brian on 2017/9/18.
 * LeetCode 63. Unique Paths II
 * Question:https://leetcode.com/problems/unique-paths-ii/description/
 * 关键题设： 无
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return 0;
    }

    /**
     * 动态规划
     *
     * dp[i][j] 表示到达下标为(i-1, j-1)的点的路径数目
     * dp[i][j] = obstacleGrid[i-1][j-1]==1 ? 0 : dp[i-1][j]+dp[i][j-1]
     *
     * 优化后：
     * 使用一维数组存 dp
     * dp[j] = obstacleGrid[i - 1][j - 1] == 1 ? 0 : dp[j] + dp[j - 1];
     *
     * 注意：
     * 第一列的数据要的递推关系是：
     * dp[i][1] = obstacleGrid[i-1][0]==1 ? 0 : dp[i-1][1]
     * （因为没有左边的方块）
     *
     * 这点要注意，否则测试用例 [[1],[0]] 会出错
     *
     * 时间复杂度 O(m*n)
     * 空间复杂度 O(n)
     */
    public class UniquePathsII0 extends UniquePathsII {
        @Override
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            if (obstacleGrid == null || obstacleGrid.length == 0) {
                return 0;
            }

            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int[] dp = new int[n + 1];
            dp[1] = 1;
            for (int i = 1; i <= m; i++) {
                dp[1] = obstacleGrid[i - 1][0] == 1 ? 0 : dp[1];
                for (int j = 2; j <= n; j++) {
                    dp[j] = obstacleGrid[i - 1][j - 1] == 1 ? 0 : dp[j] + dp[j - 1];
                }
            }
            return dp[n];
        }
    }

}
