package com.brianway.learning.algorithms.lectures.arithmetic;

/**
 * Created by brian on 16/11/18.
 *
 * 在XxY的方格中，以左上角格子为起点，右下角格子为终点，每次只能向下走或者向右走，请问一共有多少种不同的走法
 * 给定两个正整数int x,int y，请返回走法数目。保证x＋y小于等于12。
 *
 * 测试样例：
 * 2,2
 * 返回：2
 */
public class Robot {
    public int countWays(int x, int y) {
        --x;
        --y;
        int k = 1;
        int m = Math.min(x, y);

        for (int i = x + y; i > x + y - m; i--) {
            k = k * i;
        }
        for (int i = 1; i <= m; i++) {
            k = k / i;
        }

        return k;
    }

    public static void main(String[] args) {
        Robot r = new Robot();
        System.out.println(r.countWays(3, 4));
    }
}
