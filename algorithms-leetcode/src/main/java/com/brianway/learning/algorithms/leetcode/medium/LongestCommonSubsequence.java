package com.brianway.learning.algorithms.leetcode.medium;

/**
 * LeetCode 1143. Longest Common Subsequence
 * Question: https://leetcode.com/problems/longest-common-subsequence/
 * 关键题设: common subsequence
 *
 * @auther brian
 * @since 2022/7/19 22:52
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        return 0;
    }

    /**
     * DP
     * <p>
     * 1. dp数组下标以及含义：dp[i+1][j+1] 表示text1的前0～i个字符 和 text2的前0～j个字符的最长公共自序列的长度
     * 2. 递推关系：
     * 如果 text1.charAt(i)== text1.charAt(j)
     * 则 dp[i+1][j+1]= max{dp[i][j]+1, dp[i+1][j], dp[i][j+1]}
     * 否则 dp[i+1][j+1]= max{dp[i][j], dp[i+1][j], dp[i][j+1]}
     * 3. 初始化：dp[0][j]=0, dp[i][0]=0, 表示其中一个字符串为空串 "" 时， 最长公共自序列的长度为0
     * 4. 遍历顺序：从左到右
     * <p>
     * 由于dp往右下方是递增的，所以最长的就是dp[text1.len][text2.len]
     */
    public class LongestCommonSubsequence0 extends LongestCommonSubsequence {
        @Override
        public int longestCommonSubsequence(String text1, String text2) {
            int[][] dp = new int[text1.length() + 1][text2.length() + 1];
            for (int i = 0; i < text1.length(); i++) {
                for (int j = 0; j < text2.length(); j++) {
                    if (text1.charAt(i) == text2.charAt(j)) {
                        dp[i + 1][j + 1] = max(dp[i][j] + 1, dp[i + 1][j], dp[i][j + 1]);
                    } else {
                        dp[i + 1][j + 1] = max(dp[i][j], dp[i + 1][j], dp[i][j + 1]);
                    }
                }
            }

            return dp[text1.length()][text2.length()];
        }

        public int max(int a, int b, int c) {
            return Math.max(a, Math.max(b, c));
        }
    }

    // TODO 递推关系简化，分析why
    /**
     * 如果 text1.charAt(i)== text1.charAt(j)
     * 则 dp[i+1][j+1]= dp[i][j]+1
     * 否则 dp[i+1][j+1]= max{dp[i+1][j], dp[i][j+1]}
     */

}
