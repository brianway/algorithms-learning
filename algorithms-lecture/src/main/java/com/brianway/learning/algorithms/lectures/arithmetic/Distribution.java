package com.brianway.learning.algorithms.lectures.arithmetic;

/**
 * Created by brian on 16/11/18.
 *
 * n颗相同的糖果，分给m个人，每人至少一颗，问有多少种分法。
 * 给定n和m，请返回方案数，保证n小于等于12，且m小于等于n。
 * 测试样例：
 *
 * 10,3
 * 返回：36
 */
public class Distribution {
    public int getWays(int n, int m) {
        n--;
        m--;
        int r = 1;
        for (int i = n; i > n - m; i--) {
            r *= i;
        }
        for (int i = 1; i <= m; i++) {
            r /= i;
        }

        return r;
    }
}
