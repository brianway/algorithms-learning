package com.brianway.learning.algorithms.leetcode.easy;

/**
 * Created by Brian on 2016/4/30.
 * LeetCode 53. Maximum Subarray
 * Question:https://leetcode.com/problems/maximum-subarray/
 * 关键题设： contiguous subarray
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        return 0;
    }

    /**
     * 两个辅助变量：
     * sum: 表示包含num[i-1]元素的连续子数组的最大和，即作为截止nums[i]（不含）时的求和base
     * maxSum: 表示出现过的连续子数组的最大和
     * <p>
     * 若sum小于零，说明现在的累计求和为负增益，将sum置为0
     * maxSum每次取sum和之前的maxSum的较大者
     * 返回maxSum
     * <p>
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public static class MaximumSubarray0 extends MaximumSubarray {
        @Override
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int sum = 0;
            int maxSum = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                sum = sum + nums[i];
                maxSum = Math.max(maxSum, sum);
                // 截止nums[i] 为止的连续元素和 为负增益，将sum归零
                if (sum < 0) {
                    sum = 0;
                }
            }
            return maxSum;
        }
    }

    /**
     * 动态规划
     * 维护两个变量:
     * 一个是全局最优global，就是到当前元素为止最优的解
     * 一个是局部最优local，就是必须包含当前元素（即nums[i]）的最优的解
     * <p>
     * 该解法没有MaximumSubarray0优
     * 个人分析：因为MaximumSubarray0里的sum是和0(常量)比，而本解法是local + nums[i]和nums[i]比
     * <p>
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public static class MaximumSubarray1 extends MaximumSubarray {
        @Override
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int local = nums[0];
            int global = nums[0];
            for (int i = 1; i < nums.length; i++) {
                local = Math.max(local + nums[i], nums[i]);
                global = Math.max(global, local);
            }
            return global;
        }
    }

    /**
     * divide and conquer的解法
     * <p>
     * TODO 后面再补
     */
    public class MaximumSubarray2 extends MaximumSubarray {
        @Override
        public int maxSubArray(int[] nums) {
            return super.maxSubArray(nums);
        }
    }
}
