package com.brianway.learning.algorithms.leetcode.easy;

/**
 * LeetCode 121. Best Time to Buy and Sell Stock
 * Question https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 关键题设：different day in the future
 *
 * @auther brian
 * @since 2022/4/18 21:27
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        return 0;
    }

    /**
     * 解法1，思路：
     * 使用额外的空间(int [] mins)存储每天的历史股票最低价,
     * mins[i] 表示第i天(含)及以前，股票出现过的最低价
     * 则第i天的利润就是 price[i]-min[i-1]，因为题设要求different day in the future，
     * <p>
     * PS：即使题设没禁止当天（即允许当天买卖）：
     * 如果当天股价是历史最低（即price[i]<=mins[i-1] ），则当天卖出的profit肯定为0(题设不允许为负)；
     * 如果当天股价不是历史最低（即price[i]>mins[i-1] ），则当天卖出最大利润还是 price[i]-min[i-1]
     * <p>
     * 时间复杂度 O(n)
     * 空间复杂度 O(n) 额外使用了长度为n的数据存储每天的历史股票最低价
     */
    public class BestTimeToBuyAndSellStock0 extends BestTimeToBuyAndSellStock {
        @Override
        public int maxProfit(int[] prices) {
            int[] mins = new int[prices.length];
            // first day
            mins[0] = prices[0];

            // 初始化购买最低价数组
            for (int i = 1; i < prices.length; i++) {
                mins[i] = Math.min(mins[i - 1], prices[i]);
            }

            // 计算
            int maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                maxProfit = Math.max(prices[i] - mins[i - 1], maxProfit);
            }
            return maxProfit;
        }
    }

    /**
     * 解法2: 贪心，一次遍历
     * <p>
     * 取最左最小值，取最右最大值，那么得到的差值就是最大利润
     * <p>
     * minBuyPrice 记录每次截止第i天时，股票出现过的最低价
     * <p>
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public class BestTimeToBuyAndSellStock1 extends BestTimeToBuyAndSellStock {
        @Override
        public int maxProfit(int[] prices) {
            int maxProfit = 0;
            int minBuyPrice = Integer.MAX_VALUE;
            for (int i = 0; i < prices.length; i++) {
                maxProfit = Math.max(maxProfit, prices[i] - minBuyPrice);
                minBuyPrice = Math.min(minBuyPrice, prices[i]);
            }
            return maxProfit;
        }
    }

    /**
     * 空间复杂度O(1)解法，和解法2类似
     * 记录下标 vs. 记录price
     * <p>
     * minPriceDay 记录每次截止第i天时，股票出现最低价是第几天
     * <p>
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public class BestTimeToBuyAndSellStock2 extends BestTimeToBuyAndSellStock {
        @Override
        public int maxProfit(int[] prices) {
            int maxProfit = 0;
            int minPriceDay = 0;
            for (int i = 0; i < prices.length; i++) {
                maxProfit = Math.max(maxProfit, prices[i] - prices[minPriceDay]);
                minPriceDay = prices[i] < prices[minPriceDay] ? i : minPriceDay;
            }
            return maxProfit;
        }
    }

    // TODO 单调栈解法， 参考本地的cookboo-Leecode.pdf
}
