package com.brianway.learning.algorithms.leetcode.medium;

import com.brianway.learning.algorithms.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 513. Find Bottom Left Tree Value
 * Question https://leetcode.com/problems/find-bottom-left-tree-value/
 * 关键题设：leftmost value in the last row of the tree.
 *
 * @auther brian
 * @since 2022/9/6 00:19
 */
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        return 0;
    }

    /**
     * 层序迭代遍历
     * <p>
     * 每层只记录第一个元素即可，每次用新的第一个元素覆盖旧的，则最后的结果就是最后一层的最左元素
     */
    public class FindBottomLeftTreeValue0 extends FindBottomLeftTreeValue {
        @Override
        public int findBottomLeftValue(TreeNode root) {
            // 题设：root not null
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int result = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();

                    if (i == 0) {
                        result = cur.val;
                    }

                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }

            }

            return result;
        }
    }

    /**
     * 递归解法
     * <p>
     * 先序遍历
     */
    public class FindBottomLeftTreeValue1 extends FindBottomLeftTreeValue {
        // 这两个参数其实也可以作为递归方法的入参，只不过int没法传引用，所以简单点，直接放在类变量了
        int maxDepth;
        int bottomLeftValue;

        @Override
        public int findBottomLeftValue(TreeNode root) {
            // root nerver null

            // init
            maxDepth = Integer.MIN_VALUE;
            bottomLeftValue = 0;

            traversal(root, 0);
            return bottomLeftValue;
        }

        public void traversal(TreeNode cur, int depth) {
            // 终止条件：叶子节点
            if (cur.left == null && cur.right == null) {
                if (depth > maxDepth) {
                    maxDepth = depth;
                    bottomLeftValue = cur.val;
                }
                return;
            }

            if (cur.left != null) {
                // 这里传形参，相当于回溯了
                traversal(cur.left, depth + 1);
            }
            if (cur.right != null) {
                traversal(cur.left, depth + 1);
            }

        }
    }
}
