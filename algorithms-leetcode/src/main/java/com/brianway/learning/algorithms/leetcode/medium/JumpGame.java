package com.brianway.learning.algorithms.leetcode.medium;

/**
 * LeetCode 55. Jump Game
 * Question: https://leetcode.com/problems/jump-game/
 * 关键题设: 无
 *
 * @auther brian
 * @since 2022/8/16 21:40
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        return false;
    }

    /**
     * 贪心
     * <p>
     * 对于每个可到达的i, i+nums[i] 就是i这个格子可触达的最远处，和当前最远maxReach取大者即可
     * 依次遍历每个可到达的i，不断更新maxReach即可。可到达的含义为：i<=maxReach
     * <p>
     * 初始化：在第0个格子，maxReach=0+nums[0]
     * <p>
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public class JumpGame0 extends JumpGame {
        @Override
        public boolean canJump(int[] nums) {
            int maxReach = nums[0];
            for (int i = 1; i <= maxReach && i < nums.length; i++) {
                maxReach = Math.max(i + nums[i], maxReach);
            }
            return maxReach >= nums.length - 1;
        }
    }

    public class JumpGame1 extends JumpGame {
        @Override
        public boolean canJump(int[] nums) {
            int maxReach = 0;
            for (int i = 0; i <= maxReach; i++) {
                maxReach = Math.max(i + nums[i], maxReach);
                if (maxReach >= nums.length - 1) {
                    return true;
                }
            }
            return maxReach >= nums.length - 1;
        }
    }
}
