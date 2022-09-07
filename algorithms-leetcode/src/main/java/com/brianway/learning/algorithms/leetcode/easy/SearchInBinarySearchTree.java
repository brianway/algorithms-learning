package com.brianway.learning.algorithms.leetcode.easy;

import com.brianway.learning.algorithms.leetcode.common.TreeNode;

/**
 * LeetCode 700. Search in a Binary Search Tree
 * Question: https://leetcode.com/problems/search-in-a-binary-search-tree/
 * 关键题设：无
 *
 * @auther brian
 * @since 2022/9/7 21:51
 */
public class SearchInBinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {
        return null;
    }

    /**
     * 递归
     */
    public class SearchInBinarySearchTree0 extends SearchInBinarySearchTree {
        @Override
        public TreeNode searchBST(TreeNode root, int val) {
            // 终止条件
            if (root == null) {
                return null;
            }

            if (root.val == val) {
                return root;
            } else if (root.val > val) {
                return searchBST(root.left, val);
            } else {
                return searchBST(root.right, val);
            }
        }
    }

    /**
     * 迭代
     */
    public class SearchInBinarySearchTree01 extends SearchInBinarySearchTree {
        @Override
        public TreeNode searchBST(TreeNode root, int val) {
            TreeNode cur = root;
            while (cur != null) {
                if (cur.val == val) {
                    return cur;
                } else if (cur.val > val) {
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            }
            return null;
        }
    }
}
