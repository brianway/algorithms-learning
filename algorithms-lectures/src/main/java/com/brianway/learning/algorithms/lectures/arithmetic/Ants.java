package com.brianway.learning.algorithms.lectures.arithmetic;

/**
 * Created by brian on 16/11/19.
 *
 * n只蚂蚁从正n边形的n个定点沿着边移动，速度是相同的，问它们碰头的概率是多少？
 * 给定一个正整数n，请返回一个数组，其中两个元素分别为结果的分子和分母，请化为最简分数。
 *
 * 测试样例：
 * 3
 * 返回：[3,4]
 */
public class Ants {
    public int[] collision(int n) {
        int total = 1 << n;
        //int meet = total - 2;
        total /= 2;
        return new int[] {total - 1, total};
    }
}
