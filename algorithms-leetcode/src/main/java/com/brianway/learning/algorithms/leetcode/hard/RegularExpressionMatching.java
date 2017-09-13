package com.brianway.learning.algorithms.leetcode.hard;

/**
 * Created by brian on 2017/9/10.
 * LeetCode 10. Regular Expression Matching
 * Question:https://leetcode.com/problems/regular-expression-matching/description/
 * 关键题设：'*' Matches zero or more of the preceding element.
 * 参考链接：
 * http://www.cnblogs.com/grandyang/p/4461713.html
 * http://blog.csdn.net/lisonglisonglisong/article/details/45833355
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        return false;
    }

    /**
     * 递归
     */
    public class RegularExpressionMatching0 extends RegularExpressionMatching {
        @Override
        public boolean isMatch(String s, String p) {
            if (s == null || p == null) {
                return s == null && p == null;
            }
            if (p.length() == 0) {
                return s.length() == 0;
            }

            if (p.length() > 1 && p.charAt(1) == '*') {//有 '*'
                return (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
                        && isMatch(s.substring(1), p)) || isMatch(s, p.substring(2));
            } else {//无 '*'
                return s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
                        && isMatch(s.substring(1), p.substring(1));
            }
        }
    }

    /**
     * 动态规划
     *
     * dp[i][j] 表示 s[0,i) 和 p[0,j) 是否 match，初始条件 dp[0][0] = true, 表示 "" 和 "" 匹配
     *
     * 循环的时候：0<=i<=s.length, 1<=j<=p.length
     *
     * s: s[0] s[1] ... s[i-1] s[i] ...
     * p: p[0] p[1] ... p[j-2] p[j-1] p[j] ...
     *
     * 对于 dp[i][j]，每次看的是 s[i-1] 和 p[j-1] 的匹配情况
     *
     * 1. 有 '*'，即 p[j-1] == '*' （必有 j-1>0 即 j>1）
     *
     * s: s[0] s[1] ... s[i-1] s[i] ...
     * p: p[0] p[1] ... p[j-2] * p[j] ...
     *
     * - a. p[j-2]* 匹配 0 次，即越过 p[j-2] 和 p[j-1]，此时主要看 s[0,i) 和 p[0,j-2) 是否 match；
     * - b. p[j-2]* 匹配至少 1 次，即 p[j-2] 和 s[i－1] 必须要匹配，则此时主要看 s[0,i－1) 和 p[0,j) 是否 match
     *
     * 故 dp[i][j] = dp[i][j-2] || (i > 0 && dp[i-1][j] && (s[i-1] == p[j-2] || p[j-2] == '.'))
     *
     *
     * 2. 无 '*'，即 p[j-1] != '*'
     * 比较 p[j-1] 和 s[i-1] 即可
     *
     * 故 dp[i][j] = i > 0 && dp[i-1][j-1] && (s[i-1]==p[j-1] || p[j-1] == '.')
     *
     * 注意
     * 第一种情况需要特别认真考虑，s="aa",p="a*" 和 s="aaa" p="ab*a*c*a"
     * 尤其 b 情况，p[j-2]* 一定匹配 s[i－1]，所以主要看 p[0,j) 和 s[0,i) 的子串 s[0,i-1) 的匹配情况
     */
    public class RegularExpressionMatching1 extends RegularExpressionMatching {
        @Override
        public boolean isMatch(String s, String p) {
            if (s == null || p == null) {
                return s == null && p == null;
            }
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
            dp[0][0] = true;

            for (int i = 0; i <= s.length(); i++) {
                for (int j = 1; j <= p.length(); j++) {
                    if (j > 1 && p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i][j - 2] || (i > 0 && dp[i - 1][j] &&
                                (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                    } else {
                        dp[i][j] = i > 0 && dp[i - 1][j - 1] &&
                                (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                    }
                }
            }
            return dp[s.length()][p.length()];
        }
    }
}
