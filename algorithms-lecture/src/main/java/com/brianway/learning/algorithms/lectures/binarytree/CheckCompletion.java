package com.brianway.learning.algorithms.lectures.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by brian on 16/11/16.
 *
 * 有一棵二叉树,请设计一个算法判断它是否是完全二叉树。
 * 给定二叉树的根结点root，请返回一个bool值代表它是否为完全二叉树。
 * 树的结点个数小于等于500。
 */
public class CheckCompletion {
    public boolean chk(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode current = null;
        boolean lastParent = false;
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (current.right != null && current.left == null) {
                return false;
            }
            if (lastParent && !isLeaf(current)) {
                return false;
            }
            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            } else {
                lastParent = true;
            }

        }
        return true;
    }

    private boolean isLeaf(TreeNode leaf) {
        return leaf.left == null && leaf.right == null;
    }

}
