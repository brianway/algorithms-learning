package com.brianway.learning.algorithms.lectures.stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by brian on 16/11/9.
 *
 * 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），
 * 要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
 * 给定一个int[] numbers(C++中为vector<int>)，其中第一个元素为栈顶，
 * 请返回排序后的栈。请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
 *
 * 测试样例：
 * [1,2,3,4,5]
 * 返回：[5,4,3,2,1]
 */
public class TwoStacks {
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }

        Stack<Integer> stack = new Stack<Integer>();

        for (int i = numbers.length - 1; i >= 0; i--) {
            stack.push(numbers[i]);
        }

        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<Integer> help = new Stack<Integer>();

        while (!stack.isEmpty()) {
            int current = stack.pop();
            while (!help.isEmpty() && help.peek() > current) {
                stack.push(help.pop());
            }
            help.push(current);
        }

        while (!help.isEmpty()) {
            res.add(help.pop());
        }
        return res;

    }

    public static void main(String[] args) {
        TwoStacks sr = new TwoStacks();
        int[] a = {1, 2, 3, 4, 5};
        //int[] a = {2, 1, 4, 3, 5};
        ArrayList<Integer> b = sr.twoStacksSort(a);
        for (int i : b) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
