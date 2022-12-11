package com.brianway.learning.algorithms.leetcode.medium;

import java.util.Stack;

/**
 * LeetCode 155. Min Stack
 * Question: https://leetcode.com/problems/min-stack/
 * 关键题设：in constant time.
 *
 * @auther brian
 * @since 2022/12/11 21:41
 */
public class MinStack {

    /**
     * 原始栈
     */
    Stack<Integer> stack = new Stack<>();
    /**
     * 最小值栈
     */
    Stack<Integer> min = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        stack.push(val);
        if (min.empty() || min.peek() > val) {
            min.push(val);
        } else {
            int minVal = min.peek();
            min.push(minVal);
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
