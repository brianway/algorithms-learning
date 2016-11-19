package com.brianway.learning.algorithms.lectures.arithmetic;

import java.util.Random;

/**
 * Created by brian on 16/11/19.
 *
 * 给定一个以p概率产生0，以1-p概率产生1的随机函数RandomP::f()，p是固定的值，但你并不知道是多少。
 * 除此之外也不能使用任何额外的随机机制，请用RandomP::f()实现等概率随机产生0和1的随机函数。
 */
public class Random01 {
    private static double p = new Random().nextFloat();

    // 随机概率p
    public static int f() {
        return new Random().nextFloat() < p ? 0 : 1;
    }

    public int random01() {
        // 通过f函数实现01等概率返回
        int first;
        int second;
        while (true) {
            first = f();
            second = f();
            if (first != second) {
                break;
            }
        }

        return first;
    }
}
