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


    public class IsSubsequence1 extends IsSubsequence {
        @Override
        public boolean isSubsequence(String s, String t) {
            return super.isSubsequence(s, t);
        }
    }

}
