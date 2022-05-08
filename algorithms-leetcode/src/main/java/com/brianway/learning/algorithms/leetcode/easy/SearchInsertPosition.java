package com.brianway.learning.algorithms.leetcode.easy;

/**
 * LeetCode 35. Search Insert Position
 * Question https://leetcode.com/problems/search-insert-position/
 * 关键题设：array of distinct integers
 *
 * @auther brian
 * @since 2022/5/8 15:16
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        return 0;
    }

    /**
     * 如果target在nums中找不到，则最终一定是low>high,且low=high+1
     * 此时，如果 target < nums[mid], 则说明最后一次low=high=mid, 然后分支走的是 high = mid - 1,
     * 从而循环结束时，mid=low>high， 插入位置为 mid，即low;
     * 如果 target > nums[mid]，则说明最后一次low=high=mid, 然后分支走的是 low = mid + 1,
     * 从而循环结束时，mid=high < low， 插入位置为 mid+1，也即low;
     */
    public static class SearchInsertPosition0 extends SearchInsertPosition {
        @Override
        public int searchInsert(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            return low;
        }
    }
}

// System.out.println("target:" + target + ", mid: " + mid);
//         System.out.println("low:" + low + ", high: " + high);
//