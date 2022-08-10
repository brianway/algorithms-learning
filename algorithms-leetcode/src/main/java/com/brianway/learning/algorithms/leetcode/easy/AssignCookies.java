package com.brianway.learning.algorithms.leetcode.easy;

import java.util.Arrays;

/**
 * LeetCode 455. Assign Cookies
 * Question: https://leetcode.com/problems/assign-cookies/
 * 关键题设: 无
 *
 * @auther brian
 * @since 2022/8/10 23:40
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        return 0;
    }

    /**
     * 贪心：在s[j]>=g[i]中，挑出最小的s[j]
     * <p>
     * 先对 g 和 s 排序升序，然后从小到大遍历s, 满足 s[j]>=g[i]的就计数
     * <p>
     * 时间复杂度：O(m log m + n log n)
     * 空间复杂度：取决于排序算法
     */
    public class AssignCookies0 extends AssignCookies {
        @Override
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int i = 0;
            int count = 0;
            for (int j = 0; j < s.length; j++) {
                if (i >= g.length) {
                    break;
                }
                if (s[j] >= g[i]) {
                    count++;
                    i++;
                }
            }
            return count;
        }
    }

}
