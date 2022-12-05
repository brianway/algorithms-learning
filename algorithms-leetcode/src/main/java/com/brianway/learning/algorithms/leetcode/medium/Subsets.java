package com.brianway.learning.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 78. Subsets
 * Question: https://leetcode.com/problems/subsets/
 * 关键题设:  无
 *
 * @auther brian
 * @since 2022/12/5 20:07
 */
public class Subsets {

    /**
     * 回溯
     */
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            backtracking(result, new LinkedList<>(), nums, 0);
            return result;
        }

        public void backtracking(List<List<Integer>> result, LinkedList<Integer> path, int[] nums, int startIndex) {
            if (startIndex == nums.length) {
                result.add(new ArrayList<>(path));
                return;
            }

            // 不用 nums[startIndex]
            backtracking(result, path, nums, startIndex + 1);
            //用 nums[startIndex]
            path.push(nums[startIndex]);
            backtracking(result, path, nums, startIndex + 1);
            path.pop();

        }
    }
}
