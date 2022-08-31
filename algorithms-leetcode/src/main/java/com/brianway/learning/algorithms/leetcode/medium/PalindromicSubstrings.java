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

    /**
     * 双指针解法
     * <p>
     * 回文字符串是有中心的，且共用中心的一组回文字符串，从中心往两端延伸的过程中，每一次延伸都时一个回文字符串。
     * 所以，可以确定一个中心字符，然后往两边扩散比对即可
     * 又由于回文字符串长度为奇数和偶数时，中心分别时1个字符和2个字符，所以可以分开讨论：
     * 1.依次以第i个字符为中心字符，看其可往两端延伸过程中得到回文字符串count
     * 2.依次以第i和i+1个字符为为中心字符，看其可往两端延伸过程中得到回文字符串count
     */
    public class PalindromicSubstrings1 extends PalindromicSubstrings {
        @Override
        public int countSubstrings(String s) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                count += countPalindromicSubstringsOfOdd(s, i);
                count += countPalindromicSubstringsOfEven(s, i);
            }
            return count;
        }

        /**
         * 奇数
         */
        private int countPalindromicSubstringsOfOdd(String s, int i) {
            int left = i;
            int right = i;
            int result = 0;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                result++;
            }

            return result;
        }

        /**
         * 偶数
         */
        private int countPalindromicSubstringsOfEven(String s, int i) {
            int left = i;
            int right = i + 1;
            int result = 0;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                result++;
            }

            return result;
        }

    }
}
