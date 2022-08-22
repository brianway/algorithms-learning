package com.brianway.learning.algorithms.leetcode.hard;

/**
 * LeetCode 115. Distinct Subsequences
 * Question: https://leetcode.com/problems/distinct-subsequences/
 * 关键题设：无
 *
 * @auther brian
 * @since 2022/8/22 23:31
 */
public class DistinctSubsequences {

    public int numDistinct(String s, String t) {
        return 0;
    }

    /**
     * DP
     * <p>
     * 1. dp数组以及下标含义： dp[i+1][j+1] 表示 s的[0...i] 中 子序列为t[0...j]的不同子序列的个数
     * 2. 递推关系：
     * if(s[i]==t[j])  dp[i+1][j+1] = dp[i][j]+dp[i][j+1],  表示使用s[i] 和不使用s[i]的不同子序列的个数
     * else dp[i+1][j+1]=dp[i][j+1]， 表示不使用s[i]
     * 3. 初始化：
     * dp[i][0] 都是1， 表示t为空串时，子序列个数为1，即 "" 是任意字符串的子序列，且最只有一个;
     * dp[0][j]=0，(j>0) 表示没有子序列；
     * dp[0][0]=1, 表示 "" 是 "" 的子序列
     * 4. 遍历顺序：从左到右
     * <p>
     * 最后返回 dp[s.len][t.len]
     */
    public class DistinctSubsequences0 extends DistinctSubsequences {
        @Override
        public int numDistinct(String s, String t) {
            int[][] dp = new int[s.length() + 1][t.length() + 1];
            // 很关键的初始化
            for (int i = 0; i < s.length(); i++) {
                dp[i][0] = 1;
            }
            for (int j = 0; j < t.length(); j++) {
                dp[0][j] = 0;
            }
            dp[0][0] = 1;

            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < t.length(); j++) {
                    if (t.charAt(j) == s.charAt(i)) {
                        dp[i + 1][j + 1] = dp[i][j] + dp[i][j + 1];
                    } else {
                        dp[i + 1][j + 1] = dp[i][j + 1];
                    }
                }
            }
            return dp[s.length()][t.length()];
        }
    }

}
