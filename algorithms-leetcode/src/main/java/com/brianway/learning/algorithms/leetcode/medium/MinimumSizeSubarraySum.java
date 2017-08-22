package com.brianway.learning.algorithms.leetcode.medium;

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
     * 同时，在 sum >＝ s 的前提下，尝试向后移动 begin，来减小窗口长度
     * 若 sum>=s, 记录此时窗口的长度，并和历史最小长度取 min
     *
     * 注意:
     * 遍历结束后，只有当 sum>=s 才可返回最小长度，否则说明不满足，返回 0
     *
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public class MinimumSizeSubarraySum0 extends MinimumSizeSubarraySum {
        @Override
        public int minSubArrayLen(int s, int[] nums) {
            if (nums == null) {
                return 0;
            }
            int begin = 0;
            int end = 0;
            int minLength = nums.length + 1;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                end = i;
                sum += nums[i];

                while (sum - nums[begin] >= s) {
                    sum = sum - nums[begin];
                    begin++;
                }
                if (sum >= s) {
                    minLength = Math.min(end - begin + 1, minLength);
//                    System.out.println("begin: " + begin);
//                    System.out.println("end: " + end);
//                    System.out.println("minLength: " + minLength);
                }

            }

            return sum >= s ? minLength : 0;
        }
    }

}
