package com.brianway.learning.algorithms.leetcode.medium;

/**
 * Created by Brian on 2016/4/30.
 * LeetCode 53. Maximum Subarray
 * Question:https://leetcode.com/problems/maximum-subarray/
 * 关键题设： contiguous subarray
 */

//TODO 疑问：为什么MaximumSubarray0的耗时比MaximumSubarray1少？
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        return 0;
    }

    /**
     * 记录累计求和出现过的最大值max以及现在的累计求和值sum
     * 若sum小于零，说明现在的累计求和为负增益，将sum置为0
     * max每次取sum和之前的max的最大值
     * 返回max
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public class MaximumSubarray0 extends MaximumSubarray {
        @Override
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int sum = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                max = sum > max ? sum : max;
                sum = sum > 0 ? sum : 0;
            }
            return max;
        }
    }

    /**
     * 动态规划
     * 维护两个变量，一个是全局最优，就是到当前元素为止最优的解是，一个是局部最优，就是必须包含当前元素的最优的解
     *
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public class MaximumSubarray1 extends MaximumSubarray {
        @Override
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int local = nums[0];
            int global = nums[0];
            for (int i = 1; i < nums.length; i++) {
                local = local + nums[i] > nums[i] ? local + nums[i] : nums[i];
                global = global > local ? global : local;
            }
            return global;
        }
    }
}
