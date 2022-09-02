package com.brianway.learning.algorithms.leetcode.easy;

import com.brianway.learning.algorithms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode 637. Average of Levels in Binary Tree
 * Question https://leetcode.com/problems/average-of-levels-in-binary-tree/
 * 关键题设：无
 *
 * @auther brian
 * @since 2022/9/2 22:26
 */
public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        return null;
    }

    public class AverageOfLevelsInBinaryTree0 extends AverageOfLevelsInBinaryTree {
        @Override
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> result = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            if (root == null) {
                return result;
            }
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                Double sum = 0.0;
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    sum += cur.val;
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
                result.add(sum / size);
            }
            return result;
        }
    }
}
