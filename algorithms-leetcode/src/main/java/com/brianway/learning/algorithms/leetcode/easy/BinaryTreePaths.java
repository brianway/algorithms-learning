package com.brianway.learning.algorithms.leetcode.easy;

import com.brianway.learning.algorithms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by brian on 16/6/6.
 * LeetCode 257. Binary Tree Paths
 * Question:https://leetcode.com/problems/binary-tree-paths/
 * 关键题设：return all root-to-leaf paths
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        return null;
    }

    /**
     * 深度优先遍历
     * 递归,先访问左子节点,再访问右子节点
     * 递归的终结条件:左右子节点均为空
     * 注意根节点为空的检查
     */
    public class BinaryTreePaths0 extends BinaryTreePaths {
        private List<String> result = new ArrayList<>();

        @Override
        public List<String> binaryTreePaths(TreeNode root) {
            if (root == null) return result;
            searchPath(root, "");
            return result;
        }

        /**
         * 递归遍历二叉树
         *
         * @param currentNode 当前节点
         * @param path        从根节点到达当前节点的路径字符串
         */
        private void searchPath(TreeNode currentNode, String path) {
            //左右节点都为空,该节点为子节点
            if (currentNode.left == null && currentNode.right == null) {
                result.add(path + currentNode.val);
                return;
            }

            String current = currentNode.val + "->";

            if (currentNode.left != null) {
                searchPath(currentNode.left, path + current);
            }
            if (currentNode.right != null) {
                searchPath(currentNode.right, path + current);
            }

        }

    }

    /**
     * 递归
     * 先序遍历， 练习回溯细节
     */
    public class BinaryTreePaths1 extends BinaryTreePaths {
        @Override
        public List<String> binaryTreePaths(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<String> result = new ArrayList<>();
            traversal(root, new ArrayList<>(), result);
            return result;
        }

        public void traversal(TreeNode cur, List<Integer> path, List<String> result) {
            path.add(cur.val);

            // 终止条件
            if (cur.left == null && cur.right == null) {
                String pathString = convertPath(path);
                result.add(pathString);
                // 清除对path的副作用
                path.remove(path.size() - 1);
                return;
            }

            if (cur.left != null) {
                traversal(cur.left, path, result);
            }

            if (cur.right != null) {
                traversal(cur.right, path, result);
            }

            // 清除对path的副作用
            path.remove(path.size() - 1);
        }

        public String convertPath(List<Integer> path) {
            return path.stream().map(Object::toString).collect(Collectors.joining("->"));
        }

    }

}
