package com.brianway.learning.algorithms.lectures.binarysearch;

/**
 * Created by brian on 16/11/15.
 *
 * 给定一棵完全二叉树的根节点root，返回这棵树的节点个数。
 * 如果完全二叉树的节点数为N，请实现时间复杂度低于O(N)的解法。
 * 给定树的根结点root，请返回树的大小。
 */
public class CountNodes {
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int count(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int height = 0;
        TreeNode current = root;
        while (current != null) {
            current = current.left;
            height++;
        }
        int rightHeight = 1;
        current = root.right;
        while (current != null) {
            current = current.left;
            rightHeight++;
        }
        int count = 0;
        if (height > rightHeight) {
            count = (1 << (height - 2)) + count(root.left);
        } else {
            count = (1 << (height - 1)) + count(root.right);
        }
        return count;

    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        CountNodes cn = new CountNodes();
        int count = cn.count(t1);
        System.out.println(count);
        System.out.println(cn.count(t2));
    }
}
