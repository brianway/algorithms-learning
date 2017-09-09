package com.brianway.learning.algorithms.leetcode.easy;

/**
 * Created by brian on 2017/9/9.
 * LeetCode 70. Climbing Stairs
 * Question:https://leetcode.com/problems/climbing-stairs/description/
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        return 0;
    }

    /**
     * 递归
     * 在每一个台阶，要么是从 n-1 上 1 步过来的，要么是从 n-2 上两步过来的
     * 所以 f(n) = f(n-1) + f(n-2)
     *
     * 超时。
     */
    public class ClimbingStairs0 extends ClimbingStairs {
        @Override
        public int climbStairs(int n) {
            if (n == 1) return 1;
            if (n == 2) return 2;
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    /**
     * 动态规划
     * result[i] (1<=i<=n)表示到达这个台阶的互异的方法数
     * result[i] = result[i - 1] + result[i - 2], i>2
     *
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public class ClimbingStairs1 extends ClimbingStairs {
        @Override
        public int climbStairs(int n) {
            if (n < 3) return n;
            int[] result = new int[n + 1];
            result[1] = 1;
            result[2] = 2;
            for (int i = 3; i <= n; i++) {
                result[i] = result[i - 1] + result[i - 2];
            }
            return result[n];
        }
    }

    /**
     * 简化版的动态规划
     * 由于每次只用到了最近的几个变量，所以不用保存整个数组
     *
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public class ClimbingStairs2 extends ClimbingStairs {
        @Override
        public int climbStairs(int n) {
            if (n < 3) return n;
            int a = 1;// 代表 n-2
            int b = 2;// 代表 n-1
            int c = 3;// 代表 n
            for (int i = 3; i <= n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }

}
