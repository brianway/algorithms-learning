package com.brianway.learning.algorithms.leetcode.medium;

/**
 * LeetCode 152. Maximum Product Subarray
 * Question: https://leetcode.com/problems/maximum-product-subarray/
 * 关键题设：无
 *
 * @auther brian
 * @since 2022/12/11 21:05
 */
public class MaximumProductSubarray {
    /**
     * DP
     */
    class Solution0 {
        public int maxProduct(int[] nums) {
            // 以下标i-1结尾的 绝对值最大的乘积，正的和负的
            Integer dpPositive = null;
            Integer dpNegative = null;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    dpPositive = dpPositive != null ? dpPositive * nums[i] : nums[i];
                    dpNegative = dpNegative != null ? dpNegative * nums[i] : null;
                    max = Math.max(max, dpPositive);
                } else if (nums[i] < 0) {
                    Integer tmpPositive = dpNegative != null ? dpNegative * nums[i] : null;
                    Integer tmpNegative = dpPositive != null ? dpPositive * nums[i] : nums[i];

                    dpPositive = tmpPositive;
                    dpNegative = tmpNegative;
                    max = (dpPositive != null) ? Math.max(max, dpPositive) : Math.max(max, dpNegative);

                } else {
                    dpPositive = null;
                    dpNegative = null;
                    max = Math.max(max, 0);
                }
            }
            return max;
        }
    }

    /**
     * DP
     * 写法简化
     * <p>
     * 注意，不能写成
     * imax = Math.max(imin * nums[i], nums[i]);
     * imin = Math.min(imax * nums[i], nums[i]);
     * 这样相当于修改了 imax 后， imin 基于修改后的imax二次计算了。
     */
    class Solution1 {
        public int maxProduct(int[] nums) {
            int max = Integer.MIN_VALUE;
            int imax = 1;
            int imin = 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < 0) {
                    // 保存当前imax值，避免被本次迭代修改，影响imin的计算
                    int tmpmax = imax;
                    imax = Math.max(imin * nums[i], nums[i]);
                    imin = Math.min(tmpmax * nums[i], nums[i]);
                } else {
                    imax = Math.max(imax * nums[i], nums[i]);
                    imin = Math.min(imin * nums[i], nums[i]);
                }

                max = Math.max(max, imax);
            }

            return max;
        }
    }
}
