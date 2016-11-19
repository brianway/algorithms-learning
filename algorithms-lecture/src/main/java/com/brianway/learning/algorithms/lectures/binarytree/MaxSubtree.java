package com.brianway.learning.algorithms.lectures.binarytree;

/**
 * Created by brian on 16/11/16.
 *
 * 有一棵二叉树，其中所有节点的值都不一样,找到含有节点最多的搜索二叉子树,并返回这棵子树的头节点.
 * 给定二叉树的头结点root，请返回所求的头结点,若出现多个节点最多的子树，返回头结点权值最大的。
 */
public class MaxSubtree {
    public TreeNode getMax(TreeNode root) {
        int[] res = new int[3];
        return maxBST(root, res);
    }

    //info[0]:BSTNodeCount
    //info[1]:minValue
    //info[2]:maxValue
    private TreeNode maxBST(TreeNode root, int[] info) {
        if (root == null) {
            info[0] = 0;
            info[1] = Integer.MAX_VALUE;
            info[2] = Integer.MIN_VALUE;
            return null;
        }

        int[] left = new int[3];
        int[] right = new int[3];
        TreeNode BSTroot = null;

        TreeNode leftBST = maxBST(root.left, left);
        TreeNode rightBST = maxBST(root.right, right);

        if (leftBST == root.left && left[2] < root.val && rightBST == root.right && right[1] > root.val) {
            info[0] = left[0] + right[0] + 1;
            info[1] = leftBST == null ? root.val : left[1];
            info[2] = rightBST == null ? root.val : right[2];
            BSTroot = root;
        } else {
            if (left[0] > right[0]) {
                BSTroot = leftBST;
                copyArray(info, left);
            } else if (left[0] < right[0]) {
                BSTroot = rightBST;
                copyArray(info, right);
            } else {
                BSTroot = leftBST.val > rightBST.val ? leftBST : rightBST;
                int[] tmp = leftBST.val > rightBST.val ? left : right;
                copyArray(info, tmp);
            }
        }

        return BSTroot;
    }

    private void copyArray(int[] copy, int[] original) {
        System.arraycopy(original, 0, copy, 0, copy.length);
//        for (int i = 0; i < original.length; i++) {
//            copy[i] = original[i];
//        }
    }

    public static void main(String[] args) {
        String[] input = {"6", "5", "#", "4", "#", "1", "#", "2", "3", "#", "#", "#", "#"};
        TreeNode root = TreeNode.createTree(input);
        TreeToString tts = new TreeToString();
        String output = tts.toString(root);
        System.out.println(output);

        MaxSubtree ms = new MaxSubtree();
        String res = tts.toString(ms.getMax(root));
        System.out.println(res);
    }

}
