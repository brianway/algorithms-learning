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
     * <p>
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
     * <p>
     * 1.若 dp[k] < nums[i] <dp[k+1]
     * 则更新 dp[k+1] ＝ nums [i]
     * 2.若 nums[i] 大于现有 dp 的中的任意值，则 dp[len+1] = nums[i],len++
     * <p>
     * 最终 dp 数组中元素的长度，即为最长递增子序列的长度
     * <p>
     * 注意事项：
     * 虽然 dp 中元素的值是递增的，但不一定是 nums 的最长递增子序列，例子如下：
     * input: [0, 8, 4, 12, 2]
     * dp: [0]
     * dp: [0, 8]
     * dp: [0, 4]
     * dp: [0, 4, 12]
     * dp: [0 , 2, 12]
     * <p>
     * 最长递增子序列为 [0,4,12] 或者 [0,8,12],而非 dp 的 [0 , 2, 12]
     * <p>
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

    /**
     * DP, 按套路来
     * <p>
     * 1. dp数组下标以及含义：dp[i] 表示以 元素nums[i] 结尾的数组的最长递增子序列长度，即子序列必包含nums[i]
     * 2. 递推关系： dp[i] = if(nums[i]>nums[j]) max{ nums[i]>nums[j]? (dp[j]+1): dp[j] } else 1,  其中 0<=j<i
     * 即 nums[i]>nums[j] 时，表示递增子序列长度可增加1，否则就是原长度。然后取这些长度的最大值
     * <p>
     * 3. 初始化：dp[0]=1;
     * 4. 遍历顺序：左到右
     * <p>
     * <p>
     * 1.本题关键需要分析出， dp[i] 不仅仅由 dp[i-1] 推导出，而是 dp[j],0<=j<i 都有可能是dp[i] 上一个状态，
     * 从而时间复杂度最简不会是 O(n)
     * 2.最后返回的不是dp[n-1] ，而是 dp中的最大元素！
     *
     * <p>
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(n)
     */
    public static class LongestIncreasingSubsequence2 extends LongestIncreasingSubsequence {
        @Override
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    // 只有nums[i] 比某个大，才需要更新 dp[i]，否则说明nums[i] 比之前的都不大，则dp[i]=1
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }
            }

            // 最后返回的不是dp[n-1] ，而是 dp中的最大元素！
            int maxLen = 1;
            for (int i = 0; i < nums.length; i++) {
                maxLen = Math.max(maxLen, dp[i]);
            }

            return maxLen;
        }
    }
}
