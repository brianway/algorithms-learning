package com.brianway.learning.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 131. Palindrome Partitioning
 * Question: https://leetcode.com/problems/palindrome-partitioning/
 * 关键题设:  无
 *
 * @auther brian
 * @since 2022/12/5 21:01
 */
public class PalindromePartitioning {
    /**
     * 回溯
     * <p>
     * 时间复杂度 O(n * 2^n)
     * 空间复杂度 O(n)  递归调用栈的高度为 n
     */
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> result = new ArrayList<>();
            char[] charArr = s.toCharArray();
            backtracking(result, new LinkedList<String>(), charArr, 0);
            return result;
        }

        public void backtracking(List<List<String>> result, LinkedList<String> path, char[] charArr, int start) {
            if (start == charArr.length) {
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = start; i < charArr.length; i++) {
                if (!isPalindrome(charArr, start, i)) {
                    continue;
                }
                path.addLast(new String(charArr, start, i - start + 1));
                backtracking(result, path, charArr, i + 1);
                path.removeLast();
            }

        }

        public boolean isPalindrome(char[] charArr, int start, int end) {
            while (start <= end) {
                if (charArr[start++] != charArr[end--]) {
                    return false;
                }
            }
            return true;
        }
    }

}
