package com.brianway.learning.algorithms.leetcode.medium;

/**
 * LeetCode 718. Maximum Length of Repeated Subarray
 * Question: https://leetcode.com/problems/maximum-length-of-repeated-subarray/
 * 关键题设: 无
 *
 * @auther brian
 * @since 2022/7/19 22:28
 */
public class MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] nums1, int[] nums2) {
        return 0;
    }

    /**
     * DP
     * <p>
     * 1. dp数组下标以及含义：dp[i+1][j+1] 表示nums1数组以下标i结尾，nums2数数组以下标j结尾时，最长重复子数组长度。
     * 即 dp[i][j] 表示nums1数组以下标i-1结尾，nums2数数组以下标j-1结尾时，最长重复子数组长度。
     * 2. 递推关系：dp[i+1][j+1] = nums1[i]== nums2[j]? dp[i][j]+1 : 0
     * 3. 初始化：dp[i][0]=0, dp[0][j]=0
     * 4. 遍历顺序：从左到右
     */
    public static class MaximumLengthOfRepeatedSubarray0 extends MaximumLengthOfRepeatedSubarray {
        @Override
        public int findLength(int[] nums1, int[] nums2) {
            int[][] dp = new int[nums1.length + 1][nums2.length + 1];
            int maxLen = 0;
            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    if (nums1[i] == nums2[j]) {
                        dp[i + 1][j + 1] = dp[i][j] + 1;
                    }
                    if (dp[i + 1][j + 1] > maxLen) {
                        maxLen = dp[i + 1][j + 1];
                    }
                }
            }
            return maxLen;
        }
    }
}
