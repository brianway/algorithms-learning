package com.brianway.learning.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 56. Merge Intervals
 * Question: https://leetcode.com/problems/merge-intervals/
 * 关键题设:  无
 *
 * @auther brian
 * @since 2022/12/4 22:36
 */
public class MergeIntervals {

    /**
     * 排序
     */
    class Solution {
        public int[][] merge(int[][] intervals) {
            // 按起点排序
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            List<int[]> result = new ArrayList<int[]>();
            int j = 0;
            int[] first = new int[2];
            first[0] = intervals[0][0];
            first[1] = intervals[0][1];
            result.add(first);

            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] <= result.get(j)[1]) {
                    result.get(j)[1] = Math.max(result.get(j)[1], intervals[i][1]);
                } else {
                    j++;
                    result.add(new int[] {intervals[i][0], intervals[i][1]});
                }
            }

            return result.toArray(new int[result.size()][2]);

        }
    }

    /**
     * Solution0的写法优化
     *
     * 1.对线段起点排序
     * 2.依次遍历线段：
     * 如果result没有任何线段则创建新线段；
     * 如果result的最后一个线段的终点 小于 当前线段的起点，则创建新线段；
     * 如果当前线段的起点落在result的最后一个线段的终点前，则合并，即重置result的最后一个线段的终点，新终点:取max{当前线段终点,result的最后一个线段的终点}
     *
     */
    class Solution1 {
        public int[][] merge(int[][] intervals) {
            // 按起点排序
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            List<int[]> result = new ArrayList<int[]>();
            for (int i = 0; i < intervals.length; i++) {
                if (result.size() == 0
                        || result.get(result.size() - 1)[1] < intervals[i][0]) {
                    result.add(new int[] {intervals[i][0], intervals[i][1]});
                } else {
                    result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], intervals[i][1]);
                }

            }

            return result.toArray(new int[result.size()][2]);

        }
    }
}
