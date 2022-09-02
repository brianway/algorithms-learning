package com.brianway.learning.algorithms.leetcode.medium;

import com.brianway.learning.algorithms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode 199. Binary Tree Right Side View
 * Question:  https://leetcode.com/problems/binary-tree-right-side-view/
 * 关键题设：无
 *
 * @auther brian
 * @since 2022/9/2 21:53
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        return null;
    }

    /**
     * BFS，层序遍历
     * 每层只把最后一个加到结果中即可
     */
    public class BinaryTreeRightSideView0 extends BinaryTreeRightSideView {
        @Override
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            if (root == null) {
                return result;
            }
            queue.offer(root);
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                while (levelSize > 0) {
                    TreeNode cur = queue.poll();
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                    levelSize--;

                    // 最后一个元素添加到result
                    if (levelSize == 0) {
                        result.add(cur.val);
                    }
                }
            }
            return result;
        }
    }
}
