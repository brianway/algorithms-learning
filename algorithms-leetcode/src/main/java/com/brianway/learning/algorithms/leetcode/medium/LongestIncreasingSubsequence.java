package com.brianway.learning.algorithms.leetcode.medium;

import java.util.Arrays;

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
     * 动态规划
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

    /**
     * 使用二分查找的动态规划
     * 数组 dp 用来存递增子序列的值，故 dp 是升序的
     * 每当遍历到 nums[i] 时，使用二分搜索在 dp 中确定 nums[i] 的位置，更新 dp
     *
     * 1.若 dp[k] < nums[i] <dp[k+1]
     * 则更新 dp[k+1] ＝ nums [i]
     * 2.若 nums[i] 大于现有 dp 的中的任意值，则 dp[len+1] = nums[i],len++
     *
     * 最终 dp 数组中元素的长度，即为最长递增子序列的长度
     *
     * 注意事项：
     * 虽然 dp 中元素的值是递增的，但不一定是 nums 的最长递增子序列，例子如下：
     * input: [0, 8, 4, 12, 2]
     * dp: [0]
     * dp: [0, 8]
     * dp: [0, 4]
     * dp: [0, 4, 12]
     * dp: [0 , 2, 12]
     *
     * 最长递增子序列为 [0,4,12] 或者 [0,8,12],而非 dp 的 [0 , 2, 12]
     *
     * 时间复杂度 O(n*log n)
     * 空间复杂度 O(n)
     */
    public class LongestIncreasingSubsequence1 extends LongestIncreasingSubsequence {
        @Override
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            int len = 0;
            for (int i = 0; i < nums.length; i++) {
                int k = Arrays.binarySearch(dp, 0, len, nums[i]);
                if (k < 0) {
                    k = -k - 1;
                }
                dp[k] = nums[i];
                if (k == len) {
                    len++;
                }
            }
            return len;
        }
    }

}
