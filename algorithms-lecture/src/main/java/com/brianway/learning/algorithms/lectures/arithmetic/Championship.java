package com.brianway.learning.algorithms.lectures.arithmetic;

import static com.brianway.learning.algorithms.lectures.arithmetic.Calculator.A;
import static com.brianway.learning.algorithms.lectures.arithmetic.Calculator.C;
import static com.brianway.learning.algorithms.lectures.arithmetic.Calculator.gcd;

/**
 * Created by brian on 16/11/19.
 *
 * 有2k只球队，有k-1个强队，其余都是弱队，随机把它们分成k组比赛，每组两个队，问两强相遇的概率是多大？
 * 给定一个数k，请返回一个数组，其中有两个元素，分别为最终结果的分子和分母，请化成最简分数
 *
 * 测试样例：
 * 4
 * 返回：[3,7]
 */
public class Championship {
    public int[] calc(int k) {
        int total = 1;
        for (int i = 2 * k - 1; i > 2; i = i - 2) {
            total *= i;
        }

        int qr = C(k + 1, k - 1) * A(k - 1, k - 1);
        int qq = total - qr;
        int g = gcd(total, qq);
        return new int[] {qq / g, total / g};
    }

    public static void main(String[] args) {
        Championship c = new Championship();
        int[] res = c.calc(4);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

}
