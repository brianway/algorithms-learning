package com.brianway.learning.algorithms.leetcode.medium;

/**
 * LeetCode 5. Longest Palindromic Substring
 * Question: https://leetcode.com/problems/longest-palindromic-substring/
 * 关键题设:  无
 *
 * @auther brian
 * @since 2022/8/31 22:57
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        return "";
    }

    /**
     * 双指针解法
     * <p>
     * 回文字符串是有中心的，且共用中心的一组回文字符串，往两端延伸最远时最长。
     * 所以，可以确定一个中心字符，然后往两边扩散比对即可
     * 又由于回文字符串长度为奇数和偶数时，中心分别时1个字符和2个字符，所以可以分开讨论：
     * <p>
     * 1.依次以第i个字符为中心字符，看其可往两端延伸的最长长度；
     * 2.依次以第i和i+1个字符为为中心字符，看其可往两端延伸的最长长度；
     * <p>
     * case:
     * "cbd",  maxLen=1, i=1, substr(1,2)
     * "cbabd", maxLen=3, i=2, substr(1,4)
     * "cbbd", maxLen=2, i=1, substr(1,3)
     * "cabbad", maxLen=4, i=2, substr(1,5)
     * <p>
     * <p>
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    public static class LongestPalindromicSubstring0 extends LongestPalindromicSubstring {

        @Override
        public String longestPalindrome(String s) {
            int longestStart = 0;
            int maxLength = 0;
            for (int i = 0; i < s.length(); i++) {
                int odd = maxPalindromicLengthOfOdd(s, i);
                int even = maxPalindromicLengthOfEven(s, i);
                int localMaxLength = Math.max(odd, even);

                if (localMaxLength > maxLength) {
                    maxLength = localMaxLength;
                    longestStart = i;
                }
            }

            if (maxLength % 2 == 1) {
                return s.substring(longestStart - maxLength / 2, longestStart + maxLength / 2 + 1);
            } else {
                return s.substring(longestStart - maxLength / 2 + 1, longestStart + maxLength / 2 + 1);
            }
        }

        /**
         * 奇数
         */
        private int maxPalindromicLengthOfOdd(String s, int i) {
            int left = i;
            int right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            if (right - left == 0) {
                return 1;
            } else {
                return right - left + 1 - 2;
            }
        }

        /**
         * 偶数
         */
        private int maxPalindromicLengthOfEven(String s, int i) {
            int left = i;
            int right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (right - left == 1) {
                return 0;
            } else {
                return right - left + 1 - 2;
            }
        }

    }

    public static void main(String[] args) {
        // String s = "babad";
        String s = "cbbd";
        String l = new LongestPalindromicSubstring0().longestPalindrome(s);

        System.out.println(l);

    }
}
