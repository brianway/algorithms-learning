package com.brianway.learning.algorithms.lectures.binarytree;

import java.util.Stack;

/**
 * Created by brian on 16/11/16.
 *
 * 一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，
 * 使得这棵二叉树不再是搜索二叉树，请找到这两个错误节点并返回他们的值。
 * 保证二叉树中结点的值各不相同。
 * 给定一棵树的根结点，请返回两个调换了位置的值，其中小的值在前。
 */
public class FindErrorNode {
    public int[] findError(TreeNode root) {
        int[] error = new int[2];
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) {
            return null;
        }
        TreeNode current = root;
        stack.push(root);
        int last = 0;
        boolean hasSet = false;
        boolean hasLast = false;
        while (!stack.isEmpty()) {
            if (current == null || current.left == null) {
                current = stack.pop();

                if (!hasLast) {
                    last = current.val;
                    hasLast = true;
                }
                if (current.val < last) {
                    error[0] = current.val;
                    if (!hasSet) {
                        error[1] = last;
                        hasSet = true;
                    }
                }
                last = current.val;

                if (current.right != null) {
                    stack.push(current.right);
                }
                current = current.right;
            } else {
                stack.push(current.left);
                current = current.left;
            }
        }

        return error;
    }
}
