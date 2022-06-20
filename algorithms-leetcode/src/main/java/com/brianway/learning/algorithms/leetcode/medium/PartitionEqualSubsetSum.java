package com.brianway.learning.algorithms.leetcode.medium;

/**
 * LeetCode 416. Partition Equal Subset Sum
 * Question: https://leetcode.com/problems/partition-equal-subset-sum/
 * 关键题设:  only positive integers,
 *
 * @auther brian
 * @since 2022/6/16 23:30
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        return false;
    }

    /**
     * DP，转化为01背包问题
     * <p>
     * 1. dp数组下标以及含义: dp[i][j] 表示从下标为[0-i]的数里任意取，在允许的sum上限为j的限制下，最大可以达到的sum是多少。
     * 2. 递推公式： dp[i][j] = max{dp[i-1][j],dp[i-1][j-nums[i]]+nums[i]}，max内的两个表达式分别表示：
     * - 最大sum的贡献元素不含nums[i] 时，可以达到的最大sum；
     * - 最大sum的贡献元素含nums[i] 时，可以达到的最大sum；
     * 3. dp数组初始化：显然，由于nums[i]都是正整数，sum上限为0时，dp[i][0] 都为0；
     * 对于nums[0]，当 j>=nums[0]时， dp[0][j] = nums[0]，
     * 4. 遍历顺序：外i内j, 从左到右即可
     * <p>
     * 由于分割的两个集合要和相等，所以j只需要（也只能）取到 nums 所有元素和的一半， 即j的多大值为sum(nums)/2,
     * 一旦找到 dp[i][j]==sum(nums)/2 即可结束
     */
    public static class PartitionEqualSubsetSum0 extends PartitionEqualSubsetSum {
        @Override
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            // 和不是偶数，直接返回false
            if (sum % 2 == 1) {
                return false;
            }
            int halfSum = sum / 2;
            int[][] dp = new int[nums.length][halfSum + 1];
            // 初始化列
            for (int i = 0; i < nums.length; i++) {
                dp[i][0] = 0;
            }
            // 初始化行
            for (int j = nums[0]; j <= halfSum; j++) {
                dp[0][j] = nums[0];
            }

            for (int i = 1; i < nums.length; i++) {
                for (int j = 1; j <= halfSum; j++) {
                    if (j >= nums[i]) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                    // 找到
                    if (j == halfSum && dp[i][j] == halfSum) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /**
     * DP，转化为01背包问题
     * 使用滚动数组（一维数组）解决
     * <p>
     * 1. dp数组下标以及含义: 第i次遍历的 dp[j] 表示从下标为[0-i]的数里任意取，在允许的sum上限为j的限制下，最大可以达到的sum是多少。
     * 2. 递推公式： dp[j] = max{[j],dp[j-nums[i]]+nums[i]}，max内的两个表达式分别表示：
     * - 最大sum的贡献元素不含nums[i] 时，可以达到的最大sum；
     * - 最大sum的贡献元素含nums[i] 时，可以达到的最大sum；
     * 3. dp数组初始化：显然，由于nums[i]都是正整数，sum上限为0时，dp[0] 都为0；
     * 对于nums[0]，当 j>=nums[0]时， dp[j] = nums[0]，
     * 4. 遍历顺序：外i内j, 第i次遍历时，由于dp[j]只以来第i-1次遍历完时dp[j]的值，不能依赖本次（即第i次遍历）的dp[j]的值
     * 所以当对dp[j]进行赋值时，不能从左到右，否则nums[i]会重复计算；
     * 同时，由于dp[j]的计算只以来其左边的值，所以可以对j从大到小计算每个dp[j]
     */
    public static class PartitionEqualSubsetSum1 extends PartitionEqualSubsetSum {
        @Override
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            // 和不是偶数，直接返回false
            if (sum % 2 == 1) {
                return false;
            }
            int halfSum = sum / 2;
            int[] dp = new int[halfSum + 1];
            // 初始化行
            for (int j = nums[0]; j <= halfSum; j++) {
                dp[j] = nums[0];
            }

            for (int i = 1; i < nums.length; i++) {
                for (int j = halfSum; j >= 1; j--) {
                    if (j >= nums[i]) {
                        dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                    }

                    // 找到
                    if (j == halfSum && dp[j] == halfSum) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
