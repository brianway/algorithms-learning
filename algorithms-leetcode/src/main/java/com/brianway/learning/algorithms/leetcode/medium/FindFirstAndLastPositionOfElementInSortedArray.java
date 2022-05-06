package com.brianway.learning.algorithms.leetcode.medium;

/**
 * LeetCode 34. Find First and Last Position of Element in Sorted Array
 * Question https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 关键题设：sorted in non-decreasing order, O(log n) runtime complexity.
 *
 * @auther brian
 * @since 2022/5/6 22:21
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        return null;
    }

    /**
     * 分别用二分查找 找出第一个和最后一个出现的位置即可
     */
    public class FindFirstAndLastPositionOfElementInSortedArray0 extends FindFirstAndLastPositionOfElementInSortedArray {
        @Override
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) {
                return new int[] {-1, -1};
            }
            int start = searchStartPosition(nums, target);
            if (start == -1) {
                return new int[] {-1, -1};
            }
            int end = searchEndingPosition(nums, target);
            return new int[] {start, end};
        }

        public int searchStartPosition(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] > target) {
                    high = mid - 1;
                } else if (nums[mid] < target) {
                    low = mid + 1;
                } else { // nums[mid] == target，需要特殊考虑
                    // mid已经是第一个了，或者mid的前一个不是target，说明nums[mid]即是第一个target
                    if (mid == 0 || nums[mid - 1] < target) {
                        return mid;
                    } else {
                        // 否则，第一个落在mid左边
                        high = mid - 1;
                    }
                }
            }
            return -1;
        }

        public int searchEndingPosition(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] > target) {
                    high = mid - 1;
                } else if (nums[mid] < target) {
                    low = mid + 1;
                } else { // nums[mid] == target，需要特殊考虑
                    // mid已经是最后一个了，或者mid的后一个不是target，说明nums[mid]即是最后一个target
                    if (mid == nums.length - 1 || nums[mid + 1] > target) {
                        return mid;
                    } else {
                        // 否则，最后一个target落在mid右边
                        low = mid + 1;
                    }
                }
            }
            return -1;
        }
    }
}
