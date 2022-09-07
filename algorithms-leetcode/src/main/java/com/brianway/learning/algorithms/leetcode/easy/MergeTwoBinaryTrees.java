package com.brianway.learning.algorithms.leetcode.easy;

import com.brianway.learning.algorithms.leetcode.common.TreeNode;

/**
 * LeetCode 617. Merge Two Binary Trees
 * Question: https://leetcode.com/problems/merge-two-binary-trees/
 * 关键题设：无
 *
 * @auther brian
 * @since 2022/9/7 21:43
 */
public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return null;
    }

    /**
     * 递归
     * <p>
     * 先序遍历/后序遍历都行
     */
    public class MergeTwoBinaryTrees0 extends MergeTwoBinaryTrees {
        @Override
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            // 终止条件
            if (root1 == null && root2 == null) {
                return null;
            } else if (root1 == null) {
                return root2;
            } else if (root2 == null) {
                return root1;
            }

            // merge current
            TreeNode cur = new TreeNode(root1.val + root2.val);
            // merge left
            TreeNode left = mergeTrees(root1.left, root2.left);
            // merge right
            TreeNode right = mergeTrees(root1.right, root2.right);

            cur.left = left;
            cur.right = right;

            return cur;
        }
    }

}
