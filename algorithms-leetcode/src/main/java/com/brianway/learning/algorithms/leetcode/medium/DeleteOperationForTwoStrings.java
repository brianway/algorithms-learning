package com.brianway.learning.algorithms.leetcode.medium;

/**
 * LeetCode 583. Delete Operation for Two Strings
 * Question: https://leetcode.com/problems/delete-operation-for-two-strings/
 * 关键题设: In one step, you can delete exactly one character in either string.
 *
 * @auther brian
 * @since 2022/8/24 23:46
 */
public class DeleteOperationForTwoStrings {

    public int minDistance(String word1, String word2) {
        return 0;
    }

    /**
     * 思路1：先根据 1143. Longest Common Subsequence 求最长公共子序列长度lcs
     * 然后 word1.len+word2.len- lcs*2 就是结果
     * <p>
     * dp[i+1][j+1] 表示word1的前0～i个字符 和 word2的前0～j个字符的最长公共自序列的长度
     */
    public class DeleteOperationForTwoStrings0 extends DeleteOperationForTwoStrings {
        @Override
        public int minDistance(String word1, String word2) {
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];
            for (int i = 0; i < word1.length(); i++) {
                for (int j = 0; j < word2.length(); j++) {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        dp[i + 1][j + 1] = dp[i][j] + 1;
                    } else {
                        dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                    }
                }
            }
            return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];
        }
    }

    // TODO 按正常DP解，不借助最长公共子序列长度lcs
}
