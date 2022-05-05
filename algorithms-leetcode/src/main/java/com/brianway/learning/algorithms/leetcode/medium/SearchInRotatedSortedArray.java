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
     * mid 不可能等于high， 所以涉及ums[mid]和nums[high]的比较不带等号
     * <p>
     * <p>
     * 所以，分类讨论即可：
     * 按照 nums[mid] 与target的相对大小关系，分三类讨论，
     * 每一类里面再根据nums[mid] 和 nums[high] or nums[low] 的大小关系判断区间单调性和上下限，进而决定target可能落在哪个区间
     * <p>
     * 时间复杂度 O(log n)
     * 空间复杂度 O(1)
     */
    public class SearchInRotatedSortedArray0 extends SearchInRotatedSortedArray {
        @Override
        public int search(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                System.out.println("-- mid:" + mid + ", low:" + low + ", high:" + high);
                System.out.println("nums[low]:" + nums[low]);
                System.out.println("nums[mid]:" + nums[mid]);
                System.out.println("nums[high]:" + nums[high]);
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    // mid可能等于low，所以这里带等号；但由于 mid=low时，表示 nums[mid]=nums[low] > target
                    // 所以此处 nums[mid] >= nums[low] 带不带等号都行
                    if (nums[mid] >= nums[low] && target >= nums[low]) {
                        // low~mid 区间是单调递增，且target大于该区间下限nums[low]
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else { //  nums[mid] < target，
                    // mid不可能等于high， 所以这里不带等号
                    // TODO 这里要分类讨论
                    if (nums[mid] < nums[high] && target <= nums[high]) {
                        // mid~high 区间是单调递增的，且target小于等于该区间上限nums[high]
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
     * <p>
     * 思路同解法一，只是分类讨论的内外层不一样：
     * 当nums[mid] != target 时
     * 第1步：根据nums[mid] 和 nums[high] or nums[low] 的大小关系判断区间单调性
     * 第2步：然后在子分支里再根据单调性和区间值的上下限，判断target可能落在哪个区间
     *
     * <p>
     * nums[mid] >= nums[low] 条件的等号不能省，
     * <p>
     * 时间复杂度 O(log n)
     * 空间复杂度 O(1)
     */
    public class SearchInRotatedSortedArray1 extends SearchInRotatedSortedArray {

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

}

// 用于调试打印
//               System.out.println("-- mid:" + mid + ", low:" + low + ", high:" + high);
//                System.out.println("nums[low]:" + nums[low]);
//                System.out.println("nums[mid]:" + nums[mid]);
//                System.out.println("nums[high]:" + nums[high]);