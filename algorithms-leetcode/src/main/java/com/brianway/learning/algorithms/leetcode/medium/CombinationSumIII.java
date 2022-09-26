package com.brianway.learning.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 216. Combination Sum III
 * Question: https://leetcode.com/problems/combination-sum-iii/
 * 关键题设：Only numbers 1 through 9 are used. Each number is used at most once.
 *
 * @auther brian
 * @since 2022/9/26 22:30
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        return null;
    }

    /**
     * 回溯+剪枝
     */
    public class CombinationSumIII0 extends CombinationSumIII {
        @Override
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> result = new ArrayList<>();
            backtracking(result, new LinkedList<>(), 0, n, k, 1);
            return result;
        }

        /**
         * @param result     满足条件的所有结果
         * @param path       单个结果的路径
         * @param pathSum    单个路径和
         * @param n          n
         * @param k          k
         * @param startIndex 本层的一个数
         */
        public void backtracking(List<List<Integer>> result, LinkedList<Integer> path, int pathSum, int n, int k, int startIndex) {
            if (path.size() == k) {
                if (pathSum == n) {
                    result.add(new ArrayList<>(path));
                }
                return;
            }

            for (int i = startIndex; i <= 9 - k + path.size() + 1 && pathSum <= n; i++) {
                path.push(i);
                backtracking(result, path, pathSum + i, n, k, i + 1);
                path.pop();
            }
        }
    }
}
