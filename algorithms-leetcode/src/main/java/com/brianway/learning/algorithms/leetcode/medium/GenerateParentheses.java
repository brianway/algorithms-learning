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
     * 回溯的思路，画出递归树
     * 对于每个节点，加"("则作为左节点，加")"则作为右节点，则最后一层的叶子节点的集合就是最终的解
     * <p>
     * 注意事项：
     * 剩余的"("的个数必须小于或者等于")"的个数，可以利用这一点来减枝
     * <p>
     * 时间复杂度：O(2^n)
     * 空间复杂度 O(n)
     * <p>
     * 树结构如下图：
     * <p>
     * ""
     * ／
     * '('
     * /           \
     * '(('           '()'
     * /     \           |
     * '((('    '(()'     '()('
     * <p>
     * ...      ...       ...
     */
    public static class GenerateParentheses0 extends GenerateParentheses {
        @Override
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            generateParenthesis(result, "", n, n);
            return result;
        }

        /**
         * @param result 保存最终所有组合情况的结果集，每个元素是一种组合
         * @param prefix 本次组合的中间结果
         * @param left   左括号剩余个数
         * @param right  右括号剩余个数
         */
        private void generateParenthesis(List<String> result, String prefix, int left, int right) {
            // 减枝，右括号剩的少说明是非法组合，直接返回，不加入结果集
            if (right < left) {
                return;
            }

            // 所有括号都用完了，一定是合法的，加入结果集
            if (left == 0 && right == 0) {
                result.add(prefix);
                return;
            }

            // 当前 append 左括号，递归
            if (left > 0) {
                generateParenthesis(result, prefix + "(", left - 1, right);
            }

            // 当前 append 右括号，递归
            if (right > 0) {
                generateParenthesis(result, prefix + ")", left, right - 1);
            }
        }

    }

    /**
     * 失败的思路：递推
     * <p>
     * 对于 n-1 的每个 solution S
     * n 的 solution 只能是这三种： ()S,(S),S()
     * 所以用一个 Set 来储存 n 的所有 solution 避免重复即可
     * <p>
     * 失败的原因：n-1 -> n 的递推关系不对，会漏掉一些情况， 即 ()不一定加载S外部，也是可以加在S内的
     * <p>
     * 反例子：n=4
     * 输出：["()()()()","(()())()","(()(()))","()()(())","(((())))","(())()()","()((()))","()(())()","()(()())","(()()())","((()()))","((()))()","((())())"]
     * 正确答案：["(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"]
     * <p>
     * 少了一个 "(())(())"
     */
    @Deprecated
    public static class GenerateParentheses1 extends GenerateParentheses {
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

    /**
     * 递推
     * 括号有n对时，可以看是是在括号n-1对的基础上加了一对()达成的。
     * 对于n-1时的排列组合，假设p+q=n-1， p、q取值范围都是[0,n-1]，则()可以加在n-1的排列组合的任意位置。
     * 所以 递推关系为：
     * "(" + 【i=p时所有括号的排列组合】 + ")" + 【i=q时所有括号的排列组合】
     * <p>
     * 中间可能有重复的，使用集合来去重即可
     */
    public static class GenerateParentheses2 extends GenerateParentheses {
        /**
         * 缓存中间结果
         */
        private Set<String>[] cache = new Set[] {};

        @Override
        public List<String> generateParenthesis(int n) {
            cache = new Set[n + 1];
            return new ArrayList<>(generate(n));
        }

        public Set<String> generate(int i) {
            if (cache[i] != null) {
                return cache[i];
            }

            Set<String> combinationsOfI = new HashSet<>();
            if (i == 0) {
                combinationsOfI.add("");
            } else {
                for (int p = 0; p <= i - 1; p++) {
                    Set<String> combinationsOfP = generate(p);
                    for (String cp : combinationsOfP) {
                        //  q = i - 1 - p;
                        Set<String> combinationsOfQ = generate(i - 1 - p);
                        for (String cq : combinationsOfQ) {
                            combinationsOfI.add("(" + cp + ")" + cq);
                        }
                    }
                }
            }

            cache[i] = combinationsOfI;
            return combinationsOfI;

        }

    }

}
