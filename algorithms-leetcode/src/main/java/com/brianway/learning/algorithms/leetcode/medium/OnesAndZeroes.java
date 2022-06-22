package com.brianway.learning.algorithms.leetcode.medium;

/**
 * LeetCode 474. Ones and Zeroes
 * Question: https://leetcode.com/problems/ones-and-zeroes/
 * 关键题设:  at most m 0's and n 1's in the subset.
 *
 * @auther brian
 * @since 2022/6/22 23:18
 */
public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        return 0;
    }

    /**
     * DP，01背包问题变形
     * 思路：
     * 背包重量的约束从一个维度变成了两种字符的上限，两个维度；
     * 背包物品就是strs中的元素；
     * 物品价值都是1，即对subset的长度贡献
     * <p>
     * 1. dp数组下标和含义： dp[i][j][k] 表示strs中 0～i个元素任意选取，满足最多j个`0`且最多k个`1`的subset的多大长度
     * 2. 递推公式：对于strs[i], 假设 strs[i]的0有zeros个，1有ones个
     * - 当第i个元素的zeros和ones均没超过上限时（即题设中m,n），dp[i][j][k] 为 选取strs[i]和不选strs[i]的大者：
     * dp[i][j][k]  = max{dp[i-1][j][k], dp[i-1][j-zeros][k-ones]+1}
     * - 当第i个元素的zeros和ones至少一个超过上限时，表示不能取 strs[i],
     * dp[i][j][k] = dp[i-1][j][k]
     * 3. 初始化：j=0或者k=0, dp[i][j][k]=0 ;
     * i=0时，dp[0][j][k]
     * 4. 遍历顺序：i,j,k, 从小到大遍历
     */
    public static class OnesAndZeroes0 extends OnesAndZeroes {
        @Override
        public int findMaxForm(String[] strs, int m, int n) {
            int[][][] dp = new int[strs.length][m + 1][n + 1];

            // i=0
            int zeros = countZeros(strs[0]);
            int ones = strs[0].length() - zeros;
            for (int j = 0; j < m + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    // 没超过上限，选取第0个元素
                    if (zeros <= j && ones <= k) {
                        dp[0][j][k] = 1;
                    }
                }
            }

            for (int i = 1; i < strs.length; i++) {
                // 第i个元素
                zeros = countZeros(strs[i]);
                ones = strs[i].length() - zeros;
                for (int j = 0; j < m + 1; j++) {
                    for (int k = 0; k < n + 1; k++) {
                        // 没超过上限
                        if (zeros <= j && ones <= k) {
                            dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                        } else {
                            // 超过上限，不能选第i个元素
                            dp[i][j][k] = dp[i - 1][j][k];
                        }
                    }
                }
            }

            return dp[strs.length - 1][m][n];

        }

        public int countZeros(String str) {
            int zeros = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    zeros++;
                }
            }
            return zeros;
        }
    }
}