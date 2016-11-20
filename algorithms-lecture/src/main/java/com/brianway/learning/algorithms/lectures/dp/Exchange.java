package com.brianway.learning.algorithms.lectures.dp;

/**
 * Created by brian on 16/11/20.
 *
 * 有数组penny，penny中所有的值都为正数且不重复。
 * 每个值代表一种面值的货币，每种面值的货币可以使用任意张，
 * 再给定一个整数aim(小于等于1000)代表要找的钱数，求换钱有多少种方法。
 * 给定数组penny及它的大小(小于等于50)，同时给定一个整数aim，
 * 请返回有多少种方法可以凑成aim。
 *
 * 测试样例：
 * [1,2,4],3,3
 * 返回：2
 */
public class Exchange {
    public int countWays(int[] penny, int n, int aim) {
        if (penny == null || aim < 0) {
            throw new RuntimeException("error param");
        }
        int[] aims = new int[aim + 1];
        aims[0] = 1;
        // f[i][j] = f[i][j-penny[i]];
        // aims[j] = f[i-1][j] ---> aims[j] = f[i][j]
        for (int i = 0; i < n; i++) {
            for (int j = penny[i]; j <= aim; j++) {
                aims[j] = aims[j] + aims[j - penny[i]];
            }
        }

        return aims[aim];
    }
}

/*
* 解题:
*
* f[i][j] 表示使用 penny[0]~penny[i] 来凑成钱数 j 的方法数
* 则 第一行f[0][j] 表示使用 penny[0] 凑成钱数 j 的方法数
*    第一列f[i][0] 表示使用 penny[0...i] 凑成钱数 0 的方法数,显然均为 1(即一张不拿)
*
* f[i][j] = f[i-1][j]+f[i-1][j-penny[i]]+f[i-1][j-2*penny[i]]+……+f[i-1][j-k*penny[i]]
* 每次遍历上一行,依次取出使用 0,1,...2 张 penny[i] 后,使用penny[0]~penny[i-1]的方法数
*
* 从计算过程可知,有重复计算累加,简化可得
* f[i][j] = f[i][j-penny[i]]+f[i-1][j]
*
* */