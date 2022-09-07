package com.brianway.learning.algorithms.leetcode.medium;

import com.brianway.learning.algorithms.leetcode.common.TreeNode;

/**
 * LeetCode 236. Lowest Common Ancestor of a Binary Tree
 * Question: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 关键题设：All Node.val are unique. p != q
 *
 * @auther brian
 * @since 2022/9/7 23:25
 */
public class LowestCommonAncestorOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return null;
    }

    /**
     * LCA
     * 递归
     * 后序遍历，回溯
     */
    public class LowestCommonAncestorOfBinaryTree0 extends LowestCommonAncestorOfBinaryTree {
        @Override
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if (root == p || root == q) {
                return root;
            }

            // 一边一个
            if (left != null && right != null) {
                return root;
            } else if (left != null) {
                return left;
            } else if (right != null) {
                return right;
            } else {
                return null;
            }
        }
    }
}
