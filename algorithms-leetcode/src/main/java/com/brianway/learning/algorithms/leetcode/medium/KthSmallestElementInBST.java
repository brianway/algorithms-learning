package com.brianway.learning.algorithms.leetcode.medium;

import com.brianway.learning.algorithms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 230. Kth Smallest Element in a BST
 * Question: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * 关键题设：无
 *
 * @auther brian
 * @since 2022/5/17 21:45
 */
public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        return 0;
    }

    /**
     * 常规解法：中序遍历BST，到第k个即可。
     * <p>
     * 中序遍历采用递归实现
     */
    public static class KthSmallestElementInBST0 extends KthSmallestElementInBST {
        @Override
        public int kthSmallest(TreeNode root, int k) {
            List<Integer> list = new ArrayList<>();
            inorder(list, root, k);
            return list.get(list.size() - 1);
        }

        public boolean inorder(List<Integer> list, TreeNode tree, int k) {
            if (tree == null) {
                return false;
            }
            if (inorder(list, tree.left, k)) {
                return true;
            }

            list.add(tree.val);
            if (list.size() == k) {
                return true;
            }

            if (inorder(list, tree.right, k)) {
                return true;
            }
            return false;
        }
    }

    // TODO 看看其他解法
}
