package com.brianway.learning.algorithms.leetcode.easy;

/**
 * Created by Brian on 2016/4/26.
 * LeetCode 26. Remove Duplicates from Sorted Array
 * Question:https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 关键题设: a sorted array,remove the duplicates in place
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        return 0;
    }

    /**
     * 双指针，一个指示distinct的结尾，记为i，一个用于扫描,记为j
     * 当扫描指针所指示nums[j]和nums[j+i]值不同时，则赋值nums[i]，并increment i指针。
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public class RemoveDuplicatesfromSortedArray0 extends RemoveDuplicatesfromSortedArray {
        @Override
        public int removeDuplicates(int[] nums) {
            if (nums.length <= 1) return nums.length;
            int i = 0;
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] < nums[j + 1]) {
                    nums[++i] = nums[j + 1];
                }
            }
            return i + 1;
        }
    }
}
