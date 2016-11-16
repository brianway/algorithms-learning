package com.brianway.learning.algorithms.lectures.binarytree;

/**
 * Created by brian on 16/11/16.
 *
 * 有一棵二叉树，请设计一个算法判断这棵二叉树是否为平衡二叉树。
 * 给定二叉树的根结点root，请返回一个bool值，代表这棵树是否为平衡二叉树。
 */
public class CheckBalance {
    public boolean check(TreeNode root) {
        return post(root) >= 0;
    }

    private int post(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = post(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = post(root.right);
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;

    }
}
