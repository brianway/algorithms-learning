package com.brianway.learning.algorithms.leetcode.easy;

import com.brianway.learning.algorithms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode 94. Binary Tree Inorder Traversal
 * Question https://leetcode.com/problems/binary-tree-inorder-traversal/
 * 关键题设：inorder traversal
 *
 * @auther brian
 * @since 2022/5/12 22:37
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        return new ArrayList<>();
    }

    /**
     * 递归实现
     */
    public static class BinaryTreeInorderTraversal0 extends BinaryTreeInorderTraversal {
        @Override
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            inorder(list, root);
            return list;
        }

        public void inorder(List<Integer> list, TreeNode root) {
            if (root == null) {
                return;
            }
            inorder(list, root.left);
            list.add(root.val);
            inorder(list, root.right);
        }
    }

    /**
     * 非递归写法
     */
    public class BinaryTreeInorderTraversal1 extends BinaryTreeInorderTraversal {
        @Override
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                    list.add(cur.val);
                    cur = cur.right;
                }
            }

            return list;
        }
    }
}
