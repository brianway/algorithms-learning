package com.brianway.learning.algorithms.leetcode.easy;

/**
 * LeetCode 27. Remove Element
 * Question: https://leetcode.com/problems/remove-element/
 * 关键题设： Do not allocate extra space for another array.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 *
 * @auther brian
 * @since 2022/9/4 16:47
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        return 0;
    }

    /**
     * 双指针: 左右指针
     * <p>
     * left指针左边的都不含val
     * right指针指向从右往左的第一个不为val的位置
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static class RemoveElement0 extends RemoveElement {
        @Override
        public int removeElement(int[] nums, int val) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                while (left < nums.length && nums[left] != val) {
                    left++;
                }
                while (right >= 0 && nums[right] == val) {
                    right--;
                }

                if (left < right) {
                    swap(nums, left, right);
                }

            }
            return left;
        }

        public void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    /**
     * 双指针，快慢指针
     * <p>
     * 快指针：遍历数组的下标
     * 慢指针：新数组的结尾下标，即下一个要更新的位置，指针左边（不含当前元素）的都是满足目标条件的
     * 同时，慢指针的值也是新数组的length
     * <p>
     * 快指针遇到val就跳过，遇到非val就赋值给慢指针，然后慢指针指向下一个
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public class RemoveElement1 extends RemoveElement {
        @Override
        public int removeElement(int[] nums, int val) {
            int slowIndex = 0;
            for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
                if (val != nums[fastIndex]) {
                    nums[slowIndex++] = nums[fastIndex];
                }
            }
            return slowIndex;
        }
    }

    public static void main(String[] args) {
        //int[] a = new int[] {0, 1, 2, 2, 3, 0, 4, 2};
        int[] a = new int[] {2};
        int c = new RemoveElement0().removeElement(a, 2);
        System.out.println(c);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(", ");
        }
    }
}
