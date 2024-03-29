package com.brianway.learning.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 39. Combination Sum
 * Question: https://leetcode.com/problems/combination-sum/
 * 关键题设：same number unlimited number of times
 *
 * @auther brian
 * @since 2022/9/26 23:31
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return null;
    }

    /**
     * 回溯
     * 注意，元素可重复选取， 所以回溯递归时，传参是i，而不是i+1
     */
    public class CombinationSum0 extends CombinationSum {
        @Override
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            backtracking(result, new LinkedList<>(), 0, candidates, target, 0);
            return result;
        }

        public void backtracking(List<List<Integer>> result, LinkedList<Integer> path, int pathSum,
                                 int[] candidates, int target, int minIndex) {
            if (pathSum >= target) {
                if (pathSum == target) {
                    result.add(new ArrayList<>(path));
                }
                return;
            }

            for (int i = minIndex; i < candidates.length; i++) {
                path.push(candidates[i]);
                backtracking(result, path, pathSum + candidates[i], candidates, target, i);
                path.pop();
            }

        }
    }

    /**
     * 回溯+剪枝
     * <p>
     * 求和问题，可以排序后剪枝，优化性能
     */
    public class CombinationSum1 extends CombinationSum {
        @Override
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            // 排序candidates
            Arrays.sort(candidates);
            backtracking(result, new LinkedList<>(), 0, candidates, target, 0);
            return result;
        }

        public void backtracking(List<List<Integer>> result, LinkedList<Integer> path, int pathSum,
                                 int[] candidates, int target, int minIndex) {
            if (pathSum >= target) {
                if (pathSum == target) {
                    result.add(new ArrayList<>(path));
                }
                return;
            }

            for (int i = minIndex; i < candidates.length && pathSum + candidates[i] <= target; i++) {
                path.push(candidates[i]);
                backtracking(result, path, pathSum + candidates[i], candidates, target, i);
                path.pop();
            }

        }
    }
}
