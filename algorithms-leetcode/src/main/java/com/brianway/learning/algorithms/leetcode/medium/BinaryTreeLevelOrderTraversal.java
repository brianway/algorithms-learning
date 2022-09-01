package com.brianway.learning.algorithms.leetcode.medium;

import com.brianway.learning.algorithms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode 102. Binary Tree Level Order Traversal
 * Question: https://leetcode.com/problems/binary-tree-level-order-traversal/
 * 关键题设：无
 *
 * @auther brian
 * @since 2022/9/1 22:28
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        return null;
    }

    /**
     * BFS，非递归
     * 借助队列
     * 外层循环是树的层之间，内层循环是树每一层内
     */
    public class BinaryTreeLevelOrderTraversal0 extends BinaryTreeLevelOrderTraversal {
        @Override
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                List<Integer> levelItems = new ArrayList<>();

                for (int i = 0; i < levelSize; i++) {
                    TreeNode cur = queue.poll();
                    levelItems.add(cur.val);

                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }

                list.add(levelItems);
            }

            return list;
        }
    }

    /**
     * DFS， 递归
     */
    public class BinaryTreeLevelOrderTraversal1 extends BinaryTreeLevelOrderTraversal {
        @Override
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> list = new ArrayList<>();
            dfs(list, root, 0);
            return list;
        }

        public void dfs(List<List<Integer>> list, TreeNode cur, int depth) {
            if (cur == null) {
                return;
            }

            // size 应该比depth(相当于下标)大， 例如size=1, depth=0, 否则说明未初始化该层
            if (list.size() == depth) {
                list.add(new ArrayList<>());
            }

            list.get(depth).add(cur.val);
            if (cur.left != null) {
                dfs(list, cur.left, depth + 1);
            }

            if (cur.right != null) {
                dfs(list, cur.right, depth + 1);
            }
        }
    }
}
