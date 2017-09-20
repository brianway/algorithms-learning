package com.brianway.learning.algorithms.lectures.string;

/**
 * Created by brian on 16/11/8.
 *
 * 对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同。
 * 给定两棵二叉树的头结点A和B，请返回一个bool值，代表A中是否存在一棵同构于B的子树。
 *
 * KMP算法讲解博客:
 * http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html
 * http://blog.csdn.net/v_july_v/article/details/7041827
 * http://jakeboxer.com/blog/2009/12/13/the-knuth-morris-pratt-algorithm-in-my-own-words/
 *
 * 移动位数 = 已匹配的字符数 - 对应的部分匹配值
 */
public class IdenticalTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean chkIdentical(TreeNode A, TreeNode B) {
        String a = serialByPre(A);
        String b = serialByPre(B);
        return getIndexOf(a, b) != -1;
    }

    private String serialByPre(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        String current = root.val + "!";
        current = current + serialByPre(root.left);
        current = current + serialByPre(root.right);
        return current;
    }

    private int getIndexOf(String s, String p) {
        char[] ss = s.toCharArray();
        char[] ps = p.toCharArray();
        int i = 0;
        int j = 0;
        int[] next = getNextArray(ps);

        while (i < ss.length && j < ps.length) {
            if (j == -1 || ss[i] == ps[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == ps.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    private int[] getNextArray(char[] p) {
        if (p == null || p.length == 0) {
            return null;
        }
        int k = -1;
        int j = 0;
        int[] next = new int[p.length];
        next[0] = -1;
        while (j < p.length - 1) {
            if (k == -1 || p[j] == p[k]) {
                k++;
                j++;
                if (p[j] != p[k]) {
                    next[j] = k;
                } else {
                    next[j] = next[k];
                }
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        char[] c = "abcab".toCharArray();
        System.out.println(c);
        for (char i : c) {
            System.out.print(i + ",");
        }
        System.out.println();
        int[] next = new IdenticalTree().getNextArray(c);
        for (int i : next) {
            System.out.print(i + ",");
        }
        System.out.println();

    }
}

