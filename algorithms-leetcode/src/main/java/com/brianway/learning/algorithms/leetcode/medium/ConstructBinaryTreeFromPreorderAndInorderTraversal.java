package com.brianway.learning.algorithms.leetcode.medium;

import com.brianway.learning.algorithms.leetcode.common.TreeNode;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Question: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 关键题设：preorder and inorder consist of unique values.
 *
 * @auther brian
 * @since 2022/5/12 22:59
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return null;
    }

    /**
     * 解法1： 递归实现
     * <p>
     * 前序遍历结果： [ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
     * 中序遍历结果：[ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
     * 即
     * 前序遍历结果：[preRootIndex, [preLeftStart,..., preLeftEnd], [preRightStart,..., preRightEnd]]
     * 中序遍历结果：[[inLeftStart,..., inLeftEnd], inRootIndex, [inRightStart, ..., inRightEnd] ]
     * <p>
     * <p>
     * 每行各五个变量，且有如下关系
     * 1) 前序，根据下标的相邻关系有： preLeftStart = preRootIndex+1, preRightStart = preLeftEnd+1。 可转换为三个变量：
     * [preRootIndex, [preRootIndex+1, ..., preLeftEnd], [preLeftEnd+1 ,..., preRightEnd]]
     * <p>
     * 2) 中序，根据下标的相邻关系有： inLeftEnd = inRootIndex-1,  inRightStart = inRootIndex+1。可转换为三个变量：
     * [[inLeftStart,..., inRootIndex-1], inRootIndex, [inRootIndex+1, ..., inRightEnd] ]
     * <p>
     * 3) 根据两种遍历结果的左子树节点个数不变，有preLeftEnd-preLeftStart = inLeftEnd-inLeftStart 可得，
     * preLeftEnd = （inLeftEnd-inLeftStart）+ preLeftStart
     * = （inRootIndex-1 - inLeftStart）+ preRootIndex+1
     * = inRootIndex - inLeftStart + preRootIndex
     * <p>
     * 所以上述六个变量可以继续简化掉 preLeftEnd， 得到五个变量：
     * [preRootIndex, [preRootIndex+1, ..., inRootIndex - inLeftStart + preRootIndex], [inRootIndex - inLeftStart + preRootIndex +1 ,..., preRightEnd]]
     * [[inLeftStart,..., inRootIndex-1], inRootIndex, [inRootIndex+1, ..., inRightEnd] ]
     * <p>
     * <p>
     * 令前序遍历的子数组的下标起止为 preStart, preEnd；中序遍历子数组的下标起止为inStart，inEnd
     * 则有：
     * preRootIndex = preStart；
     * preRightEnd = preEnd；
     * inLeftStart = inStart；
     * inRightEnd = inEnd
     * <p>
     * 所以最后的下标关系如下：
     * [preStart, [preStart+1, ..., inRootIndex - inStart + preStart], [inRootIndex - inStart + preStart +1 ,..., preEnd]]
     * [[inStart,..., inRootIndex-1], inRootIndex, [inRootIndex+1, ..., inEnd] ]
     * <p>
     * <p>
     * 注意边界情况：子数组的下标起止 可能只有一个元素，也可能越界。例如：preorder=[1,2], inorder=[2,1]
     * <p>
     * TODO
     * 时间复杂度 O(?)
     * 空间复杂度 O(1)
     */
    public static class ConstructBinaryTreeFromPreorderAndInorderTraversal0 extends ConstructBinaryTreeFromPreorderAndInorderTraversal {
        @Override
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        public TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                                  int[] inorder, int inStart, int inEnd) {
            // 边界情况
            if (preStart > preEnd || inStart > inEnd) {
                return null;
            }

            // 只有一个节点
            if (preStart == preEnd || inStart == inEnd) {
                return new TreeNode(preorder[preStart]);
            }

            int inRootIndex = findInRootIndex(preorder[preStart], inorder, inStart, inEnd);

            TreeNode preLeftTree = buildTree(preorder, preStart + 1, inRootIndex - inStart + preStart,
                    inorder, inStart, inRootIndex - 1);
            TreeNode preRightTree = buildTree(preorder, inRootIndex - inStart + preStart + 1, preEnd,
                    inorder, inRootIndex + 1, inEnd);

            TreeNode preRoot = new TreeNode(preorder[preStart], preLeftTree, preRightTree);

            return preRoot;
        }

        public int findInRootIndex(int target, int[] inorder, int inStart, int inEnd) {
            for (int i = inStart; i <= inEnd; i++) {
                if (inorder[i] == target) {
                    return i;
                }
            }
            throw new IllegalArgumentException("not each value of preorder also appears in inorder");
        }
    }

}
