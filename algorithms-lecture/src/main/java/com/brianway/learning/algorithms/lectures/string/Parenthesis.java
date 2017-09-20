package com.brianway.learning.algorithms.lectures.string;

/**
 * Created by brian on 16/11/9.
 *
 * 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
 * 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
 * 测试样例：
 * "(()())",6
 * 返回：true
 * 测试样例：
 * "()a()()",7
 * 返回：false
 * 测试样例：
 * "()(()()",7
 * 返回：false
 */
public class Parenthesis {

    public boolean chkParenthesis(String A, int n) {
        if (A == null || n == 0) {
            return false;
        }
        char[] s = A.toCharArray();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] != '(' && s[i] != ')') {
                return false;
            }

            if (s[i] == '(') {
                count++;
            }
            if (s[i] == ')' && --count < 0) {
                return false;
            }

        }

        return count == 0;
    }

    public static void main(String[] args) {
        Parenthesis p = new Parenthesis();
        boolean b;
        b = p.chkParenthesis("(()())", 6);
        System.out.println(b);
        b = p.chkParenthesis("()a()()", 7);
        System.out.println(b);
        b = p.chkParenthesis("()(()()", 7);
        System.out.println(b);
    }
}
