package com.brianway.learning.algorithms.leetcode.easy;

/**
 * 674. Longest Continuous Increasing Subsequence
 * Question: https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 * 关键题设： unsorted, continuous increasing subsequence, strictly increasing
 *
 * @auther brian
 * @since 2022/7/19 21:38
 */
public class LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {
        return 0;
    }

    /**
     * 贪心？
     * 存两个变量：
     * curLen 表示 当前连续递增子序列的长度
     * maxLen 表示 连续递增子序列出现过的最长长度
     * <p>
     * 应该是最优解，因为该写法里maxLen并不是长度一增加就更新，而是递增终止时更新，减少了赋值的次数
     * <p>
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public static class LongestContinuousIncreasingSubsequence0 extends LongestContinuousIncreasingSubsequence {
        @Override
        public int findLengthOfLCIS(int[] nums) {
            int curLen = 1;
            int maxLen = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i - 1]) {
                    curLen++;
                } else {
                    maxLen = Math.max(maxLen, curLen);
                    // reset
                    curLen = 1;
                }
            }
            // 一直递增时上述循环会没赋值maxLen
            maxLen = Math.max(maxLen, curLen);
            return maxLen;
        }
    }

    /**
     * DP
     * 1. dp数组下标以及含义：dp[i] 表示以 元素nums[i] 结尾的数组的最长连续递增子序列长度，即子序列必包含nums[i]
     * 2. 递推关系： dp[i] =  nums[i]>nums[i-1]? (dp[i-1]+1) : 1
     * 即 nums[i]>nums[i-1] 时，表示连续递增子序列长度可增加1，否则长度重置为1
     * <p>
     * 3. 初始化：dp[0]=1;
     * 4. 遍历顺序：左到右
     * <p>
     * 在最后取dp[i]里的最大值即可
     * <p>
     * 注意：本题和LeetCode 300 的核心区别在于，由于要求连续递增，所以 dp[i] 只和 dp[i-1] 相关，而不用关心 0~i-1的所有状态
     * <p>
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public static class LongestContinuousIncreasingSubsequence1 extends LongestContinuousIncreasingSubsequence {
        @Override
        public int findLengthOfLCIS(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                dp[i] = nums[i] > nums[i - 1] ? (dp[i - 1] + 1) : 1;
            }

            int maxLen = 1;
            for (int i = 0; i < nums.length; i++) {
                if (dp[i] > maxLen) {
                    maxLen = dp[i];
                }
            }
            return maxLen;
        }
    }

    /**
     * DP 滚动数组
     * <p>
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public static class LongestContinuousIncreasingSubsequence2 extends LongestContinuousIncreasingSubsequence {
        @Override
        public int findLengthOfLCIS(int[] nums) {
            int dp = 1;
            int maxLen = 1;
            for (int i = 1; i < nums.length; i++) {
                dp = nums[i] > nums[i - 1] ? (dp + 1) : 1;

                if (dp > maxLen) {
                    maxLen = dp;
                }
            }

            return maxLen;
        }
    }

}
