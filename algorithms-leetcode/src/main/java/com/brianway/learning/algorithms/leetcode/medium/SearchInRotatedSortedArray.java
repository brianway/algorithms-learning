package com.brianway.learning.algorithms.leetcode.medium;

/**
 * LeetCode 33. Search in Rotated Sorted Array
 * Question https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 关键题设：with distinct values, possibly rotated
 *
 * @auther brian
 * @since 2022/5/5 21:12
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        return 0;
    }

    /**
     * 思路：
     * <p>
     * 当 nums[mid] > nums[low], 则 low~mid 区间是单调递增的，正常二分查找，
     * 当 nums[mid] < nums[low], 说明 low~mid 区间是rotated；
     * 同理，
     * 当 nums[mid] < nums[high], 则 mid~high 区间是单调递增的，正常二分查找，
     * 当 nums[mid] > nums[high],说明 mid~high 区间是rotated；
     * <p>
     * 边界条件注意：
     * int mid = low + (high - low) / 2;
     * mid 可能等于low， 所以涉及nums[mid]和nums[low]的比较通常要带等号；
     * mid 不可能等于high， 所以涉及nums[mid]和nums[high]的比较不带等号
     * <p>
     * 当nums[mid] != target 时，分类讨论：
     * 第1步：根据nums[mid] 和 nums[high] or nums[low] 的大小关系判断区间单调性
     * 第2步：然后在子分支里再根据单调性和区间值的上下限，判断target可能落在哪个区间（要么落在左边，要么落在右边）
     * <p>
     * 注意：nums[mid] >= nums[low] 条件的等号不能省，否则测试用例 {3, 2}, 2 之类的通不过
     * <p>
     * 时间复杂度 O(log n)
     * 空间复杂度 O(1)
     */
    public static class SearchInRotatedSortedArray0 extends SearchInRotatedSortedArray {

        @Override
        public int search(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] >= nums[low]) { // 前半部分单调增，后半部分循环增
                    if (target < nums[mid] && target >= nums[low]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else { // nums[mid] < nums[low], 前半部分循环增，后半部分单调增
                    if (target > nums[mid] && target <= nums[high]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
            return -1;
        }

    }

    /**
     * 写法二
     * 思路同写法一，只是外层按照 nums[mid] 与target的相对大小关系，分三类讨论。
     * 每一类里面再根据nums[mid] 和 nums[high] or nums[low] 的大小关系判断区间单调性和上下限，
     * 进而决定target可能落在哪个区间
     * <p>
     * 注意：
     * 正常的单调递增序列，nums[mid] > target 则 target落在左边；nums[mid] < target，则 target落在右边
     * 所以在内层分支只需要列出不满足上述情况的条件即可:
     * 区间为非单调递增（而是循环递增）【且】区间取值范围能涵盖target。否则，target落在常规的单调数组的二分查找区间
     * <p>
     * 时间复杂度 O(log n)
     * 空间复杂度 O(1)
     */
    public static class SearchInRotatedSortedArray1 extends SearchInRotatedSortedArray {
        @Override
        public int search(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    // 只有后半部分是循环递增且target<=nums[high]时，target才可能出现在后半部分，否则target只能出现在前半部分
                    if (nums[mid] > nums[high] && target <= nums[high]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                } else { //  nums[mid] < target
                    // 只有前半部分是循环递增且target>=nums[low]时，target才可能出现在前半部分，否则target只能出现在后半部分
                    if (nums[low] > nums[mid] && target >= nums[low]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
            return -1;
        }

    }

}

// 用于调试打印
//               System.out.println("-- mid:" + mid + ", low:" + low + ", high:" + high);
//                System.out.println("nums[low]:" + nums[low]);
//                System.out.println("nums[mid]:" + nums[mid]);
//                System.out.println("nums[high]:" + nums[high]);