package com.brianway.learning.algorithms.lectures.dp;

/**
 * Created by brian on 16/11/20.
 *
 * 一个背包有一定的承重cap，有N件物品，每件都有自己的价值，记录在数组v中，
 * 也都有自己的重量，记录在数组w中，每件物品只能选择要装入背包还是不装入背包，
 * 要求在不超过背包承重的前提下，选出物品的总价值最大。
 * 给定物品的重量w价值v及物品数n和承重cap。请返回最大总价值。
 *
 * 测试样例：
 * [1,2,3],[1,2,3],3,6
 * 返回：6
 */
public class Backpack {
    public int maxValue(int[] w, int[] v, int n, int cap) {
        int[] max = new int[cap + 1];

        for (int i = 0; i < n; i++) {
            for (int j = cap; j >= w[i]; j--) {
                max[j] = Math.max(max[j], max[j - w[i]] + v[i]);
            }
        }

        return max[cap];
    }
}

/**
 * dp[i][j] 表示前 i 件物品达到不超过重量 j 时的最大价值
 */