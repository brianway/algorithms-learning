package com.brianway.learning.algorithms.leetcode.easy;

import com.brianway.learning.algorithms.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by brian on 17/8/25.
 * LeetCode 101. Symmetric Tree
 * Question:https://leetcode.com/problems/symmetric-tree/description/
 * 关键题设：无
 * <p>
 * 可参考：http://blog.csdn.net/linhuanmars/article/details/23072829
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return false;
    }

    /**
     * 递归
     * <p>
     * 时间复杂度 O(n)
     * 空间复杂度 O(log n) ，使用的是方法栈，栈深度 log n
     */
    public class SymmetricTree0 extends SymmetricTree {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return compare(root.left, root.right);
        }

        public boolean compare(TreeNode left, TreeNode right) {
            // 终止条件，比较当前left和right
            if (left == null && right == null) {
                return true;
            } else if (left == null && right != null) {
                return false;
            } else if (left != null && right == null) {
                return false;
            } else if (left.val != right.val) {
                return false;
            }

            // 走到这里说明left和right均非空且 left.val == right.val
            // 递归比较
            boolean outside = compare(left.left, right.right);
            boolean inside = compare(left.right, right.left);
            return outside && inside;
        }

    }

    public class SymmetricTree1 extends SymmetricTree {
        /**
         * 递归方式
         * 同解法SymmetricTree0，写法简介些，但省略了一些框架过程
         * <p>
         * 1. 若 root 为空，返回 true
         * 2. 若 root 非空，检查其左右子树是否对称
         * <p>
         * 时间复杂度 O(n)
         * 空间复杂度 使用的是方法栈，栈深度 log n
         */
        @Override
        public boolean isSymmetric(TreeNode root) {
            return root == null || isSymmetric(root.left, root.right);
        }

        /**
         * 1.左节点和右节点均为空，true
         * 2.左节点和右节点均非为空，比较他们的值 val
         * 3.比较 左节点的左子节点 和 右节点的右子节点
         * 4.比较 左节点的右子节点 和 右节点的左子节点
         * <p>
         * 2，3，4 取与，则 true 则对称
         *
         * @param left  左子树
         * @param right 右子树
         * @return 是否对称
         */
        private boolean isSymmetric(TreeNode left, TreeNode right) {
            return left == null && right == null
                    ||
                    (left != null && right != null && left.val == right.val
                            && isSymmetric(left.left, right.right)
                            && isSymmetric(left.right, right.left)
                    );
        }
    }

    public class SymmetricTree2 extends SymmetricTree {
        /**
         * 非递归方式
         * 感觉非递归有很多方法。
         * 一.
         * 1.采用非递归方式先序遍历(中－>左－>右)左子树，将顺序记录下来；
         * 2.再用非递归方式先序遍历右子树，不过这个"先序"要稍微便一下，顺序是(中->右－>左)，记录顺序；
         * 3.比对这两个子树的遍历顺序，一致则对称。
         * <p>
         * 同理，可以稍微变化中序或者后序遍历的顺序来实现其他版本
         * <p>
         * 二. 分别层序列遍历左子树和右子树，每一层对称即可
         * <p>
         * 时间复杂度 O(n)
         * 空间复杂度 O(n)
         */
        @Override
        public boolean isSymmetric(TreeNode root) {
            if (root == null || (root.left == null && root.right == null)) {
                return true;
            }

            if (root.left == null || root.right == null) {
                return false;
            }
            Queue<TreeNode> queue1 = new LinkedList<>();
            Queue<TreeNode> queue2 = new LinkedList<>();
            queue1.offer(root.left);
            queue2.offer(root.right);

            while (!queue1.isEmpty() && !queue2.isEmpty()) {
                TreeNode node1 = queue1.poll();
                TreeNode node2 = queue2.poll();
                if (node1.val != node2.val) {
                    return false;
                }

                if ((node1.left == null && node2.right != null) || (node1.left != null && node2.right == null)) {
                    return false;
                }
                if ((node1.right == null && node2.left != null) || (node1.right != null && node2.left == null)) {
                    return false;
                }

                if (node1.left != null && node2.right != null) {
                    queue1.offer(node1.left);
                    queue2.offer(node2.right);
                }
                if (node1.right != null && node2.left != null) {
                    queue1.offer(node1.right);
                    queue2.offer(node2.left);
                }

            }
            return true;
        }
    }

    /**
     * 队列/栈都行
     * <p>
     * 对SymmetricTree2的简化，一个队列/栈就够了
     * 就是两两 入队出队比较就行了
     */
    public class SymmetricTree3 extends SymmetricTree {
        @Override
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root.left);
            queue.offer(root.right);
            while (!queue.isEmpty()) {
                TreeNode left = queue.poll();
                TreeNode right = queue.poll();

                // 比对二者

                // case1: 都为null, 继续比对队列里的其他的
                if (left == null && right == null) {
                    continue;
                }

                // case2: 不相等，直接false
                if (left == null || right == null || left.val != right.val) {
                    return false;
                }

                // case3: 相等，则继续将子节点入队，按照外侧和内侧添加
                queue.offer(left.left);
                queue.offer(right.right);
                queue.offer(left.right);
                queue.offer(right.left);

            }

            return true;
        }
    }

}
