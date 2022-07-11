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

    /**
     * DP 解法2，使用一个数组
     * <p>
     * 1. dp数组下标和含义：dp[i] 打劫到下标i（包括i）的房屋时，最多可以偷窃的金额。注意，此时不是一定要打劫第i家
     * 2. 递推关系：dp[i]=max{dp[i-1], dp[i-2]+nums[i]}
     * 如果不打劫第i家，则打劫到第i家的最大金额 就是 dp[i-1]；
     * 如果打劫第i家，则第i-1家不能打劫，此时最大金额 是 打劫到第i-2家的最大金额dp[i-2] 加上第i家的金额
     * 3. 初始化： dp[0] = nums[0], dp[1]=max{nums[0], nums[1]}
     * 4. 遍历顺序：从左到右即可
     * <p>
     * 注意考虑nums个数的边界情况
     */
    public static class HouseRobber1 extends HouseRobber {
        @Override
        public int rob(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];

            // 数组个数边界
            if (nums.length == 1) {
                return dp[0];
            }

            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
            return dp[nums.length - 1];
        }
    }
}
