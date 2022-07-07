package com.brianway.learning.algorithms.leetcode.medium;

/**
 * 518. Coin Change 2
 * Question: https://leetcode.com/problems/coin-change-2/
 * 关键题设：All the values of coins are unique.
 *
 * @auther brian
 * @since 2022/6/23 22:55
 */
public class CoinChange2 {
    public int change(int amount, int[] coins) {
        return 0;
    }

    /**
     * DP, 完全背包
     * 1. dp数组下标以及含义：dp[i][j]表示用coins中 0～i个元素任意选取任意个，金额为j时的组合个数
     * 2. 递推关系：dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]]
     * dp[i-1][j]表示不使用coins[i]时的组合个数，
     * dp[i][j-coins[i]]表示金额j-coins[i]的组合个数，在金额j-coins[i]的基础上搭配一个coins[i]即可达到金额j
     * 3. 初始化: dp[i][0]=1 表示金额0的组合格式为1，即全部都不取。
     * dp[0][j]= j%coins[0]== 0 ? 1 : 0，也可以用递推关系初始化 dp[0][j] = dp[0][j-coins[0]]
     * 4. 遍历顺序：从左到右
     */
    public static class CoinChange2_1 extends CoinChange2 {
        @Override
        public int change(int amount, int[] coins) {
            int[][] dp = new int[coins.length][amount + 1];
            // 初始化
            for (int i = 0; i < coins.length; i++) {
                dp[i][0] = 1;
            }
            for (int j = coins[0]; j <= amount; j++) {
                // dp[0][j] = j % coins[0] == 0 ? 1 : 0;
                dp[0][j] = dp[0][j - coins[0]];
            }

            for (int i = 1; i < coins.length; i++) {
                for (int j = 1; j <= amount; j++) {
                    if (j >= coins[i]) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            return dp[coins.length - 1][amount];

        }
    }

    /**
     * DP，滚动数组写法
     * 1. dp数组下标以及含义：dp[j]表示用coins中 0～i个元素任意选取任意个，金额为j时的组合个数
     * 2. 递推关系：dp[j] = dp[j] + dp[j-coins[i]]
     * 右边的dp[j]表示不使用coins[i]时的组合个数，
     * dp[j-coins[i]]表示金额j-coins[i]的组合个数，在金额j-coins[i]的基础上搭配一个coins[i]即可达到金额j
     * 两者只和即为新的dp[j]
     * 3. 初始化: dp[0]=1 表示金额0的组合格式为1，即全部都不取。
     * dp[j]= j%coins[0]== 0 ? 1 : 0，也可以用递推关系初始化 dp[j] = dp[j-coins[0]]
     * 4. 遍历顺序：从左到右
     */
    public static class CoinChange2_2 extends CoinChange2 {
        @Override
        public int change(int amount, int[] coins) {
            int[] dp = new int[amount + 1];
            dp[0] = 1;
            for (int i = 0; i < coins.length; i++) {
                for (int j = coins[i]; j <= amount; j++) {
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }
            return dp[amount];
        }
    }
}
