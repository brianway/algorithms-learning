package com.brianway.learning.algorithms.lectures.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by brian on 16/11/16.
 *
 * 请用非递归方式实现二叉树的先序、中序和后序的遍历打印。
 * 给定一个二叉树的根结点root，请依次返回二叉树的先序，中序和后续遍历(二维数组的形式)。
 */
public class TreeToSequence2 {
    public int[][] convert(TreeNode root) {
        int[][] res = new int[3][];

        res[0] = listToArray(preOrder(root));
        res[1] = listToArray(inOrder(root));
        res[2] = listToArray(postOrder(root));

        return res;
    }

    private List<Integer> preOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        if (root == null) {
            return null;
        }

        TreeNode current = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            current = stack.pop();
            list.add(current.val);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return list;
    }

    private List<Integer> inOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        if (root == null) {
            return null;
        }
        TreeNode current = root;
        stack.push(root);
        while (!stack.isEmpty()) {
            if (current == null || current.left == null) {
                current = stack.pop();
                list.add(current.val);
                if (current.right != null) {
                    stack.push(current.right);
                }
                current = current.right;
            } else {// current != null && current.left != null
                stack.push(current.left);
                current = current.left;
            }
        }

        return list;
    }

    private List<Integer> postOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) {
            return null;
        }

        TreeNode last = root;
        TreeNode current = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            current = stack.peek();
            if (current.left != null && last != current.left && last != current.right) {
                stack.push(current.left);
            } else if (current.right != null && last != current.right) {
                stack.push(current.right);
            } else {
                last = stack.pop();
                list.add(last.val);
            }
        }

        return list;
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
