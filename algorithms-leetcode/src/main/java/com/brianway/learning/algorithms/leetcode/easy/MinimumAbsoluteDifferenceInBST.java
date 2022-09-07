package com.brianway.learning.algorithms.leetcode.easy;

import com.brianway.learning.algorithms.leetcode.common.TreeNode;

/**
 * LeetCode 530. Minimum Absolute Difference in BST
 * Question https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 * 关键题设：无
 *
 * @auther brian
 * @since 2022/9/7 22:47
 */
public class MinimumAbsoluteDifferenceInBST {
    public int getMinimumDifference(TreeNode root) {
        return 0;
    }

    /**
     * 递归
     */
    public class MinimumAbsoluteDifferenceInBST0 extends MinimumAbsoluteDifferenceInBST {
        private TreeNode pre;
        private int result = Integer.MAX_VALUE;

        @Override
        public int getMinimumDifference(TreeNode root) {
            if (root == null) {
                return 0;
            }
            traversal(root);
            return result;
        }

        /**
         * 中序遍历
         */
        public void traversal(TreeNode root) {
            if (root == null) {
                return;
            }

            traversal(root.left);
            if (pre != null) {
                result = Math.min(root.val - pre.val, result);
            }
            pre = root;

            traversal(root.right);

        }

    }

    // TODO 迭代

}
