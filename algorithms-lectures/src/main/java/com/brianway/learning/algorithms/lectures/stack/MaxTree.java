package com.brianway.learning.algorithms.lectures.stack;

import java.util.Stack;

/**
 * Created by brian on 16/11/9.
 *
 * 对于一个没有重复元素的整数数组，请用其中元素构造一棵MaxTree，
 * MaxTree定义为一棵二叉树，其中的节点与数组元素一一对应，
 * 同时对于MaxTree的每棵子树，它的根的元素值为子树的最大值。
 * 现有一建树方法，对于数组中的每个元素，
 * 其在树中的父亲为数组中它左边比它大的第一个数和右边比它大的第一个数中更小的一个。
 * 若两边都不存在比它大的数，那么它就是树根。请设计O(n)的算法实现这个方法。
 * 给定一个无重复元素的数组A和它的大小n，请返回一个数组，
 * 其中每个元素为原数组中对应位置元素在树中的父亲节点的编号，若为根则值为-1。
 *
 * 测试样例：
 * [3,1,4,2],4
 * 返回：[2,0,-1,2]
 */
public class MaxTree {
    public int[] buildMaxTree(int[] A, int n) {
        if (A == null || n == 0) {
            return null;
        }

        int[] res = new int[n];
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                int current = stack.pop();
                if (stack.isEmpty() || A[stack.peek()] > A[i]) {
                    res[current] = i;
                } else {
                    res[current] = stack.peek();
                }
            }

            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }
            stack.push(i);

        }

        return res;

    }

    public static void main(String[] args) {
        MaxTree mt = new MaxTree();
        int[] a = {3, 1, 4, 2};
        int[] b = mt.buildMaxTree(a, a.length);
        for (int i : b) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
