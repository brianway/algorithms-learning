package com.brianway.learning.algorithms.leetcode.medium;

/**
 * LeetCode 343. Integer Break
 * Question: https://leetcode.com/problems/integer-break/
 * 关键题设: positive integers
 *
 * @auther brian
 * @since 2022/6/16 22:42
 */
public class IntegerBreak {

    public int integerBreak(int n) {
        return 0;
    }

    /**
     * DP
     * <p>
     * 1. dp数组下标以及含义：dp[i] 表示拆分数字i可得到的最大乘积
     * 2. 递推公式：dp[i] = max{ max{j*dp[i-j], j*(i-j)} (其中, 1<=j<=i-2) }
     * j * (i - j) 是单纯的把整数拆分为两个数相乘;
     * j * dp[i - j]是拆分成两个以上的个数相乘（j一个数，dp[i - j]至少是两个数相乘）;
     * 为什么不是dp[i - j] * dp[j] ？因为这样就是拆成至少4个数相乘了，会漏一些情况
     * <p>
     * 3. dp数组初始化：dp[2]=1
     * 4. 遍历顺序：从左到右即可
     * <p>
     * 注意边界条件， j < i - 1  可得 i-j>1, 即i-j>=2
     * <p>
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     */
    public class IntegerBreak0 extends IntegerBreak {
        @Override
        public int integerBreak(int n) {
            int[] dp = new int[n + 1];
            dp[2] = 1;

            for (int i = 3; i <= n; i++) {
                // 对某个i，枚举每个j，找到乘积最大的
                for (int j = 1; j < i - 1; j++) {
                    dp[i] = Math.max(dp[i],
                            Math.max(j * (i - j), j * dp[i - j]));
                }
            }
            return dp[n];
        }
    }

    //TODO 需要数据证明 每次拆成n个3，如果剩下是4，则保留4，然后相乘。然后使用贪心
}
