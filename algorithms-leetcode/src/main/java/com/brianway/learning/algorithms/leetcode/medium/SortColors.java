package com.brianway.learning.algorithms.leetcode.medium;

/**
 * LeetCode 75. Sort Colors
 * Question: https://leetcode.com/problems/sort-colors/
 * 关键题设：without using the library's sort function.
 *
 * @auther brian
 * @since 2022/8/9 23:12
 */
public class SortColors {
    public void sortColors(int[] nums) {

    }

    /**
     * 思路：快排的子过程 partition
     * <p>
     * 维护两个指针：
     * p0表示 [0,p0)下标范围全是0
     * p2表示 (p2,n-1]下标范围全是2
     * 初始化： p0=0, p2=n-1, 这样两个区间范围初始都是空
     * <p>
     * 依次遍历i,
     * - 遇到0就交换nums[i]和nums[p0]，同时，p0 和 i 都向后移一位
     * - 遇到2就交换nums[i]和nums[p2]，p2向前移一位
     * - 遇到1就不需要交换，i 向后移一位
     * 当i>p2，结束遍历
     */
    public class SortColors0 extends SortColors {
        @Override
        public void sortColors(int[] nums) {
            int p0 = 0;
            int p2 = nums.length - 1;
            for (int i = 0; i <= p2; ) {
                if (nums[i] == 0) {
                    swap(nums, i, p0);
                    p0++;
                    i++;
                } else if (nums[i] == 2) {
                    swap(nums, i, p2);
                    p2--;
                    // i 不移动
                } else {
                    i++;
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    }

    // TODO 补充其他解法

}
