package com.brianway.learning.algorithms.leetcode.medium;

/**
 * LeetCode 198. House Robber
 * Question: https://leetcode.com/problems/house-robber/
 * 关键题设: if two adjacent houses were broken into on the same night.
 *
 * @auther brian
 * @since 2022/7/7 23:43
 */
public class HouseRobber {

    public int rob(int[] nums) {
        return 0;
    }

    /**
     * DP
     * 1. dp数组下标和含义：
     * 两个dp数组：dp0[i]表示不打劫第i家的情况下，可获得的最大金额；dp1[i]表示打劫第i家的情况下，可获得的最大金额；
     * 2. 递推关系：
     * dp0[i] = max{dp1[i-1], dp0[i-1]}, 不打劫第i家，所以取前面的i-1家的较大者
     * dp1[i] = dp0[i-1]+nums[i], 打劫第i家，则时不打劫第i-1的最大值加上第i家的钱
     * 3. dp数组初始化： dp0[0]=0, dp1[0]=nums[0]
     * 4. 遍历顺序：从左到右即可
     */
    public static class HouseRobber0 extends HouseRobber {
        @Override
        public int rob(int[] nums) {
            int[] dp0 = new int[nums.length];
            int[] dp1 = new int[nums.length];
            dp0[0] = 0;
            dp1[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp0[i] = Math.max(dp1[i - 1], dp0[i - 1]);
                dp1[i] = dp0[i - 1] + nums[i];
            }
            return Math.max(dp0[nums.length - 1], dp1[nums.length - 1]);
        }
    }
}
