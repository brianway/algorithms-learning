package com.brianway.learning.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 49. Group Anagrams
 * Question: https://leetcode.com/problems/group-anagrams/
 * 关键题设:  无
 *
 * @auther brian
 * @since 2022/12/2 22:49
 */
public class GroupAnagrams {

    /**
     * 排序
     */
    class Solution0 {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                char[] chars = strs[i].toCharArray();
                Arrays.sort(chars);
                String asc = new String(chars);

                map.computeIfAbsent(asc, k -> new ArrayList<String>());

                List<String> group = map.get(asc);
                group.add(strs[i]);
            }
            return new ArrayList<>(map.values());
        }
    }

}
