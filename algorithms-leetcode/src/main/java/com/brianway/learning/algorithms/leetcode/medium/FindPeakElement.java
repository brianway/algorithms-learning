package com.brianway.learning.algorithms.leetcode.medium;

/**
 * Created by Brian on 2016/4/30.
 * LeetCode 162. Find Peak Element
 * Question:https://leetcode.com/problems/find-peak-element/
 * 关键题设： imagine that num[-1] = num[n] = -∞， an input array where num[i] ≠ num[i+1]， any one of the peaks is fine
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        return 0;
    }

    /**
     * 一次遍历，大于两边即可
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public class FindPeakElement0 extends FindPeakElement {
        @Override
        public int findPeakElement(int[] nums) {
            if (nums.length == 1) return 0;

            for (int i = 0; i < nums.length; i++) {
                if ((i == 0 || nums[i] > nums[i - 1]) && (i == nums.length - 1 || nums[i] > nums[i + 1])) {
                    return i;
                }
            }
            throw new IllegalArgumentException("No peak elment solution");
        }
    }

    /**
     * 二分查找
     * 先看中点mid，若中点(nums[mid])比左右(nums[mid-1],nums[mid+1])大，则完成
     * 若左值大于中点，则左边必存在一个peak。
     * 1）nums[mid-1]>nums[mid-2],则nums[mid-1]为peak
     * 2）nums[mid-1]<nums[mid-2],则递推，遇到peak则完成，若一直没遇到，到nums[0]必有nums[0]大于nums[-1]
     * 同理，若右值大于中点，则右边必存在一个peak。
     *
     * 注意mid在边界时的判断，不要越界
     * 时间复杂度 O(lg(n))
     * 空间复杂度 O(1)
     */
    public class FindPeakElement1 extends FindPeakElement {
        @Override
        public int findPeakElement(int[] nums) {
            if (nums.length == 1) return 0;

            int start = 0;
            int end = nums.length - 1;
            int mid = 0;
            while (start <= end) {
                mid = (start + end) / 2;
                if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                    break;
                } else if (mid > 0 && nums[mid - 1] > nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return mid;

        }
    }

    /**
     * 二分查找
     * 代码简化
     */
    public class FindPeakElement2 extends FindPeakElement {
        @Override
        public int findPeakElement(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            int mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                if (left == right) {
                    break;
                }
                if (nums[mid] < nums[mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return mid;
        }
    }

}
