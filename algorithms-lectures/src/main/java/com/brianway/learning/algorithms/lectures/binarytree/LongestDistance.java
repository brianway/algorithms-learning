package com.brianway.learning.algorithms.lectures.binarytree;

/**
 * Created by brian on 16/11/16.
 *
 * 从二叉树的节点A出发，可以向上或者向下走，但沿途的节点只能经过一次，
 * 当到达节点B时，路径上的节点数叫作A到B的距离。
 * 对于给定的一棵二叉树，求整棵树上节点间的最大距离。
 * 给定一个二叉树的头结点root，请返回最大距离。保证点数大于等于2小于等于500.
 */
public class LongestDistance {
    public int findLongest(TreeNode root) {
        int[] info = find(root);
        return info[0];
    }

    // info[0]:MaxLength;
    // info[1]:MaxToRoot;
    private int[] find(TreeNode root) {
        int[] info = new int[2];
        if (root == null) {
            return info;
        }

        int[] left = find(root.left);
        int[] right = find(root.right);

        info[1] = Math.max(left[1], right[1]) + 1;
        int oneSide = Math.max(left[0], right[0]);
        int twoSides = left[1] + right[1] + 1;
        info[0] = Math.max(oneSide, twoSides);

        return info;
    }
}
