package com.brianway.learning.algorithms.leetcode.medium;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode 150. Evaluate Reverse Polish Notation
 * Question: https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * 关键题设：无
 *
 * @auther brian
 * @since 2022/8/16 22:02
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        return 0;
    }

    public class EvaluateReversePolishNotation0 extends EvaluateReversePolishNotation {
        @Override
        public int evalRPN(String[] tokens) {
            Stack<Integer> numbers = new Stack<>();
            for (int i = 0; i < tokens.length; i++) {
                if (isOperator(tokens[i])) {
                    // 是操作符
                    int right = numbers.pop();
                    int left = numbers.pop();
                    int result = calculate(left, right, tokens[i]);
                    numbers.push(result);
                } else {
                    // 是操作数
                    int number = Integer.parseInt(tokens[i]);
                    numbers.push(number);
                }
            }
            return numbers.pop();
        }

        private boolean isOperator(String op) {
            List<String> operators = Arrays.asList("+", "-", "*", "/");
            return operators.contains(op);
        }

        private int calculate(Integer left, Integer right, String op) {
            switch (op) {
                case "+":
                    return left + right;
                case "-":
                    return left - right;
                case "*":
                    return left * right;
                case "/":
                    return left / right;
                default:
                    return 0;
            }
        }
    }
}
