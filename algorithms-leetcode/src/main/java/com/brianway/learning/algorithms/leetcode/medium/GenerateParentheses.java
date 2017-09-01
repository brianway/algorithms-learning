package com.brianway.learning.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Brian on 2017/9/1.
 * LeetCode 22. Generate Parentheses
 * Question: https://leetcode.com/problems/generate-parentheses/description/
 * 关键题设：all combinations of well-formed parentheses
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        return null;
    }

    /**
     * 二叉树深度遍历的思路：
     * 对于每个节点，加"("则作为子节点，加")"则作为右节点，遍历二叉树即可
     *
     * 注意事项：
     * 剩余的"("的个数必须小于或者等于")"的个数
     *
     * 时间复杂度：O(2^n)
     * 空间复杂度 O(n)
     *
     * 树结构如下图：
     *
     * ""
     * ／
     * '('
     * /           \
     * '(('           '()'
     * /     \           |
     * '((('    '(()'     '()('
     *
     * ...      ...       ...
     */
    public class GenerateParentheses0 extends GenerateParentheses {
        @Override
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            generateParenthesis(result, "", n, n);
            return result;
        }

        private void generateParenthesis(List<String> result, String prefix, int left, int right) {
            if (right < left) {
                return;
            }
            if (left == 0 && right == 0) {
                result.add(prefix);
                return;
            }
            if (left > 0) {
                generateParenthesis(result, prefix + "(", left - 1, right);
            }
            if (right > 0) {
                generateParenthesis(result, prefix + ")", left, right - 1);
            }
        }

    }

    /**
     * 失败的思路：递推
     *
     * 对于 n-1 的每个 solution S
     * n 的 solution 只能是这三种： ()S,(S),S()
     * 所以用一个 Set 来储存 n 的所有 solution 避免重复即可
     *
     * 失败的原因：n-1 -> n 的递推关系不对，会漏掉一些情况
     *
     * 反例子：n=4
     * 输出：["()()()()","(()())()","(()(()))","()()(())","(((())))","(())()()","()((()))","()(())()","()(()())","(()()())","((()()))","((()))()","((())())"]
     * 正确答案：["(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"]
     *
     * 少了一个 "(())(())"
     */
    @Deprecated
    public class GenerateParentheses1 extends GenerateParentheses {
        @Override
        public List<String> generateParenthesis(int n) {
            Set<String> next = new HashSet<>();
            Set<String> result = new HashSet<>();
            result.add("");
            for (int i = 0; i < n; i++) {
                for (String s : result) {
                    next.add("()" + s);
                    next.add("(" + s + ")");
                    next.add(s + "()");
                }
                result = next;
                next = new HashSet<>();
            }
            return new ArrayList<>(result);
        }
    }
}
