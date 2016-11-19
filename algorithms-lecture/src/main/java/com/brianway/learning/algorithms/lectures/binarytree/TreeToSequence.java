package com.brianway.learning.algorithms.lectures.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brian on 16/11/15.
 *
 * 请用递归方式实现二叉树的先序、中序和后序的遍历打印。
 * 给定一个二叉树的根结点root，请依次返回二叉树的先序，中序和后续遍历(二维数组的形式)。
 */
public class TreeToSequence {
    public int[][] convert(TreeNode root) {
        int[][] res = new int[3][];
        ArrayList<Integer> pre = new ArrayList<Integer>();
        ArrayList<Integer> in = new ArrayList<Integer>();
        ArrayList<Integer> post = new ArrayList<Integer>();

        preOrder(pre, root);
        inOrder(in, root);
        postOrder(post, root);

        res[0] = listToArray(pre);
        res[1] = listToArray(in);
        res[2] = listToArray(post);

        return res;
    }

    private void preOrder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        preOrder(list, root.left);
        preOrder(list, root.right);
    }

    private void inOrder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(list, root.left);
        list.add(root.val);
        inOrder(list, root.right);
    }

    private void postOrder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }

        postOrder(list, root.left);
        postOrder(list, root.right);
        list.add(root.val);
    }

    private int[] listToArray(List<Integer> list) {
        if (list == null) {
            return null;
        }
        int len = list.size();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
