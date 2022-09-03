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
     * 根节点的高度就是二叉树的最大深度
     * 后序遍历： 左子树高度，右子树高度，cur的高度
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

    // TODO 迭代法： 层序遍历即可
}
