package com.brianway.learning.algorithms.leetcode.easy;

import com.brianway.learning.algorithms.leetcode.common.TreeNode;

/**
 * LeetCode 111. Minimum Depth of Binary Tree
 * Question: https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * 关键题设：The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * @auther brian
 * @since 2022/9/3 15:47
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        return 0;
    }

    /**
     * 递归
     * <p>
     * 后序遍历
     * <p>
     * 注意：子树为空的情况
     */
    public class MinimumDepthOfBinaryTree0 extends MinimumDepthOfBinaryTree {
        @Override
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftMinDepth = minDepth(root.left);
            int rightMinDepth = minDepth(root.right);

            if (root.left != null && root.right == null) {
                return leftMinDepth + 1;
            } else if (root.left == null && root.right != null) {
                return rightMinDepth + 1;
            } else {
                return Math.min(leftMinDepth, rightMinDepth) + 1;
            }
        }
    }

    // TODO 层序遍历，左右孩子都空说明到最低点了
}
