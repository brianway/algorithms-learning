package com.brianway.learning.algorithms.leetcode.medium;

import com.brianway.learning.algorithms.leetcode.common.TreeNode;

/**
 * LeetCode 654. Maximum Binary Tree
 * Question: https://leetcode.com/problems/maximum-binary-tree/
 * 关键题设：无
 *
 * @auther brian
 * @since 2022/9/6 23:37
 */
public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return null;
    }

    /**
     * 递归
     * <p>
     * 先序遍历/后序遍历都行
     */
    public class MaximumBinaryTree0 extends MaximumBinaryTree {
        @Override
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return constructMaximumBinaryTree(nums, 0, nums.length - 1);
        }

        /**
         * 用数组nums的[low, high] 构造二叉树，左闭右闭
         *
         * @return 构造的二叉树
         */
        public TreeNode constructMaximumBinaryTree(int[] nums, int low, int high) {
            // 终止条件
            if (low > high) {
                return null;
            }

            if (low == high) { // 这个分支可有可无
                return new TreeNode(nums[low]);
            }

            int indexOfMax = findIndexOfMax(nums, low, high);
            TreeNode left = constructMaximumBinaryTree(nums, low, indexOfMax - 1);
            TreeNode right = constructMaximumBinaryTree(nums, indexOfMax + 1, high);

            TreeNode cur = new TreeNode(nums[indexOfMax], left, right);

            return cur;
        }

        public int findIndexOfMax(int[] nums, int low, int high) {
            int indexOfMax = low;
            for (int i = low + 1; i <= high; i++) {
                if (nums[i] > nums[indexOfMax]) {
                    indexOfMax = i;
                }
            }
            return indexOfMax;
        }
    }
}
