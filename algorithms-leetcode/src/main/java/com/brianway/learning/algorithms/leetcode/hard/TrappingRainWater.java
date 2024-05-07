package com.brianway.learning.algorithms.leetcode.hard;

/**
 * LeetCode 42. Trapping Rain Water
 * Question: https://leetcode.com/problems/trapping-rain-water/
 * 关键题设:  无
 *
 * @auther brian
 * @since 2022/12/2 23:32
 */
public class TrappingRainWater {

    /**
     * 按列求
     * 对于每一列，找出其左侧最高列的高度 max_left 和 右侧最高列的高度  max_right
     * 如果 min(max_left, max_right) > 当前列高度，则 该列对应雨水 为 min(max_left, max_right)- height[i], 否则为0
     * 累加每列的雨水即可
     * <p>
     * 每一列的max_left和max_right可用动态规划求
     * <p>
     * 时间复杂度 O(n) 三次遍历
     * 空间复杂度 O(n) 两个长度n的数组存每一列的max_left和max_right
     */
    class Solution {
        public int trap(int[] height) {
            int[] leftMax = new int[height.length];
            int[] rightMax = new int[height.length];
            // leftMax[i]表示0~i-1的最大值
            for (int i = 1; i < height.length; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
            }
            // rightMax[i]表示i+1~n的最大值
            for (int i = height.length - 2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
            }

            int total = 0;
            for (int i = 0; i < height.length; i++) {
                int min = Math.min(leftMax[i], rightMax[i]);
                if (min > height[i]) {
                    total += (min - height[i]);
                }
            }
            return total;

        }
    }
}
