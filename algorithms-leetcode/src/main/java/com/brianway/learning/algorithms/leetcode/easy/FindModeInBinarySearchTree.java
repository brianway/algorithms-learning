package com.brianway.learning.algorithms.leetcode.easy;

import com.brianway.learning.algorithms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 501. Find Mode in Binary Search Tree
 * Question: https://leetcode.com/problems/find-mode-in-binary-search-tree/
 * 关键题设：无
 *
 * @auther brian
 * @since 2022/9/7 23:07
 */
public class FindModeInBinarySearchTree {
    public int[] findMode(TreeNode root) {
        return null;
    }

    /**
     * 递归
     * <p>
     * 中序遍历，一次遍历即可：边统计频次，边更新int[]
     */
    public class FindModeInBinarySearchTree0 extends FindModeInBinarySearchTree {
        List<Integer> result = new ArrayList<>();
        int maxCount;
        int count;
        int preVal = Integer.MIN_VALUE;

        @Override
        public int[] findMode(TreeNode root) {
            transversal(root);
            return result.stream().mapToInt(i -> i).toArray();
        }

        public void transversal(TreeNode root) {
            if (root == null) {
                return;
            }

            // 左
            transversal(root.left);

            // 中
            if (preVal == root.val) {
                count++;
            } else {
                count = 1;
            }

            // 更新 maxCount 和  result
            if (count > maxCount) {
                maxCount = count;
                result.clear();
                result.add(root.val);
            } else if (count == maxCount) {
                result.add(root.val);
            }

            preVal = root.val;

            // 右
            transversal(root.right);

        }
    }

}
