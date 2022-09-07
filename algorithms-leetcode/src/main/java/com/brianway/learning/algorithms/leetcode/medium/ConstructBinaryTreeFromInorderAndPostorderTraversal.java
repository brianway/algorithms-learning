package com.brianway.learning.algorithms.leetcode.medium;

import com.brianway.learning.algorithms.leetcode.common.TreeNode;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * Question: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 关键题设：inorder and postorder consist of unique values.
 *
 * @auther brian
 * @since 2022/9/7 21:08
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return null;
    }

    /**
     * 递归
     */
    public class ConstructBinaryTreeFromInorderAndPostorderTraversal0 extends ConstructBinaryTreeFromInorderAndPostorderTraversal {
        @Override
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }

        /**
         * root=postorder[postHigh], 在inorder中找到inRootIndex, 则
         * inorder左子树：[inLow, inRootIndex-1],
         * inorder右子树： [inRootIndex+1, inHigh]
         * <p>
         * 下面确定postorder的左右子树的数组下标边界
         * 左子树的size=inRootIndex-inLow
         * 右子树的size=inHigh-(inRootIndex+1)+1=inHigh-inRootIndex
         * <p>
         * postorder左子树：[postLow, postLow+左子树的size-1]
         * postorder右子树：[postHigh-1-右子树的size+1 ,postHigh-1]
         * <p>
         * 暂留：
         * 又（postLow+左子树的size-1） +1= postHigh-1-右子树的size+1
         * postLow+左子树的size= postHigh-右子树的size
         * postLow+inRootIndex-inLow=postHigh-（inHigh-inRootIndex）
         * postLow-inLow=postHigh-inHigh
         * <p>
         * <p>
         * 时间复杂度 O(n log n)  假设二叉树层数为k, 每一层找inorder的根节点下标都平均需要遍历 n/2,  所以 时间复杂度 O(k*n),
         * 极端情况下，k=n，且每一层遍历都是n, 时间复杂度退化为  O(n^2)
         * 空间复杂度 O(1)
         */
        public TreeNode buildTree(int[] inorder, int inLow, int inHigh, int[] postorder, int postLow, int postHigh) {
            // 终止条件
            if (inHigh < inLow) {
                return null;
            }
            if (inHigh == inLow) {
                return new TreeNode(inorder[inHigh]);
            }

            int root = postorder[postHigh];
            // find inRootIndex
            int inRootIndex = findInorderRootIndex(root, inorder, inLow, inHigh);
            TreeNode left = buildTree(inorder, inLow, inRootIndex - 1,
                    postorder, postLow, postLow + inRootIndex - inLow - 1);
            TreeNode right = buildTree(inorder, inRootIndex + 1, inHigh,
                    postorder, postHigh - (inHigh - inRootIndex), postHigh - 1);
            return new TreeNode(root, left, right);
        }
    }

    public int findInorderRootIndex(int root, int[] inorder, int low, int high) {
        for (int i = low; i <= high; i++) {
            if (inorder[i] == root) {
                return i;
            }
        }
        throw new IllegalArgumentException("not found");
    }
}
