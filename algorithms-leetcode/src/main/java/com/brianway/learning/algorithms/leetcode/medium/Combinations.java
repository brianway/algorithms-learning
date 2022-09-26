package com.brianway.learning.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 77. Combinations
 * Question: https://leetcode.com/problems/combinations/
 * 关键题设：any order
 *
 * @auther brian
 * @since 2022/9/22 23:48
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        return null;
    }

    /**
     * 组合问题
     * <p>
     * 回溯算法框架：
     * <pre>
     * void backtracking(参数) {
     *     if (终止条件) {
     *         存放结果;
     *         return;
     *     }
     *
     *     for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
     *         处理节点;
     *         backtracking(路径，选择列表); // 递归
     *         回溯，撤销处理结果
     *     }
     * }
     * </pre>
     */
    public class Combinations0 extends Combinations {
        @Override
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();
            backtracking(result, new LinkedList<>(), n, k, 1);
            return result;
        }

        /**
         * @param result     满足条件的所有结果
         * @param path       满足条件的单个结果
         * @param n          n
         * @param k          k
         * @param startIndex 本层开始的第一个数
         */
        public void backtracking(List<List<Integer>> result, LinkedList<Integer> path, int n, int k, int startIndex) {
            // 终止条件
            if (path.size() == k) {
                // 这里要copy后add
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = startIndex; i <= n; i++) {
                path.push(i);
                backtracking(result, path, n, k, i + 1);
                path.pop();
            }

        }
    }

    /**
     * 回溯+剪枝
     * <p>
     * 当前已选 path.size, 还需要选 k-path.size,
     * 需要剩余的够分, 即 n-i+1>=k-path.size
     * 即 i<= n-k+path.size+1
     */
    public class Combinations1 extends Combinations {
        @Override
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();
            backtracking(result, new LinkedList<>(), n, k, 1);
            return result;
        }

        public void backtracking(List<List<Integer>> result, LinkedList<Integer> path, int n, int k, int startIndex) {
            // 终止条件
            if (path.size() == k) {
                // 这里要copy后add
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = startIndex; i <= n - k + path.size() + 1; i++) {
                path.push(i);
                backtracking(result, path, n, k, i + 1);
                path.pop();
            }

        }
    }

}
