package com.brianway.learning.algorithms.lectures.arithmetic;

import java.util.Random;

/**
 * Created by brian on 16/11/19.
 *
 * 有一个机器按自然数序列的方式吐出球，1号球，2号球，3号球等等。
 * 你有一个袋子，袋子里最多只能装下K个球，并且除袋子以外，
 * 你没有更多的空间，一个球一旦扔掉，就再也不可拿回。
 * 设计一种选择方式，使得当机器吐出第N号球的时候，你袋子中的球数是K个，
 * 同时可以保证从1号球到N号球中的每一个，被选进袋子的概率都是K/N。
 *
 * 举一个更具体的例子，有一个只能装下10个球的袋子，当吐出100个球时，袋子里有10 球，
 * 并且1~100号中的每一个球被选中的概率都是10/100。
 * 然后继续吐球，当吐出1000个球时，袋子里有 10 个球，
 * 并且1~1000号中的每一个球被选中的概率都是10/1000。继续吐球，
 * 当吐出i个球时，袋子里有10个球，并且1~i号中的每一个球被选中的概率都是10/i。
 * 也就是随着N的变化，1~N号球被选中的概率动态变化成k/N。
 * 请将吐出第N个球时袋子中的球的编号返回。
 */
public class Bag {

    private int[] selected = null;
    private static Random rand = new Random(12345);

    // 每次拿一个球都会调用这个函数，N表示第i次调用
    public int[] carryBalls(int N, int k) {
        if (selected == null) {
            selected = new int[k];
        }
        if (N < k) {
            selected[N - 1] = N;
        } else {
            if (rand.nextInt(N) < k) {
                selected[rand.nextInt(k)] = N;
            }
        }

        return selected;
    }
}