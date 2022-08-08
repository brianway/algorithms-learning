package com.brianway.learning.algorithms.leetcode.medium;

/**
 * LeetCode 11. Container With Most Water
 * Question: https://leetcode.com/problems/container-with-most-water/
 * 关键题设: 无
 *
 * @auther brian
 * @since 2022/8/8 20:12
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        return 0;
    }

    /**
     * 双指针
     * 正确性分析可以使用二维表来证明
     * <p>
     * 面积=高*宽， 即 S(i,j)= min{h[i],h[j]}*(j-i)
     * left，right分别指向两边，然后依次向内移动高度较小的一边，直至两指针相遇。
     * 因为向内移动，必然会使得宽度变窄，而高度又是取小，
     * 所以移动高度大的一边面积一定变小，而移动高度小的一边面积可能增大
     * <p>
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public class ContainerWithMostWater0 extends ContainerWithMostWater {
        @Override
        public int maxArea(int[] height) {
            int left = 0, right = height.length - 1;
            int area = 0;
            int maxArea = 0;
            while (left < right) {
                area = Math.min(height[left], height[right]) * (right - left);
                maxArea = Math.max(area, maxArea);
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }
            return maxArea;
        }
    }
}
