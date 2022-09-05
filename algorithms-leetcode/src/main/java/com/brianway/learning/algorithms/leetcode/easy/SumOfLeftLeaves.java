package com.brianway.learning.algorithms.leetcode.easy;

import com.brianway.learning.algorithms.leetcode.common.TreeNode;

/**
 * LeetCode 404. Sum of Left Leaves
 * Question https://leetcode.com/problems/sum-of-left-leaves/
 * 关键题设：A leaf is a node with no children.
 * A left leaf is a leaf that is the left child of another node.
 *
 * @auther brian
 * @since 2022/9/6 00:00
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        return 0;
    }

    /**
     * 递归
     * 后序遍历
     */
    public class SumOfLeftLeaves0 extends SumOfLeftLeaves {
        @Override
        public int sumOfLeftLeaves(TreeNode root) {
            // 终止条件
            if (root == null) {
                return 0;
            }
            // 单层逻辑
            int leftSum = sumOfLeftLeaves(root.left);
            if (root.left != null && root.left.left == null && root.left.right == null) {
                // 仅这个if条件下才会有val值贡献进来
                leftSum = root.left.val;
            }
            int rightSum = sumOfLeftLeaves(root.right);

            return leftSum + rightSum;
        }
    }

    // TODO 迭代写法
}

