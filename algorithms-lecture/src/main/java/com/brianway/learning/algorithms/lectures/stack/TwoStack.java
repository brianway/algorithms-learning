package com.brianway.learning.algorithms.lectures.stack;

import java.util.Stack;

/**
 * Created by brian on 16/11/9.
 *
 * 编写一个类,只能用两个栈结构实现队列,支持队列的基本操作(push，pop)。
 * 给定一个操作序列ope及它的长度n，其中元素为正数代表push操作，
 * 为0代表pop操作，保证操作序列合法且一定含pop操作，请返回pop的结果序列。
 *
 * 测试样例：
 * [1,2,3,0,4,0],6
 * 返回：[1,2]
 */
public class TwoStack {

    public int[] twoStack(int[] ope, int n) {
        if (ope == null || n == 0) {
            return null;
        }

        Stack<Integer> data = new Stack<Integer>();
        Stack<Integer> help = new Stack<Integer>();

        int popCounts = 0;
        for (int i = 0; i < n; i++) {
            if (ope[i] > 0) {
                data.push(ope[i]);
            } else {
                popCounts++;
            }
        }

        while (!data.isEmpty()) {
            help.push(data.pop());
        }

        int[] res = new int[popCounts];
        int i = 0;
        while (popCounts-- > 0) {
            res[i++] = help.pop();
        }

        return res;

    }

    public static void main(String[] args) {
        TwoStack ts = new TwoStack();
        int[] a = {1, 2, 3, 0, 4, 0};
        int[] b = ts.twoStack(a, a.length);
        for (int i : b) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
