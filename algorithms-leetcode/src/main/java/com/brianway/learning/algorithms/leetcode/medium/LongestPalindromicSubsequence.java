package com.brianway.learning.algorithms.leetcode.medium;

/**
 * LeetCode 516. Longest Palindromic Subsequence
 * Question: https://leetcode.com/problems/longest-palindromic-subsequence/
 * 关键题设:  无
 *
 * @auther brian
 * @since 2022/8/30 22:54
 */
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        return 0;
    }

    /**
     * DP
     * <p>
     * 1. dp数组以及下标含义：dp[i][j] 表示 s[i...j] 的回文子序列的最大长度
     * 2. 递推关系：
     * 如果 s[i]==s[j]，则 dp[i][j] = dp[i+1][j-1]+2，表示s[i]和s[j]分别作为新的回文子序列的两端
     * 如果 s[i]!=s[j]，则 dp[i][j] = max{dp[i+1][j],dp[i][j-1]}, 表示取s[i+1...j]和s[i...j-1]的回文子序列长度的较大者
     * 3. 初始化：i==j时，dp[i][j]=1
     * 4. 遍历顺序：i从大到小，j从小到大，且i<=j,所以只需要上半个矩阵
     */
    public class LongestPalindromicSubsequence0 extends LongestPalindromicSubsequence {
        @Override
        public int longestPalindromeSubseq(String s) {
            int[][] dp = new int[s.length()][s.length()];
            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = i; j < s.length(); j++) {
                    if (i == j) {
                        dp[i][j] = 1;
                    } else if (s.charAt(i) == s.charAt(j)) {
                        // 即使i+1>j-1时，dp[i + 1][j - 1]=0， 所以dp[i][j]=2，即"aa"，i=0,j=1，dp[0][1]=dp[1][0]+2=2这种情况
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[0][s.length() - 1];
        }
    }
}
