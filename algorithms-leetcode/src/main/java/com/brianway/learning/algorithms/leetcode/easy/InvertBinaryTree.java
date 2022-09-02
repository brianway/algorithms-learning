package com.brianway.learning.algorithms.leetcode.easy;

import com.brianway.learning.algorithms.leetcode.common.TreeNode;

/**
 * LeetCode 226. Invert Binary Tree
 * Question https://leetcode.com/problems/invert-binary-tree/
 * 关键题设：无
 *
 * @auther brian
 * @since 2022/9/2 22:43
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        return null;
    }

    public class InvertBinaryTree0 extends InvertBinaryTree {
        @Override
        public TreeNode invertTree(TreeNode root) {
            invert(root);
            return root;
        }

        public void invert(TreeNode cur) {
            if (cur == null) {
                return;
            }
            // invert current
            TreeNode tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;

            invert(cur.left);
            invert(cur.right);
        }
    }
}
