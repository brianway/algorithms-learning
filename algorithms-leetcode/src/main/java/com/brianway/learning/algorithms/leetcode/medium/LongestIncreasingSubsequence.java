package com.brianway.learning.algorithms.leetcode.medium;

/**
 * Created by Brian on 2017/9/7.
 * LeetCode 300. Longest Increasing Subsequence
 * Question: https://leetcode.com/problems/longest-increasing-subsequence/description/
 * 关键题设： return the length, run in O(n2) complexity
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        return 0;
    }

    /**
     * 使用额外数组 upCount
     * upCount[i] 表示以 nums[i] 结尾的最长升序列的长度
     * 对于每个元素 nums[i]，遍历 0~i-1 的元素，更新 upCount[i]
     *
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(n)
     */
    public class LongestIncreasingSubsequence0 extends LongestIncreasingSubsequence {
        @Override
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] upCount = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                upCount[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i] && upCount[j] >= upCount[i]) {
                        upCount[i] = upCount[j] + 1;
                    }
                }
            }
            int maxLength = 0;
            for (int i = 0; i < upCount.length; i++) {
                maxLength = Math.max(maxLength, upCount[i]);
            }
            return maxLength;
        }
    }

}
