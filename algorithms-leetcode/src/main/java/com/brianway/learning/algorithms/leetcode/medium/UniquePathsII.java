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
     * 正经DP
     * 1. dp数组下标以及含义： dp[i][j] 表示到达该点的路径数目，(其中 0<=i<m,0<=j<n)
     * 2. 递推公式： dp[i][j] = dp[i-1][j]+dp[i][j-1]，
     * 显然， 第 (i,j) 的方块只能有上边或者左边到达，路径数目是二者之和
     * 注意，当obstacleGrid[i][j]=1时，表示该点不通，没有路径可达，故dp[i][j]=0
     * 3. dp数组初始化，显然，
     * 当obstacleGrid[i][j]=0时， 第一列和第一行只有一种路径，初始化为1；
     * 当obstacleGrid[i][0]=1时，第一列后面的行都不可达，初始化为0；
     * 当obstacleGrid[0][j]=1时，第一行后面的行都不可达，初始化为0；
     * 4. 遍历顺序：从左到右即可
     * <p>
     * 时间复杂度 O(m*n)
     * 空间复杂度 O(m*n)
     */
    public static class UniquePathsII0 extends UniquePathsII {
        @Override
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int[][] dp = new int[m][n];
            // 初始化第一行，遇到障碍就终止
            for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
                dp[0][j] = 1;
            }

            // 初始化第一列，遇到障碍就终止
            for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
                dp[i][0] = 1;
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    // obstacleGrid[i][j] ==1 则 dp[i][j] = 0, 否则按递推公来
                    dp[i][j] = obstacleGrid[i][j] == 0 ? dp[i - 1][j] + dp[i][j - 1] : 0;
                }
            }
            return dp[m - 1][n - 1];
        }
    }

    /**
     * 优化空间复杂度：使用一维数组存 dp
     * <p>
     * 从dp的递推公式知：每一步只和"小1个规模"的子问题相关，和更小规模的子问题无关，而且是从左到右按序遍历的
     * 所以可以复用空间，一维数组存即可
     * 注意，当obstacleGrid[i][j]=1时，表示该点不通，没有路径可达，故对应的dp[j]=0
     * <p>
     * 1. dp数组下标以及含义：dp[j] 表示到达当前行的第j列点的路径数目，(其中 0<=i<m,0<=j<n)
     * 2. 递推公式： dp[j] = dp[j]+dp[j-1]， dp[j]被赋值前表示上一行第j列，
     * 因为从左到右按序遍历，dp[j-1]表示当前行的第j-1列
     * 3. dp数组初始化，显然，
     * 当obstacleGrid[i][j]=0时，第一行只有一种路径，初始化为1；
     * 当obstacleGrid[0][j]=1时，第一行后面的行都不可达，初始化为0；
     * 4. 遍历顺序：从左到右即可
     * <p>
     * 注意，每一行的第一列都是1，所以循环时j从1开始，跳过j=0
     * <p>
     * 时间复杂度 O(m*n)
     * 空间复杂度 O(n)
     */
    public static class UniquePathsII1 extends UniquePathsII {
        @Override
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int[] dp = new int[n];
            // 初始化第一行,
            for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
                dp[j] = 1;
            }

            for (int i = 1; i < m; i++) {
                // 第一列
                if (obstacleGrid[i][0] == 1) {
                    dp[0] = 0;
                }
                for (int j = 1; j < n; j++) {
                    dp[j] = obstacleGrid[i][j] == 0 ? dp[j] + dp[j - 1] : 0;
                }
            }
            return dp[n - 1];
        }
    }

    /**
     * 动态规划，下标写的不太好，不直观
     *
     * <p>
     * dp[i][j] 表示到达下标为(i-1, j-1)的点的路径数目
     * dp[i][j] = obstacleGrid[i-1][j-1]==1 ? 0 : dp[i-1][j]+dp[i][j-1]
     * <p>
     * 优化后：
     * 使用一维数组存 dp
     * dp[j] = obstacleGrid[i - 1][j - 1] == 1 ? 0 : dp[j] + dp[j - 1];
     * <p>
     * 注意：
     * 第一列的数据要的递推关系是：
     * dp[i][1] = obstacleGrid[i-1][0]==1 ? 0 : dp[i-1][1]
     * （因为没有左边的方块）
     * <p>
     * 这点要注意，否则测试用例 [[1],[0]] 会出错
     * <p>
     * 时间复杂度 O(m*n)
     * 空间复杂度 O(n)
     */
    public class UniquePathsII3 extends UniquePathsII {
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
