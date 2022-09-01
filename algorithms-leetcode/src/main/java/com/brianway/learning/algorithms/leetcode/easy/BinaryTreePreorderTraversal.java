package com.brianway.learning.algorithms.leetcode.easy;

import com.brianway.learning.algorithms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode 144. Binary Tree Preorder Traversal
 * Question https://leetcode.com/problems/binary-tree-preorder-traversal/
 * 关键题设：preorder traversal
 *
 * @auther brian
 * @since 2022/9/1 21:32
 */
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        return null;
    }

    /**
     * 递归解法
     * <p>
     * 递归三要素：
     * 1.确定递归函数的参数和返回值
     * 2.确定终止条件
     * 3.确定单层递归的逻辑
     * <p>
     * https://github.com/youngyangyang04/leetcode-master/blob/master/problems/%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E9%80%92%E5%BD%92%E9%81%8D%E5%8E%86.md
     */
    public class BinaryTreePreorderTraversal0 extends BinaryTreePreorderTraversal {
        @Override
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            preorder(list, root);
            return list;
        }

        public void preorder(List<Integer> list, TreeNode cur) {
            if (cur == null) {
                return;
            }
            list.add(cur.val);
            preorder(list, cur.left);
            preorder(list, cur.right);
        }
    }

    /**
     * 非递归写法
     * <p>
     * 使用栈
     * 先处理中间节点，然后将其右孩子加入栈，再加入左孩子。
     * 这样，左孩子先出栈，从而实现"中左右"的遍历顺序
     * <p>
     * 涉及两个动作：
     * - 访问：遍历节点
     * - 处理：将元素放进result数组中
     * <p>
     * 先序遍历，要访问的元素和要处理的元素顺序是一致的，都是中间节点。
     */
    public class BinaryTreePreorderTraversal1 extends BinaryTreePreorderTraversal {
        @Override
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                list.add(cur.val);
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }

            }

            return list;
        }
    }

}
