package com.brianway.learning.algorithms.leetcode.easy;

/**
 * LeetCode 704. Binary Search
 * Question: https://leetcode.com/problems/binary-search/
 * 关键题设：无
 *
 * @auther brian
 * @since 2022/8/8 21:00
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = low + (high - low) / 2;

        while (low <= high) {
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            // 这句也可以在循环开始处计算
            mid = low + (high - low) / 2;
        }
        return -1;
    }
}
