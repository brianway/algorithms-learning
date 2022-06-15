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
     * 正经DP思路：
     * 1. dp数组下标以及含义： dp[i][j] 表示到达该点的路径数目，(其中 0<=i<m,0<=j<n)
     * 2. 递推公式： dp[i][j] = dp[i-1][j]+dp[i][j-1]，
     * 显然 第 (i,j) 的方块只能有上边或者左边到达，路径数目是二者之和
     * 3. dp数组初始化，显然第一列和第一行只有一种路径，全部初始化为1
     * 4. 遍历顺序：从左到右即可
     * <p>
     * 时间复杂度 O(m*n)
     * 空间复杂度 O(m*n)
     */
    public class UniquePaths0 extends UniquePaths {
        @Override
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            // 第一列初始化
            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }
            // 第一行初始化
            for (int j = 0; j < n; j++) {
                dp[0][j] = 1;
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m - 1][n - 1];
        }
    }

    /**
     * 代码看起来更简洁，但初始化部分的写法不好理解
     * <p>
     * dp[i][j] 表示到达该点的路径数目
     * 第 (i,j) 的方块只能有上边或者左边到达，故
     * <p>
     * dp[i][j] = dp[i-1][j]+dp[i][j-1]
     * (其中 1<=i<=m,1<=j<=n)
     * <p>
     * 时间复杂度 O(m*n)
     * 空间复杂度 O(m*n)
     */
    public class UniquePaths1 extends UniquePaths {
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
     * 优化空间复杂度：使用一维数组存 dp
     * <p>
     * 从dp的递推公式知：每一步只和"小1个规模"的子问题相关，和更小规模的子问题无关，而且是从左到右按序遍历的
     * 所以可以复用空间，一维数组存即可
     * <p>
     * 1. dp数组下标以及含义：dp[j] 表示到达当前行的第j列点的路径数目，(其中 0<=i<m,0<=j<n)
     * 2. 递推公式： dp[j] = dp[j]+dp[j-1]， dp[j]被赋值前表示上一行第j列，
     * 因为从左到右按序遍历，dp[j-1]表示当前行的第j-1列
     * 3. dp数组初始化，显然第一行只有一种路径，全部初始化为1
     * 4. 遍历顺序：从左到右即可
     * <p>
     * 注意，每一行的第一列都是1，所以循环时j从1开始，跳过j=0
     * <p>
     * 时间复杂度 O(m*n)
     * 空间复杂度 O(n)
     */
    public class UniquePaths2 extends UniquePaths {
        @Override
        public int uniquePaths(int m, int n) {
            int[] dp = new int[n];
            // 初始化第一行
            for (int j = 0; j < n; j++) {
                dp[j] = 1;
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
            return dp[n - 1];
        }
    }

    /**
     * 代码看起来更简洁，使用一维数组存 dp，但边界情况需要想清楚
     * <p>
     * 注意：
     * dp[1] = 1 表示每一行的第一列都只有一种路径，即从上边下来
     * 这个逻辑上是递推来的： dp[i][1] = dp[i-1][1] （因为没有左边）
     * 但代码体现出来的是直接初始化了，这点在 LeetCode 63. Unique Paths II 中要尤为注意
     * <p>
     * 时间复杂度 O(m*n)
     * 空间复杂度 O(n)
     */
    public class UniquePaths3 extends UniquePaths {
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

    // TODO 可以利用数学原理推导：C(m-1,m+n-2)，注意避免数据溢出
}
