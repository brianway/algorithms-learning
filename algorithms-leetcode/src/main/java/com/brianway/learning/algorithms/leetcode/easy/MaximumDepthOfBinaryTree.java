package com.brianway.learning.algorithms.leetcode.easy;

import com.brianway.learning.algorithms.leetcode.common.TreeNode;

/**
 * LeetCode 104. Maximum Depth of Binary Tree
 * Question: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * 关键题设： maximum depth
 *
 * @auther brian
 * @since 2022/9/3 15:33
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        return 0;
    }

    /**
     * 递归解法
     * <p>
     * 后序遍历： 左子树深度，右子树深度，cur的深度
     */
    public class MaximumDepthOfBinaryTree0 extends MaximumDepthOfBinaryTree {
        @Override
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int maxLeftDepth = maxDepth(root.left);
            int maxRightDepth = maxDepth(root.right);
            return Math.max(maxLeftDepth, maxRightDepth) + 1;
        }
    }

}
