package com.brianway.learning.algorithms.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 3. Longest Substring Without Repeating Characters
 * Question: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 关键题设:  无
 * * @auther brian
 *
 * @since 2022/11/30 23:37
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        return 0;
    }

    /**
     * 滑动窗口+hash表
     *
     * 测试用例："tmmzuxt"
     */
    public class LongestSubstringWithoutRepeatingCharacters0 extends LongestSubstringWithoutRepeatingCharacters {
        @Override
        public int lengthOfLongestSubstring(String s) {
            char[] chars = s.toCharArray();
            Map<Character, Integer> exist = new HashMap<>();
            int maxLen = 0;
            int start = 0;

            for (int i = 0; i < chars.length; i++) {
                Integer lastIndex = exist.get(chars[i]);
                if (lastIndex == null || lastIndex < start) {
                    // 未出现过，或者出现在左指针之前，直接计算length
                    maxLen = Math.max(i - start + 1, maxLen);
                } else {
                    // 当前chars[i]出现在start后，则需要右移start
                    start = lastIndex + 1;
                }
                exist.put(chars[i], i);
            }
            return maxLen;
        }
    }

}
