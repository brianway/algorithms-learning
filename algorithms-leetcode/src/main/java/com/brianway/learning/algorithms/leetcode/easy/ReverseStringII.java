package com.brianway.learning.algorithms.leetcode.easy;

/**
 * LeetCode 541. Reverse String II
 * Question: https://leetcode.com/problems/reverse-string-ii/
 * 关键题设：无
 *
 * @auther brian
 * @since 2022/9/9 00:05
 */
public class ReverseStringII {

    public String reverseStr(String s, int k) {
        return null;
    }

    public class ReverseStringII0 extends ReverseStringII {
        @Override
        public String reverseStr(String s, int k) {
            char[] ss = s.toCharArray();
            int len = 2 * k;
            for (int i = 0; i < ss.length; i = i + len) {
                reversePart(ss, i, Math.min(i + k, ss.length));
            }
            return new String(ss);
        }

        public void reversePart(char[] ss, int lowInclusive, int highExclusive) {
            char tmp;
            for (int i = lowInclusive; i < lowInclusive + (highExclusive - lowInclusive) / 2; i++) {
                tmp = ss[i];
                ss[i] = ss[highExclusive + lowInclusive - 1 - i];
                ss[highExclusive + lowInclusive - 1 - i] = tmp;
            }
        }

        public void reversePart2(char[] ss, int lowInclusive, int highExclusive) {
            int highInclusive = highExclusive - 1;
            char tmp;
            while (lowInclusive < highInclusive) {
                tmp = ss[lowInclusive];
                ss[lowInclusive] = ss[highInclusive];
                ss[highInclusive] = tmp;
                lowInclusive++;
                highInclusive--;
            }
        }

    }
}
