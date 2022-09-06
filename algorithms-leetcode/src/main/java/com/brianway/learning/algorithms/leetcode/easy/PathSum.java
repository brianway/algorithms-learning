package com.brianway.learning.algorithms.leetcode.easy;

import com.brianway.learning.algorithms.leetcode.common.TreeNode;

/**
 * LeetCode 112. Path Sum
 * Question: https://leetcode.com/problems/path-sum/
 * 关键题设：无
 *
 * @auther brian
 * @since 2022/9/6 21:41
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return false;
    }

    public class PathSum0 extends PathSum {
        @Override
        public boolean hasPathSum(TreeNode root, int targetSum) {
            // 终止条件: null or 叶子节点
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null) {
                return targetSum - root.val == 0;
            }

            // 本层逻辑
            return hasPathSum(root.left, targetSum - root.val)
                    || hasPathSum(root.right, targetSum - root.val);
        }
    }
}
