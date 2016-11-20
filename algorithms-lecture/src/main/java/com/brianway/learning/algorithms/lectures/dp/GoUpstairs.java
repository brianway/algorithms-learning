package com.brianway.learning.algorithms.lectures.dp;

/**
 * Created by brian on 16/11/20.
 *
 * 有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。
 * 为了防止溢出，请将结果Mod 1000000007
 * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
 *
 * 测试样例：
 * 1
 * 返回：1
 */
public class GoUpstairs {
    public int countWays(int n) {
        int pre = 1;
        int last = 2;
        if (n == 1 || n == 2) {
            return n;
        }
        int MOD = 1000000007;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = (pre + last) % MOD;
            pre = last;
            last = res;
        }
        return res;
    }
}
