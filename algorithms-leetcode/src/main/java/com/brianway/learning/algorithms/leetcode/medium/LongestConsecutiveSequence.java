package com.brianway.learning.algorithms.leetcode.medium;

import java.util.HashSet;

/**
 * LeetCode 128. Longest Consecutive Sequence
 * Question: https://leetcode.com/problems/longest-consecutive-sequence/
 * 关键题设：runs in O(n) time.
 *
 * @auther brian
 * @since 2022/9/6 23:59
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        return 0;
    }

    /**
     * 哈希表
     * <p>
     * 先构建哈希集合，用于去重；
     * 再依次遍历其中的元素num：只统计num-1不在其中时，一直next,看nums++是否在哈希集合中，统计next的次数
     * 1）如果num-1在里面，则忽略跳过
     * 2)如果num-1不在里面，则每次查看看num是否在里面
     *
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public class LongestConsecutiveSequence0 extends LongestConsecutiveSequence {
        @Override
        public int longestConsecutive(int[] nums) {
            // 构建哈希Set
            HashSet<Integer> hashSet = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                hashSet.add(nums[i]);
            }
            int maxCount = 0;
            // 遍历
            for (int num : hashSet) {
                if (!hashSet.contains(num - 1)) {
                    // 进入统计循环
                    int curCount = 1;
                    int cur = num;
                    while (hashSet.contains(++cur)) {
                        curCount++;
                    }
                    maxCount = Math.max(maxCount, curCount);
                }
                // else 忽略
            }
            return maxCount;
        }
    }

    // TODO 其他解法
}
