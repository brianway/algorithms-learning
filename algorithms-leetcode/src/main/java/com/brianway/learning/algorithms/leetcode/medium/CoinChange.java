package com.brianway.learning.algorithms.leetcode.medium;

/**
 * 322. Coin Change
 * Question: https://leetcode.com/problems/coin-change/
 * 关键题设：Return the fewest number of coins
 *
 * @auther brian
 * @since 2022/6/23 22:55
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        return 0;
    }

    /**
     * DP，完全背包
     * <p>
     * 1. dp数组下标和含义：dp[i][j]表示用coins中 0～i个元素任意选取任意个，金额为j时的最小coin个数
     * 2. 递推公式: dp[i][j]=min{dp[i][j-coins[i]]+1, dp[i-1][j]}
     * (当dp[i][j-coins[i]]和dp[i-1][j]都不是-1时， 取min{dp[i][j-coins[i]]+1, dp[i-1][j]}
     * 当dp[i][j-coins[i]]!=-1，且dp[i-1][j] == -1时， 取dp[i][j-coins[i]]+1，
     * 否则 取dp[i-1][j])
     * 3. 初始化: dp[i][0]=0，表示金额为0时硬币个数为0；当j是coins[i]的倍数时， dp[0][j]=j/coins[i]，否则dp[0][j]=-1
     * 4. 遍历顺序：从左到右
     * <p>
     * 注意：-1表示没有这样的组合，0表示amount是0
     */
    public static class CoinChange0 extends CoinChange {
        @Override
        public int coinChange(int[] coins, int amount) {
            int[][] dp = new int[coins.length][amount + 1];
            // 初始化
            for (int i = 0; i < coins.length; i++) {
                dp[i][0] = 0;
            }
            for (int j = 1; j <= amount; j++) {
                dp[0][j] = j % coins[0] == 0 ? j / coins[0] : -1;
            }

            for (int i = 1; i < coins.length; i++) {
                for (int j = 1; j <= amount; j++) {
                    if (j < coins[i] || dp[i][j - coins[i]] == -1) {
                        dp[i][j] = dp[i - 1][j];
                    } else if (dp[i][j - coins[i]] >= 0 && dp[i - 1][j] >= 0) {
                        dp[i][j] = Math.min(dp[i][j - coins[i]] + 1, dp[i - 1][j]);
                    } else if (dp[i][j - coins[i]] >= 0) {
                        dp[i][j] = dp[i][j - coins[i]] + 1;
                    } else {
                        // 两个路径都是-1
                        dp[i][j] = -1;
                    }
                }
            }

            // 硬币数不大于0表示没有这种组合
            return dp[coins.length - 1][amount];
        }
    }

    /**
     * DP，滚动数组写法
     * 1. dp数组下标和含义：dp[j]表示用coins中 0～i个元素任意选取任意个，金额为j时的最小coin个数
     * 2. 递推公式: dp[j]=min{dp[j-coins[i]]+1, dp[j]}
     * (当dp[j-coins[i]]和dp[j]都不是-1时，才有求min的必要，
     * 否则，当 dp[j-coins[i]] != -1 &&  dp[j]==-1时， 取 dp[j-coins[i]]+1，
     * 当dp[j-coins[i]] == -1时，dp[j]不变即可)
     * <p>
     * 3. 初始化: dp[0]=0，表示金额为0时硬币个数为0；当j是coins[i]的倍数时， dp[j]=j/coins[i]，否则dp[j]=-1
     * 4. 遍历顺序：从左到右
     */
    public static class CoinChange1 extends CoinChange {
        @Override
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            // 初始化
            for (int j = 1; j <= amount; j++) {
                dp[j] = j % coins[0] == 0 ? j / coins[0] : -1;
            }
            // 金额为0时硬币个数为0
            dp[0] = 0;
            for (int i = 1; i < coins.length; i++) {
                for (int j = coins[i]; j <= amount; j++) {
                    if (dp[j - coins[i]] != -1) {
                        dp[j] = (dp[j] == -1) ? (dp[j - coins[i]] + 1) : Math.min(dp[j - coins[i]] + 1, dp[j]);
                    }
                }
            }
            return dp[amount];
        }
    }

    /**
     * DP，写法3
     * 同解法CoinChange1，只是初始化不同
     * <p>
     * 初始化：dp[j]=-1，表示默认没这样的组合, dp[0]=0,表示金额为0时硬币个数为0；
     */
    public static class CoinChange2 extends CoinChange {
        @Override
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            // 初始化
            for (int j = 1; j <= amount; j++) {
                dp[j] = -1;
            }
            // 金额为0时硬币个数为0
            dp[0] = 0;
            for (int i = 0; i < coins.length; i++) {
                for (int j = coins[i]; j <= amount; j++) {
                    if (dp[j - coins[i]] != -1) {
                        dp[j] = (dp[j] == -1) ? (dp[j - coins[i]] + 1) : Math.min(dp[j - coins[i]] + 1, dp[j]);
                    }
                }
            }
            return dp[amount];
        }

    }

}
