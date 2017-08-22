package com.brianway.learning.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Brian on 2016/4/19.
 * LeetCode 1. Two Sum
 * Question:https://leetcode.com/problems/two-sum/
 * 关键题设：You may assume that each input would have exactly one solution.找出一解即可
 */

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        return null;
    }

    /**
     * 暴力求解
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     */
    public class TwoSum0 extends TwoSum {
        @Override
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length < 2) {
                throw new IllegalArgumentException("nums should contains at least 2 elements");
            }

            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[] {i, j};
                    }
                }
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    }

    /**
     * 哈希表，当前元素的值作为 key，其下标的值作为 value.
     * 每次求(target-当前元素值)得到key，查哈希表即可
     *
     * 方法1：一次循环初始化，一次循环进行搜索匹配，2次遍历
     *
     * （感觉可能出问题，比如 [1,4,4,5],8   所以需要把这种情况考虑进去）
     *
     *
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public class TwoSum1 extends TwoSum {
        @Override
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length < 2) {
                throw new IllegalArgumentException("nums should contains at least 2 elements");
            }

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement) && map.get(complement) != i) {
                    return new int[] {i, map.get(complement)};
                }
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    }

    /**
     * 哈希表，当前元素的值作为 key，其下标的值作为 value.
     * 每次求(target-当前元素值)得到key，查哈希表即可
     *
     * 方法1：一次循环初始化，一次循环进行搜索匹配，2次遍历
     * √方法2：一边搜索一边初始化哈希表，一次遍历
     * (target-当前值)是在已经初始化的集合中找的，所以映射的下标一定小于当前下标i,故放前面
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public class TwoSum2 extends TwoSum {

        @Override
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length < 2) {
                throw new IllegalArgumentException("nums should contains at least 2 elements");
            }

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int[] {map.get(complement), i};
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    }
}

