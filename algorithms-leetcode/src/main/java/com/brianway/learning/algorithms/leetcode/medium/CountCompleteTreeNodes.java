package com.brianway.learning.algorithms.leetcode.medium;

import com.brianway.learning.algorithms.leetcode.common.TreeNode;

/**
 * 222. Count Complete Tree Nodes
 * Question: https://leetcode.com/problems/count-complete-tree-nodes/
 * 关键题设: 无
 *
 * @auther brian
 * @since 2022/9/3 16:07
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        return 0;
    }

    /**
     * 递归，后序遍历
     * <p>
     * 1.如果为空 或者 是满二叉树，直接可通过公式得到节点个数
     * 2.否则，返回左子树节点个数和右子树节点个数，求和得到当前根节点下的节点个数
     * <p>
     * 时间复杂度：O(log n × log n)，深度h=log n，
     * 最差情况：只缺最后一个节点就是满二叉树，则每次遍历深度的时间复杂度为 h,h-1,h-2,...,1，加起来是h^2
     * 空间复杂度：O(log n)
     */
    public class CountCompleteTreeNodes0 extends CountCompleteTreeNodes {
        @Override
        public int countNodes(TreeNode root) {
            // 终止条件
            if (root == null) {
                return 0;
            }
            TreeNode left = root.left;
            TreeNode right = root.right;
            int leftDepth = 0;
            int rightDepth = 0;
            while (left != null) {
                left = left.left;
                leftDepth++;
            }
            while (right != null) {
                right = right.right;
                rightDepth++;
            }

            // 说明是满二叉树
            if (leftDepth == rightDepth) {
                // 注意运算符优先级
                return (2 << leftDepth) - 1;
            }

            // 非满二叉树
            // 本层逻辑
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }


    // TODO  二分查找的方法
    // https://leetcode.cn/problems/count-complete-tree-nodes/solution/wan-quan-er-cha-shu-de-jie-dian-ge-shu-by-leetco-2/
}
