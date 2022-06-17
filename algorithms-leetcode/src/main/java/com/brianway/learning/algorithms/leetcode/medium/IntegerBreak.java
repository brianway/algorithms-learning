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

    /**
     * DP
     * 递推公式：dp[i] = max{ max{j,dp[j]} * max{i-j,dp[i-j]}  } (其中, 1<=j<=i-2) }
     * 其他和解法1一样，因为朴素的想法，dp[i]可以拆解成 dp[j]*dp[i-j]
     * 但由于dp[i]表示至少两个数的乘积，故dp[j]*dp[i-j]至少是4个数的乘积，会漏掉2个数和三个数乘积的情况。
     * <p>
     * 简单理解，max{j,dp[j]} 表示第一个因数可以拆成 1个数（即j），也可以拆成两个或两个以上的数（即dp[j]），
     * 这样就不会漏情况了。
     * <p>
     * 进一步说明：
     * 大部分情况下dp[j]是满足dp[j]>j的的，
     * 可以举例看一下：
     * dp[2]=1, dp[3]=2, dp[4]=4, dp[5]=6, ...
     * 可以看出
     * 当i>=4时，dp[i]>=i，
     * 从而  解法1中的 max{j*dp[i-j],j*(i-j)} 提取相同的系数j,有 j * max{i-j, dp[i-j]},
     * 相当于取 max{i-j,dp[i-j]}里的大者。同理，即可得到递推公式。
     * <p>
     * 同时，由于乘法交换率，在遍历时不需要将j从1到i-2， 只需要 j<=i-j 即可
     */
    public class IntegerBreak1 extends IntegerBreak {
        @Override
        public int integerBreak(int n) {
            int[] dp = new int[n + 1];
            dp[2] = 1;

            for (int i = 3; i <= n; i++) {
                // 对某个i，枚举每个j，找到乘积最大的
                for (int j = 1; j <= i - j && j < i - 1; j++) {
                    dp[i] = Math.max(dp[i],
                            Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
                }
            }
            return dp[n];
        }
    }

    //TODO 需要数据证明 每次拆成n个3，如果剩下是4，则保留4，然后相乘。然后使用贪心
}
