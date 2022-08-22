package com.brianway.learning.algorithms.leetcode.easy;

/**
 * LeetCode 392. Is Subsequence
 * Question: https://leetcode.com/problems/is-subsequence/
 * 关键题设：无
 *
 * @auther brian
 * @since 2022/8/18 23:36
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        return false;
    }

    /**
     * 双指针
     * <p>
     * i表示当前要比较（尚未匹配）的字符，同时起大小刚好等于已经匹配的s中的字符数
     * j用于遍历t
     * <p>
     * 时间复杂度 O(n), n是t.length()
     * 空间复杂度 O(1)
     */
    public class IsSubsequence0 extends IsSubsequence {
        @Override
        public boolean isSubsequence(String s, String t) {
            int i = 0;
            for (int j = 0; j < t.length() && i < s.length(); j++) {
                if (t.charAt(j) == s.charAt(i)) {
                    i++;
                }
            }
            return i == s.length();
        }
    }

    /**
     * DP解法
     * <p>
     * 1. dp数组以及下标含义： dp[i+1][j+1] 表示 s的[0...i] 和 t[0...j]的相同子序列的长度
     * 2. 递推关系：
     * if(s[i]==t[j])  dp[i+1][j+1] = dp[i][j]+1
     * else dp[i+1][j+1]=dp[i+1][j]  表示看s的[0...i] 和 t[0...j-1]的相同子序列的长度
     * 3. 初始化：dp[0][0]=0
     * 4. 遍历顺序：从左到右
     * <p>
     * 最后看 dp[s.len][t.len] == s.len
     */
    public class IsSubsequence1 extends IsSubsequence {
        @Override
        public boolean isSubsequence(String s, String t) {
            int[][] dp = new int[s.length() + 1][t.length() + 1];
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < t.length(); j++) {
                    if (t.charAt(j) == s.charAt(i)) {
                        dp[i + 1][j + 1] = dp[i][j] + 1;
                    } else {
                        dp[i + 1][j + 1] = dp[i + 1][j];
                    }
                }
            }
            return dp[s.length()][t.length()] == s.length();
        }
    }

}
