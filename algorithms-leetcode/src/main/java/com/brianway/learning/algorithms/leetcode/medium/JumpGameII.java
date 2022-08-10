package com.brianway.learning.algorithms.leetcode.medium;

/**
 * LeetCode 45. Jump Game II
 * Question: https://leetcode.com/problems/jump-game-ii/
 * 关键题设: non-negative integers,  assume that you can always reach the last index.
 *
 * @auther brian
 * @since 2022/8/10 22:42
 */
public class JumpGameII {
    public int jump(int[] nums) {
        return 0;
    }

    /**
     * DP?
     * 1. dp数组下标及含义：dp[i] 表示到达下标i的最小跳数
     * 2. 递推公式：dp[i] = min{dp[j]+1} ，其中 j<i 且 j+nums[j]>=i
     * 3. dp数组初始化： dp[0]=0, dp[i]=Int.Max
     * 4. 遍历顺序：从左到右
     */
    public class JumpGameII0 extends JumpGameII {
        @Override
        public int jump(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = 0;
            // 初始化
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Integer.MAX_VALUE;
            }

            for (int i = 0; i < nums.length; i++) {
                for (int step = 1; step <= nums[i]; step++) {
                    if (i + step < nums.length) {
                        dp[i + step] = Math.min(dp[i + step], dp[i] + 1);
                    }
                }
            }

            return dp[nums.length - 1];
        }
    }

    /**
     * 贪心
     * <p>
     * TODO
     */
    public class JumpGameII1 extends JumpGameII {
        @Override
        public int jump(int[] nums) {
            return super.jump(nums);
        }
    }

}
