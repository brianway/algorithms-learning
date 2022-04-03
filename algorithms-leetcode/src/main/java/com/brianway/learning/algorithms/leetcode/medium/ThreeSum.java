package com.brianway.learning.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by brian on 16/5/22.
 * LeetCode 15. 3Sum
 * Question:https://leetcode.com/problems/3sum/
 * 关键题设：must not contain duplicate triplets
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        return null;
    }

    /**
     * 这题要求列出所有结果，所以不能复用 #1 Two Sum 的方法，
     * 因为 Two Sum 那题只需给出一解。下面的 two sum 和 #1 的 hash table解法无关，而是使用的双指针。
     * <p>
     * 可拆分为 two sum 问题，即每次固定一个数nums[i]，然后利用双指针计算 two sum= 0- nums[i] 即可。
     * 而双指针快速的使用首先需要数组有序，且数组有序可以很方便跳过重复值达到去重效果。
     * 需要找到所有的可能解决，所以需要双指针遍历到底（即穷举至left>=right）而不是找到一个匹配的就停
     *
     * <p>
     * 重点在于去重：
     * 1.由于要求返回的是数组元素而非数组下标，所以需要注意去重。
     * 2.每次固定一个数nums[i]，需要保证nums[i]的值之前未作为第一个数出现过，即外层循环**每次**遇到重复的数都要跳过。
     * 例如[-2,-2,-1,-1,-1,1,1,1]，不跳过重复值可能会得到两次[-2,1,1]
     * 3.内层遍历遇到重复的数也要跳过，但不是无脑跳过（否则可能错过solution），而是在满足two sum的时，才需要跳过。
     * 例如上面的例子，nums[i]=-2，right指针直接跳过右边的重复1直接指到最左的1，就无法找到[-2,1,1]
     * 3.固定一个数后，**只需在其右边**的部分找另外两个
     * <p>
     * 边界问题需要注意：
     * 1.若 nums 长度少于 3,要返回引用,不是空,也不是null(这是测试平台的判定规则)
     * 2.在two sum 里跳过重复的数时，确保不要越界
     * <p>
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     */
    public class ThreeSum0 extends ThreeSum {
        @Override
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> solutions = new ArrayList<List<Integer>>();
            if (nums == null || nums.length < 3) {
                // throw new IllegalArgumentException("at least 3 numbers");
                return solutions;
            }
            Arrays.sort(nums);

            int left, right, twoSumTarget, twoSum;

            for (int i = 0; i < nums.length - 2; i++) {
                // 跳过重复的
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                left = i + 1;
                right = nums.length - 1;
                // 需要遍历至left>=right，穷举出第一个数为nums[i]时另外两个数所有满足条件的值
                while (left < right) {
                    twoSum = nums[left] + nums[right];
                    twoSumTarget = -nums[i];
                    if (twoSum == twoSumTarget) {
                        List<Integer> oneSolution = new ArrayList<Integer>(3);
                        oneSolution.add(nums[i]);
                        oneSolution.add(nums[left]);
                        oneSolution.add(nums[right]);
                        solutions.add(oneSolution);

                        left++;
                        right--;

                        // 跳过重复的,确保left<right,否则会出现越界,如[0,0,0]
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;

                    } else if (twoSum < twoSumTarget) {
                        left++;
                    } else {
                        right--;
                    }

                }
            }

            return solutions;
        }
    }

}


/*
参考链接:
http://bangbingsyb.blogspot.com/2014/11/leetcode-3sum.html
http://blog.csdn.net/linhuanmars/article/details/19711651
http://blog.csdn.net/whuwangyi/article/details/14104589
 */