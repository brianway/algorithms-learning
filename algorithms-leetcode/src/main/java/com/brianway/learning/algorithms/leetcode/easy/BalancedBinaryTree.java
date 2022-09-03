package com.brianway.learning.algorithms.leetcode.easy;

import com.brianway.learning.algorithms.leetcode.common.TreeNode;

/**
 * LeetCode 110. Balanced Binary Tree
 * Question: https://leetcode.com/problems/balanced-binary-tree/
 * 关键题设: 无
 *
 * @auther brian
 * @since 2022/9/3 17:08
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return false;
    }

    /**
     * 递归
     * <p>
     * 用树的高度来解决，后序遍历
     */
    public class BalancedBinaryTree0 extends BalancedBinaryTree {
        @Override
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            return getHeight(root) != -1;
        }

        /**
         * 如果cur是平衡的，则返回高度，否则返回-1
         */
        public int getHeight(TreeNode cur) {
            if (cur == null) {
                return 0;
            }
            int leftHeight = getHeight(cur.left);
            if (leftHeight == -1) {
                return -1;
            }
            int rightHeight = getHeight(cur.right);
            if (rightHeight == -1) {
                return -1;
            }

            if (Math.abs(leftHeight - rightHeight) > 1) {
                return -1;
            } else {
                return Math.max(leftHeight, rightHeight) + 1;
            }
        }
    }
}
