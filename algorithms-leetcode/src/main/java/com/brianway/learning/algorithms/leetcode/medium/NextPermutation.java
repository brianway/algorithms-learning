package com.brianway.learning.algorithms.leetcode.medium;

import java.util.Arrays;

/**
 * Created by Brian on 2017/9/4.
 * LeetCode 31. Next Permutation
 * Question: https://leetcode.com/problems/next-permutation/description/
 * 关键题设：lexicographically，replacement must be in-place
 * 参考：https://www.tianmaying.com/tutorial/LC31
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {

    }

    /**
     * 在给出的全排列中，寻找一个 p，
     * 要求其满足a[p] < a[p+1]，
     * 然后只需将 a[p] 变成 a[p+1]...a[n] 中最小的大于 a[p] 的数字，
     * 最后将剩下的数字按照从小到大的顺序放置即可
     *
     * 注意事项：
     * 1. 找 a[p] 时，要倒着找，否则会出问题。反例子如下：
     * Input: [1,2,3]
     * Output:[2,1,3]
     * Expected: [1,3,2]
     * 2. 假如已经是最大排列，则重排成最小排列
     *
     *
     * 时间复杂度 O(n + n*log n)
     * 空间复杂度 O(1)
     */
    public class NextPermutation0 extends NextPermutation {
        @Override
        public void nextPermutation(int[] nums) {
            if (nums == null) {
                return;
            }
            int p = -1;
            for (int i = nums.length - 1; i > 0; i--) {
                if (nums[i] > nums[i - 1]) {
                    p = i - 1;
                    break;
                }
            }

            if (p == -1) {
                Arrays.sort(nums);
            } else {
                int leastMax = p + 1;
                for (int j = p + 1; j < nums.length; j++) {
                    if (nums[j] > nums[p] && nums[j] < nums[leastMax]) {
                        leastMax = j;
                    }
                }

                swap(nums, p, leastMax);
                Arrays.sort(nums, p + 1, nums.length);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

}
