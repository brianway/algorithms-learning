package com.brianway.learning.algorithms.lectures.arithmetic;

/**
 * Created by brian on 16/11/19.
 *
 * 计算排列组合的类
 */
public class Calculator {
    public static int A(int n, int k) {
        int result = 1;
        for (int i = n; i > n - k; i--) {
            result *= i;
        }

        return result;
    }

    public static int C(int n, int m) {
        int result = 1;
        for (int i = n; i > n - m; i--) {
            result *= i;
        }
        for (int i = 1; i <= m; i++) {
            result /= i;
        }

        return result;
    }

    //greatest common divisors
    public static int gcd(int x, int y) {
        int t;
        while (y > 0) {
            t = y;
            y = x % y;
            x = t;
        }
        return x;
    }

    public static void main(String[] args) {
        int a = Calculator.A(8, 4);
        int c = Calculator.C(8, 2);

        System.out.println(a);
        System.out.println(c);

        int n = 10;
        int m = 4;
        System.out.println(C(n, m) == (A(n, n) / A(m, m) / A(n - m, n - m)));

        System.out.println(gcd(6, 9));
    }
}
