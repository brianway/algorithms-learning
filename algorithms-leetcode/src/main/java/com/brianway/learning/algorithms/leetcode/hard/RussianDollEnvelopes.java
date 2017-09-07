package com.brianway.learning.algorithms.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Brian on 2017/9/7.
 * LeetCode 354. Russian Doll Envelopes
 * Question: https://leetcode.com/problems/russian-doll-envelopes/description/
 * 关键题设：  both the width and height, greater than
 * 参考链接：http://www.cnblogs.com/grandyang/p/5568818.html
 */
public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        return 0;
    }

    /**
     * 借鉴了 LIS 的思路
     * 先将信封按 w 升序排序(w 相等时，h 升序排)
     * 然后统计以每个信封结尾的最长递增子序列的长度
     * (这里的比较的规则是：第 i 个元素的 w,h 均大于 第 j 个元素)
     *
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(n)
     */
    public class RussianDollEnvelopes0 extends RussianDollEnvelopes {
        class Envelope {
            int w;
            int h;

            public Envelope(int w, int h) {
                this.w = w;
                this.h = h;
            }
        }

        @Override
        public int maxEnvelopes(int[][] envelopes) {
            if (envelopes == null || envelopes.length == 0) {
                return 0;
            }
            List<Envelope> list = new ArrayList<>();
            for (int i = 0; i < envelopes.length; i++) {
                list.add(new Envelope(envelopes[i][0], envelopes[i][1]));
            }

            list.sort((e1, e2) -> {
                if (e1.w == e2.w) {
                    return e1.h - e2.h;
                } else {
                    return e1.w - e2.w;
                }
            });

            int[] dp = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (list.get(i).w > list.get(j).w && list.get(i).h > list.get(j).h && dp[j] >= dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            int maxLen = 0;
            for (int i = 0; i < dp.length; i++) {
                if (dp[i] > maxLen) {
                    maxLen = dp[i];
                }
            }
            return maxLen;
        }
    }

    /**
     * 和上一个方法一样，只不过使用了数组而不是 List，性能好了一点点
     *
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(n)
     */
    public class RussianDollEnvelopes1 extends RussianDollEnvelopes {
        class Envelope {
            int w;
            int h;

            public Envelope(int w, int h) {
                this.w = w;
                this.h = h;
            }
        }

        @Override
        public int maxEnvelopes(int[][] envelopes) {
            if (envelopes == null || envelopes.length == 0) {
                return 0;
            }
            Envelope[] list = new Envelope[envelopes.length];
            for (int i = 0; i < envelopes.length; i++) {
                list[i] = new Envelope(envelopes[i][0], envelopes[i][1]);
            }

            Arrays.sort(list, (e1, e2) -> {
                if (e1.w == e2.w) {
                    return e1.h - e2.h;
                } else {
                    return e1.w - e2.w;
                }
            });

            int[] dp = new int[list.length];
            for (int i = 0; i < list.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (list[i].w > list[j].w && list[i].h > list[j].h && dp[j] >= dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            int maxLen = 0;
            for (int i = 0; i < dp.length; i++) {
                if (dp[i] > maxLen) {
                    maxLen = dp[i];
                }
            }
            return maxLen;
        }
    }

    /**
     * 借鉴了 LIS 的二分查找版本的思路
     *
     * 1. 先将所有信封按 w 升序排(w 相等时，h 降序排)
     * 2. 再对信封的高 h 取最长递增子序列即可
     *
     * 说明：
     * 由于排序规则，对于每个遍历到的 h,
     * 1.若 h 大于 dp 中所有的 h，则 w 一定也是 dp 中最大的，
     * 所以 append 到 dp 的信封一定是满足要求的 w,h 均大于 dp 已有元素的信封。
     * 2.若遍历到的 h 不是最大的，则只会更新 dp 中的某一个 h，
     * 减小 dp 中第 k 个元素的 h 的上限，同时没减小 w，
     * 因为当前信封的 w 一定不小于 dp 中被更新的信封的 w。
     *
     *
     * 时间复杂度 O(n*log n)
     * 空间复杂度 O(n)
     */
    public class RussianDollEnvelopes2 extends RussianDollEnvelopes {
        class Envelope {
            int w;
            int h;

            public Envelope(int w, int h) {
                this.w = w;
                this.h = h;
            }
        }

        @Override
        public int maxEnvelopes(int[][] envelopes) {
            if (envelopes == null || envelopes.length == 0) {
                return 0;
            }
            Envelope[] list = new Envelope[envelopes.length];
            for (int i = 0; i < envelopes.length; i++) {
                list[i] = new Envelope(envelopes[i][0], envelopes[i][1]);
            }

            Arrays.sort(list, (e1, e2) -> {
                if (e1.w == e2.w) {
                    return e2.h - e1.h;//这里 w 相等时，h 降序排
                } else {
                    return e1.w - e2.w;
                }
            });

            Envelope[] dp = new Envelope[list.length];
            int len = 0;
            for (int i = 0; i < list.length; i++) {
                int k = Arrays.binarySearch(dp, 0, len, list[i],
                        Comparator.comparingInt(e -> e.h));
                if (k < 0) {
                    k = -k - 1;
                }
                dp[k] = list[i];
                if (k == len) {
                    len++;
                }
            }

            return len;
        }
    }
}
