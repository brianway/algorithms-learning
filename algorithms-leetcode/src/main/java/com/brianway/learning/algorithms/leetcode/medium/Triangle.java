package com.brianway.learning.algorithms.leetcode.medium;

import java.util.List;

/**
 * Created by brian on 2017/9/9.
 * LeetCode 120. Triangle
 * Question:https://leetcode.com/problems/triangle/description/
 * 关键题设：adjacent numbers on the row below
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        return 0;
    }

    /**
     * 动态规划
     * 对于每一行，使用一个数组 int [] mins 保存从顶点到该行的每一个元素的最小和
     * 即，对于每一行 int [] row，mins[i] 表示从顶点到 row[i] 的最小和
     * 记上一行 mins 为 last,
     * 则 mins[i] = min(last[i - 1], last[i]) + row[i]
     * 即对每一个 row[i]，它总是从 last[i - 1] 和 last[i] 中挑一个值小的作为路径，
     *
     * 注意：
     * 1. 每一行的  row[0] 和 row[n-1] 只有一种选择，要留意
     * 2. 不用保存每一行的 mins，因为实际只用到了上一行和当前行，所以使用两个数组交替即可
     *
     * 空间复杂度 O(n)，n 为三角形的行数
     */
    public class Triangle0 extends Triangle {
        @Override
        public int minimumTotal(List<List<Integer>> triangle) {
            int[] mins1 = new int[triangle.size()];
            int[] mins2 = new int[triangle.size()];
            int[] mins, last;
            for (List<Integer> row : triangle) {
                mins = row.size() % 2 == 1 ? mins1 : mins2;
                last = row.size() % 2 == 0 ? mins1 : mins2;

                for (int i = 0; i < row.size(); i++) {
                    if (i == 0) {
                        mins[i] = last[i] + row.get(i);// no mins[i-1]
                    } else if (i == row.size() - 1) {
                        mins[i] = last[i - 1] + row.get(i); // no mins[i]
                    } else {
                        mins[i] = Math.min(last[i - 1], last[i]) + row.get(i);
                    }
                }
//                IntStream.of(mins).forEach(a -> System.out.print(a + ","));
//                System.out.println();
            }

            mins = triangle.size() % 2 == 1 ? mins1 : mins2;
            int min = Integer.MAX_VALUE;
            for (int t : mins) {
                if (t < min) {
                    min = t;
                }
            }
            return min;
        }
    }

    /**
     * 动态规划优化
     *
     * 对于每一行，使用一个数组 int [] mins 保存从顶点到该行的每一个元素的最小和
     * 即，对于每一行 int [] row，mins[i] 表示从顶点到 row[i] 的最小和
     *
     * lastLeftTotal 表示 row[i] 的左上方的元素的累计最短和
     * lastRightTotal 表示 row[i] 的右上方的元素的累计最短和
     *
     * 遍历 row[i]前，先保存上一行最小和 mins[i] 为 lastRightTotal，
     * 再更新 mins[i] = min(lastLeftTotal, lastRightTotal) + row[i]，
     * 最后，该元素(row[i]) 的 lastRightTotal 变为下一个元素(row[i+1])的 lastLeftTotal，
     * 所以需要  lastLeftTotal = lastRightTotal;
     *
     * 空间复杂度 O(n)，只使用一个额外的数组
     */
    public class Triangle1 extends Triangle {
        @Override
        public int minimumTotal(List<List<Integer>> triangle) {
            int[] mins = new int[triangle.size()];
            int lastLeftTotal = 0;
            int lastRightTotal = 0;
            for (List<Integer> row : triangle) {
                for (int i = 0; i < row.size(); i++) {
                    lastRightTotal = mins[i];//important
                    if (i == 0) {
                        mins[i] = lastRightTotal + row.get(i);// no mins[i-1]
                    } else if (i == row.size() - 1) {
                        mins[i] = lastLeftTotal + row.get(i); // no mins[i]
                    } else {
                        mins[i] = Math.min(lastLeftTotal, lastRightTotal) + row.get(i);
                    }
                    lastLeftTotal = lastRightTotal; //important
                }
//                IntStream.of(mins).forEach(a -> System.out.print(a + ","));
//                System.out.println();
            }

            int min = Integer.MAX_VALUE;
            for (int t : mins) {
                if (t < min) {
                    min = t;
                }
            }
            return min;
        }
    }

}
