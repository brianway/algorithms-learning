package com.brianway.learning.algorithms.leetcode.medium;

/**
 * LeetCode 1035. Uncrossed Lines
 * Question: https://leetcode.com/problems/uncrossed-lines/
 * 关键题设: 无
 *
 * @auther brian
 * @since 2022/7/21 21:35
 */
public class UncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        return 0;
    }

    /**
     * DP，该题可以转化为最长公共子序列，见 LeetCode 1143. Longest Common Subsequence
     */
    public static class UncrossedLines0 extends UncrossedLines {
        @Override
        public int maxUncrossedLines(int[] nums1, int[] nums2) {
            int[][] dp = new int[nums1.length + 1][nums2.length + 1];
            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    if (nums1[i] == nums2[j]) {
                        dp[i + 1][j + 1] = dp[i][j] + 1;
                    } else {
                        dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                    }
                }
            }
            return dp[nums1.length][nums2.length];
        }
    }

}
