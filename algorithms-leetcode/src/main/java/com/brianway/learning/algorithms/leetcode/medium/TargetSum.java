package com.brianway.learning.algorithms.leetcode.medium;

/**
 * LeetCode 494. Target Sum
 * Question: https://leetcode.com/problems/target-sum/
 * 关键题设:  only positive integers,
 *
 * @auther brian
 * @since 2022/6/20 22:28
 */
public class TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        return 0;
    }

    /**
     * DP，不具备一般性，依赖题目的Constraints
     * <p>
     * 1. dp下标和数组含义： dp[i][j] 表示从下标为[0-i]的数里任意取，在目标值等于j时的不同表达式的个数
     * 2. 递推关系 dp[i][j] = dp[i-1][j-nums[i]] + dp[i-1][j+nums[i]]
     * dp[i-1][j-nums[i]] 表示在nums[i] 前添加 + 时，使得目标值为 j 的不同表达式的个数
     * dp[i-1][j+nums[i]] 表示在nums[i] 前添加 - 后，使得目标值为 j 的不同表达式的个数
     * 3. 初始化 : j=+nums[0]+ 1000 或 -nums[0]+1000 时， dp[0][j]= 1, 其他的dp[0][j]=0
     * (因为下标要非负，需要做了下标偏移：下标+1000)
     * 4. 遍历顺序：外i内j, 从左到右
     * <p>
     * 边界条件注意：
     * +nums[0] 和 -nums[0] 我们认为是两种表达式，但当nums[0]=0时会有  初始化的 dp[0][1000±nums[0]] 应该赋值两次
     */
    public static class TargetSum0 extends TargetSum {
        @Override
        public int findTargetSumWays(int[] nums, int target) {
            int[][] dp = new int[nums.length][2002];
            // 初始化，注意是 +1，不是=1，避免nums[0]=0时  1000±nums[0]是同一个数而覆盖赋值
            dp[0][nums[0] + 1000] = dp[0][nums[0] + 1000] + 1;
            dp[0][-nums[0] + 1000] = dp[0][-nums[0] + 1000] + 1;
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j <= 2000; j++) {
                    // nums[i] 前添加 +
                    int left = j - nums[i] >= 0 ? dp[i - 1][j - nums[i]] : 0;
                    // nums[i] 前添加 -
                    int right = j + nums[i] <= 2000 ? dp[i - 1][j + nums[i]] : 0;
                    dp[i][j] = left + right;
                }
            }

            return dp[nums.length - 1][target + 1000];
        }
    }

    /**
     * DP, 转化为背包问题
     * TODO https://leetcode.cn/problems/target-sum/solution/mu-biao-he-by-leetcode-solution-o0cp/
     */
    public static class TargetSum1 extends TargetSum {
        @Override
        public int findTargetSumWays(int[] nums, int target) {
            return super.findTargetSumWays(nums, target);
        }
    }

}
