package com.brianway.learning.algorithms.leetcode.medium;

/**
 * LeetCode 96. Unique Binary Search Trees
 * Question:https://leetcode.com/problems/unique-binary-search-trees/
 * 关键题设：无
 *
 * @auther brian
 * @since 2022/6/14 23:43
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        return 0;
    }

    /**
     * 思路：动态规划
     * <p>
     * BST节点个数为i时的结构数记为 dp[i], 则dp[i]= ∑ 根节点为j的结构数， j依次取i个节点的每一个。
     * 当根节点为j （1<=j<=i）时，假设小于j的有l个节点，大于j的有r个节点
     * 则左子树就是这l个节点构成的BST，右子树就是这r个节点构成的BST，且l+r+1=i
     * 所以 当根节点为j时的结构数=dp[l]*dp[r]
     * 当j依次取i个节点中的每一个节点，l和r会分别依次 +1 和 -1。
     * 将这些 dp[l]*dp[r] 求和，即可得到 dp[i]
     * <p>
     * 搜索二叉树的特点：左子树的所有节点小于根节点，左子树的所有节点大于根节点
     * <p>
     * 例子：
     * dp[0] = 1 表示子树为空的情况
     * dp[1] = 1 可以直观看出，也由 dp[0]*dp[0] 推导出。写代码时注意不要重复计算 dp[1]
     * dp[2] = dp[0]*dp[1] + dp[1]*dp[0];
     * dp[3] = dp[0]*dp[2] + dp[1]+dp1[1] + dp[2]*dp[0]
     *
     * <p>
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(n)， 由于递推关系中，历史所有规模的子问题都需要记录，所以没法简化了。
     */
    public class UniqueBinarySearchTrees0 extends UniqueBinarySearchTrees {
        @Override
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            // dp[1] = 1; // i从1循环则不需要
            for (int i = 1; i <= n; i++) {
                for (int l = 0; l < i; l++) {
                    // 右子树节点个数 r = i - 1 - l
                    dp[i] = dp[i] + dp[l] * dp[i - 1 - l];
                }
            }
            return dp[n];
        }
    }

}
