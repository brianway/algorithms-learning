package com.brianway.learning.algorithms.leetcode.medium;

/**
 * Created by brian on 16/6/6.
 * LeetCode 153. Find Minimum in Rotated Sorted Array
 * Question:https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * 关键题设： no duplicate exists in the array
 */
public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        return 0;
    }

    /**
     * 遍历一遍
     * 如果后一个元素比前一个小,则找到
     * 如果遍历完了都是升序,则第一个元素最小
     *
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public class FindMinimuminRotatedSortedArray0 extends FindMinimuminRotatedSortedArray {
        @Override
        public int findMin(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i - 1]) {
                    return nums[i];
                }
            }
            return nums[0];
        }
    }

    /**
     * 二分查找
     *
     * 可以根据A[mid]和A[end]来判断右半数组是否sorted,比如:
     * 原数组：0 1 2 4 5 6 7
     * 情况一：6 7 0 1 2 4 5
     * 情况二：2 4 5 6 7 0 1
     *
     * 另外,可以看出,除非是按原序排列,不然一定有A[start]>A[end]
     *
     * (1) A[mid] < A[end]
     *    A[mid : end] sorted => min不在A[mid+1 : end]中,搜索A[start : mid]
     * (2) A[mid] > A[end]
     *    A[start : mid] sorted且又因为该情况下A[end]<A[start] => min不在A[start : mid]中,搜索A[mid+1 : end]
     *
     * 时间复杂度 O(log(n))
     * 空间复杂度 O(1)
     *
     * TODO 为什么OJ上运行时间和一次遍历一样?理论上这个快啊
     */
    public class FindMinimuminRotatedSortedArray1 extends FindMinimuminRotatedSortedArray {
        @Override
        public int findMin(int[] nums) {
            int low = 0;
            int high = nums.length - 1;
            while (low < high) {
                int mid = (low + high) / 2;
                if (nums[mid] > nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return nums[low];
        }
    }

}
