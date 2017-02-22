package com.brianway.learning.algorithms.lectures.binarytree;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by brian on 16/11/15.
 *
 * 自定义的辅助类,用于快速创建测试用例
 */
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode createTree(String[] sequence) {
        LinkedList<String> list = new LinkedList<String>();
        list.addAll(Arrays.asList(sequence));
        return create(list);
    }

    private static TreeNode create(LinkedList<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        String s = list.poll();
        if (s.equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = create(list);
        root.right = create(list);

        return root;
    }
}
