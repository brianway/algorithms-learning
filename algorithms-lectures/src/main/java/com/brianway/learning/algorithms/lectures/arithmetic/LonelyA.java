package com.brianway.learning.algorithms.lectures.arithmetic;

/**
 * Created by brian on 16/11/18.
 *
 * A(A也是他的编号)是一个孤傲的人，在一个n个人(其中编号依次为1到n)的队列中，
 * 他于其中的标号为b和标号c的人都有矛盾，所以他不会和他们站在相邻的位置。
 * 现在问你满足A的要求的对列有多少种？
 * 给定人数n和三个人的标号A,b和c，请返回所求答案，保证人数小于等于11且大于等于3。
 *
 * 测试样例：
 * 6,1,2,3
 * 288
 */
public class LonelyA {
    public int getWays(int n, int A, int b, int c) {
        int all = 1;
        for (int i = 1; i <= n; i++) {
            all *= i;
        }

        int ab = 2;
        for (int i = 1; i <= n - 1; i++) {
            ab *= i;
        }
        int ac = ab;

        int abc = 2;
        for (int i = 1; i <= n - 2; i++) {
            abc *= i;
        }

        return all - ab - ac + abc;

    }

    public static void main(String[] args) {
        LonelyA la = new LonelyA();
        System.out.println(la.getWays(6, 1, 2, 3));
        System.out.println(la.getWays(3, 1, 2, 3));
    }
}
