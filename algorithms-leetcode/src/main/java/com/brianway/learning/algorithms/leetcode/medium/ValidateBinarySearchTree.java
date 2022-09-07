package com.brianway.learning.algorithms.leetcode.medium;

import com.brianway.learning.algorithms.leetcode.common.TreeNode;

/**
 * LeetCode 98. Validate Binary Search Tree
 * Question https://leetcode.com/problems/validate-binary-search-tree/
 * 关键题设：无
 *
 * @auther brian
 * @since 2022/9/7 22:14
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return false;
    }

    /**
     * 递归
     * <p>
     * 注意：不是只比较每一层的cur > left,cur < right就完了
     * 需要 cur> any of left, cur < any of right
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)， 递归用到了栈
     */
    public class ValidateBinarySearchTree0 extends ValidateBinarySearchTree {
        @Override
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        /**
         * 判断root是否在区间 (min, max) 内，左开右开
         * 因为测试数据范围是可能到 Integer.MIN_VALUE 和 Integer.MAX_VALUE，所以这里用long
         *
         * @param root 当前节点
         * @param min  下限
         * @param max  上限
         * @return 是否BST
         */
        public boolean isValidBST(TreeNode root, long min, long max) {
            if (root == null) {
                return true;
            }

            if (root.val <= min || root.val >= max) {
                return false;
            }

            return isValidBST(root.left, min, root.val)
                    && isValidBST(root.right, root.val, max);
        }
    }

    // TODO 中序遍历，递归/迭代， 然后检查数组是否递增即可
    // 中序遍历可以加一个pre指针，表示上一次访问的节点

}
