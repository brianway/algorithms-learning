package com.brianway.learning.algorithms.leetcode.medium;

import java.util.Arrays;

/**
 * Created by brian on 16/5/22.
 * LeetCode 209. Minimum Size Subarray Sum
 * Question:https://leetcode.com/problems/minimum-size-subarray-sum/description/
 * 关键题设: positive integers
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        return 0;
    }

    /**
     * 用两个指针 begin 和 end 维护一个窗口
     * 每次移动 end, 把当前元素纳入窗口内，更新窗口内元素的和 sum
     * 同时，在 sum >＝ target 的前提下，尝试向后移动 begin，来减小窗口长度
     * 若 sum>=target, 记录此时窗口的长度，并和历史最小长度取 min
     * <p>
     * 注意:
     * 遍历结束后，只有当 sum>=target 才可返回最小长度，否则说明不满足，返回 0
     * <p>
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public class MinimumSizeSubarraySum0 extends MinimumSizeSubarraySum {
        @Override
        public int minSubArrayLen(int target, int[] nums) {
            int begin = 0, end = 0;
            int minSize = Integer.MAX_VALUE;
            int sum = 0;
            while (end < nums.length) {
                sum = sum + nums[end];

                while (sum - nums[begin] >= target) {
                    sum = sum - nums[begin];
                    begin++;
                }

                if (sum >= target) {
                    minSize = Math.min(minSize, end - begin + 1);
                }

                end++;

            }
            return minSize == Integer.MAX_VALUE ? 0 : minSize;
        }

        /**
         * 前缀和+二分查找
         * <p>
         * 先求以下标0作为起始，以下标i作为结尾的和，即 sums[k]表示 nums 前k个元素的和
         * sum[0] 表示0个元素的和，即sums[0]=0,
         * 由于nums全是正整数，所以sums[k]单调递增, 且 k取值0,1, ..., n
         *
         * <p>
         * 则题目转化为 求满足 sums[high]-sums[low]>=target的 high和low 的最小宽度
         * 对于每个low（取0,1,2, ..., n）, 要得到满足 sums[low]+target<=sums[high]的最小high，可以使用二分查找
         * 若能找到，则 记下 high-low 为宽度，和之前的最小宽度取min
         * <p>
         * ps: sums[k]表示 nums 前k个元素的和，而不是下标0～下标的和，因为sums[high]-sums[low]>=target，
         * 如果sums[0] 表示 nums[0]的和，则 相当于永远剔除了 nums[0]
         * <p>
         * 时间复杂度 O(n log n)
         * 空间复杂度 O(n)
         */
        public class MinimumSizeSubarraySum1 extends MinimumSizeSubarraySum {
            @Override
            public int minSubArrayLen(int target, int[] nums) {
                // 求sums[]
                int[] sums = new int[nums.length + 1];
                for (int i = 1; i <= nums.length; i++) {
                    sums[i] = sums[i - 1] + nums[i - 1];
                }

                int minSize = Integer.MAX_VALUE;
                // 对于每个low，依次查找high
                for (int low = 0; low <= nums.length; low++) {
                    int sumsHigh = sums[low] + target;
                    int index = Arrays.binarySearch(sums, sumsHigh);
                    if (index < 0) {
                        index = -index - 1;
                    }
                    if (index <= nums.length) {
                        minSize = Math.min(index - low, minSize);
                    }
                }

                return minSize == Integer.MAX_VALUE ? 0 : minSize;

            }
        }
    }

}