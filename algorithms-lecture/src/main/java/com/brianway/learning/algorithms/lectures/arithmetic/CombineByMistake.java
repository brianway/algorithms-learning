package com.brianway.learning.algorithms.lectures.arithmetic;

/**
 * Created by brian on 16/11/19.
 *
 * 有n个信封，包含n封信，现在把信拿出来，再装回去，要求每封信不能装回它原来的信封，问有多少种装法?
 * 给定一个整数n，请返回装发个数，为了防止溢出，请返回结果Mod 1000000007的值。保证n的大小小于等于300。
 *
 * 测试样例：
 * 2
 * 返回：1
 */
public class CombineByMistake {
    public int countWays(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        int mod = 1000000007;
        int pre = 0;
        int last = 1;
        long tmp = 0;
        for (int i = 3; i <= n; i++) {
            tmp = (long) (i - 1) * (pre + last) % mod;
            pre = last;
            last = (int) tmp;
        }
        return last;

    }

    public static void main(String[] args) {
        CombineByMistake cbm = new CombineByMistake();
        System.out.println(cbm.countWays(4));
    }
}

