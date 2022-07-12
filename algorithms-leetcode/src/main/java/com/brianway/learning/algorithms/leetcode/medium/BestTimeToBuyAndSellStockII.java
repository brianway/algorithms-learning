package com.brianway.learning.algorithms.leetcode.medium;

/**
 * LeetCode 122. Best Time to Buy and Sell Stock II
 * Question: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 关键题设： can only hold at most one share, can buy it then immediately sell it on the same day.
 *
 * @auther brian
 * @since 2022/7/12 22:38
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        return 0;
    }

    /**
     * DP
     * <p>
     * 1. dp数字下标和含义：dp[i][0]表示第i天空仓（不持有股票）的最大收益，dp[i][1]表示第i天持仓（未卖出）的最大收益
     * 即，第i天只有两种状态，要么已清仓，要么还持有，这两种状态都对应一个最大收益。收益可能为负
     * 2. 递推关系：
     * dp[i][0]=max{dp[i-1][0], prices[i]+dp[i-1][1]}
     * dp[i][1]=max{dp[i-1][1], dp[i-1][0]-prices[i]}
     * <p>
     * dp[i][0]表示第i天空仓，要么第i-1天已经空仓了，要么第i-1天还持有，在第i天卖掉;
     * dp[i][1]表示第i天持有，要么第i-1天已经持有了，要么第i-1天是空仓的，在第i天买入，此时收益需要从dp[i-1][0]扣除当天价格
     * <p>
     * 3. 初始化：dp[0][0]=0 表示第0天不买或者买了就卖； dp[0][1]=-prices[0]
     * <p>
     * 4. 遍历顺序：从左到右
     */
    public static class BestTimeToBuyAndSellStockII0 extends BestTimeToBuyAndSellStockII {
        @Override
        public int maxProfit(int[] prices) {
            int[][] dp = new int[prices.length][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], prices[i] + dp[i - 1][1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }

            // 最后一天肯定是清仓收益高
            return dp[prices.length - 1][0];
        }
    }

    /**
     * DP, 滚动数组
     * 由于dp[i][0] 和 dp[i][1] 只和前一天有关，即 i-1 。所以不用数组，两个变量即可
     */
    public static class BestTimeToBuyAndSellStockII1 extends BestTimeToBuyAndSellStockII {
        @Override
        public int maxProfit(int[] prices) {
            int dp0 = 0, dp1 = -prices[0];
            int tmp0;
            for (int i = 1; i < prices.length; i++) {
                // 不直接赋值dp0,避免影响dp1的计算
                tmp0 = Math.max(dp0, prices[i] + dp1);
                // 等号右边的dp1,dp0都还是对应第i-1天的值
                dp1 = Math.max(dp1, dp0 - prices[i]);
                dp0 = tmp0;
            }

            // 最后一天肯定是清仓收益高
            return dp0;
        }
    }

}
