package com.brianway.learning.algorithms.leetcode.medium;

/**
 * LeetCode 376. Wiggle Subsequence
 * Question: https://leetcode.com/problems/wiggle-subsequence/
 * 关键题设: 无
 *
 * @auther brian
 * @since 2022/8/11 23:14
 */
public class WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {
        return 0;
    }

    /**
     * 贪心
     * len表示 wiggleMaxLength
     * 当前基准数cur
     * 上一次趋势lastTrend， 小于0表示递减，大于0表示递增，
     * 遇到同趋势的就忽略，并更新cur； 遇到不同趋势的，则len+1, 并更新cur
     * <p>
     * 注意：
     * 上一次趋势的初始化问题需要注意！
     * <p>
     * 边界情况：
     * [3,3,3,2,5]
     */
    public class WiggleSubsequence0 extends WiggleSubsequence {
        @Override
        public int wiggleMaxLength(int[] nums) {
            int len = 1;
            int cur = nums[0];
            int lastTrend = 0; // 假设 下标-1的元素和 nums[0]一样
            int trend = 0;

            for (int i = 1; i < nums.length; i++) {
                trend = nums[i] - cur;

                // 当Wiggle Subsequence内只有一个元素时，不管递增还是递减，只要不是相等，都len+1
                if (len == 1 && trend != 0) {
                    len++;
                }
                if ((trend > 0 && lastTrend < 0) || (trend < 0 && lastTrend > 0)) {
                    len++;
                }

                cur = nums[i];
                if (trend != 0) {
                    lastTrend = trend;
                }

            }
            return len;
        }
    }

    // TODO 用DP解

}
