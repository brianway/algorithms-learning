package com.brianway.learning.algorithms.leetcode.medium;

import com.brianway.learning.algorithms.leetcode.common.TreeNode;

/**
 * LeetCode 114. Flatten Binary Tree to Linked List
 * Question: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * 关键题设:  preorder
 *
 * @auther brian
 * @since 2022/12/5 20:51
 */
public class FlattenBinaryTreeToLinkedList {

    /**
     * 递归解法
     */
    class Solution {
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            recursiveFlatten(root);
        }

        /**
         * 返回链表的最后一个节点（避免遍历链表）
         *
         * @param root 非空
         * @return 链表的最后一个节点
         */
        public TreeNode recursiveFlatten(TreeNode root) {
            // 叶子节点
            if (root.left == null && root.right == null) {
                return root;
            }

            // flatten左子树
            TreeNode leftEnd = null;
            if (root.left != null) {
                leftEnd = recursiveFlatten(root.left);
            }

            // flatten右子树
            TreeNode rightEnd = null;
            if (root.right != null) {
                rightEnd = recursiveFlatten(root.right);
            }

            // 更新指向
            if (leftEnd != null) {
                TreeNode rightStart = root.right;
                root.right = root.left;
                root.left = null;
                leftEnd.right = rightStart;
            }

            return rightEnd == null ? leftEnd : rightEnd;

        }
    }
}
