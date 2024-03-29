package com.brianway.learning.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 46. Permutations
 * Question: https://leetcode.com/problems/permutations/
 * 关键题设:  无
 *
 * @auther brian
 * @since 2022/12/1 23:08
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        return null;
    }

    /**
     * 回溯
     */
    public class Permutations0 extends Permutations {
        @Override
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> numbers = new ArrayList<Integer>();
            for (int num : nums) {
                numbers.add(num);
            }

            backtracking(result, new LinkedList<>(), numbers, 0);
            return result;
        }

        /**
         * @param result 所有排列
         * @param path   已经被安置在当前排列的数字
         * @param nums   使用List是为了使用Collections.swap的API
         * @param start  当前从数组哪个位置开始是未使用过的数字
         */
        public void backtracking(List<List<Integer>> result, LinkedList<Integer> path, List<Integer> nums, int start) {
            if (start == nums.size()) {
                result.add(new ArrayList<>(path));
            }

            for (int i = start; i < nums.size(); i++) {
                path.push(nums.get(i));
                Collections.swap(nums, i, start);
                backtracking(result, path, nums, start + 1);
                Collections.swap(nums, start, i);
                path.pop();
            }
        }

    }
}
