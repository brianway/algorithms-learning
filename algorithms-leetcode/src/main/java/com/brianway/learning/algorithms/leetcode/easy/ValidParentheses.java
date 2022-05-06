package com.brianway.learning.algorithms.leetcode.easy;

import java.util.Stack;

/**
 * LeetCode 20. Valid Parentheses
 * Question:https://leetcode.com/problems/valid-parentheses/description/
 * 关键题设：无
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        return false;
    }

    /**
     * 栈来存
     * 左括号直接入栈，右括号则看是否和栈顶元素匹配
     * 注意事项：栈为空时，需要判断，要避免 java.util.EmptyStackException
     * <p>
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public class ValidParentheses0 extends ValidParentheses {
        @Override
        public boolean isValid(String s) {
            if (s == null || s.isEmpty()) {
                return true;
            }
            char[] chars = s.toCharArray();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < chars.length; i++) {
                if (isLeftParentheses(chars[i])) {
                    stack.push(chars[i]);
                } else if (isRightParentheses(chars[i])) {
                    if (stack.isEmpty() || !match(stack.pop(), chars[i])) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }

        private boolean isLeftParentheses(char c) {
            return c == '(' || c == '[' || c == '{';
        }

        private boolean isRightParentheses(char c) {
            return c == ')' || c == ']' || c == '}';
        }

        private boolean match(char left, char right) {
            return left == '(' && right == ')' || left == '[' && right == ']' || left == '{' && right == '}';
        }
    }

}
