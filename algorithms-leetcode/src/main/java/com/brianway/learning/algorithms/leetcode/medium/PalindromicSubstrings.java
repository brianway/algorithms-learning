package com.brianway.learning.algorithms.leetcode.medium;

/**
 * LeetCode 647. Palindromic Substrings
 * Question: https://leetcode.com/problems/palindromic-substrings/
 * 关键题设:  无
 *
 * @auther brian
 * @since 2022/8/25 23:04
 */
public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        return 0;
    }

    /**
     * DP
     * <p>
     * 1. dp数组以及下标含义：dp[i][j] 表示 s[i...j]是否为回文字符串，其中i<=j
     * 2. 递推关系：
     * 如果 s[i]==s[j] 则
     * 1) i==j时，dp[i][j]=true，即单字符串
     * 2) j-i=1时，dp[i][j]=true，例如"aa"
     * 3)j-i>1， dp[i][j] = dp[i+1][j-1]
     * 否则 dp[i][j]=false
     * 3. 初始化: 默认都是false
     * 4. 遍历顺序：从递推关系可以看出， dp[i+1][j-1] 要先于dp[i][j] 计算才行，
     * 所以 i从大到小，j从小到大， 且i<=j， 只用上半部分矩阵即可
     * <p>
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(n^2)
     */
    public class PalindromicSubstrings0 extends PalindromicSubstrings {
        @Override
        public int countSubstrings(String s) {
            boolean[][] dp = new boolean[s.length()][s.length()];
            int count = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = i; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (j - i <= 1) {
                            dp[i][j] = true;
                            count++;
                        } else if (dp[i + 1][j - 1]) {
                            // i + 1和j-1这里不会越界
                            dp[i][j] = true;
                            count++;
                        }
                    }
                    // else false
                }
            }
            return count;
        }
    }

    // TODO 双指针解法
}
