package com.brianway.learning.algorithms.leetcode.medium;

import com.brianway.learning.algorithms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 113. Path Sum II
 * Question: https://leetcode.com/problems/path-sum-ii/
 * 关键题设：无
 *
 * @auther brian
 * @since 2022/9/6 21:53
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return null;
    }

    /**
     * 递归解法
     * <p>
     * 先序遍历
     */
    public class PathSumII0 extends PathSumII {
        @Override
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> allPath = new ArrayList<>();
            if (root == null) {
                return allPath;
            }
            searchPath(root, targetSum, new ArrayList<>(), allPath);
            return allPath;
        }

        public void searchPath(TreeNode cur, int remainTarget,
                               List<Integer> path, List<List<Integer>> allPath) {
            // 终止条件
            if (cur == null) {
                return;
            }

            // 本层逻辑
            path.add(cur.val);
            remainTarget = remainTarget - cur.val;

            if (cur.left == null && cur.right == null) {
                if (remainTarget == 0) {
                    // 这里需要深拷贝
                    allPath.add(new ArrayList<>(path));
                }
                // 还原现场
                path.remove(path.size() - 1);
                return;
            }

            searchPath(cur.left, remainTarget, path, allPath);
            searchPath(cur.right, remainTarget, path, allPath);

            // 还原现场
            path.remove(path.size() - 1);
        }
    }
}
