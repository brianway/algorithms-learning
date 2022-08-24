package com.brianway.learning.algorithms.leetcode.hard;

/**
 * LeetCode 72. Edit Distance
 * Question: https://leetcode.com/problems/edit-distance/
 * 关键题设：无
 *
 * @auther brian
 * @since 2022/8/24 22:45
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        return 0;
    }

    /**
     * DP
     * <p>
     * 1. dp数组以及下标含义：dp[i+1][j+1]表示将word1[0...i]转变为 word2[0...j]的最小编辑距离
     * 2. 递推关系：
     * if(word1[i]==word2[j])  dp[i+1][j+1]=min{dp[i][j],dp[i+1][j]+1,dp[i][j+1]+1}
     * else dp[i+1][j+1]=min{dp[i][j]+1,dp[i+1][j]+1,dp[i][j+1]+1} = min{dp[i][j],dp[i+1][j],dp[i][j+1]}+1
     * 说明：
     * 当word1[i]==word2[j]时，
     * 1)可以是word1[0...i-1]->word2[0...j-1] 基础上不操作;
     * 2)可以是word1[0...i]->word2[0...j-1] 基础上插入word2[j]
     * 3)可以是先删除word1[i]，再word1[0...i-1]->word2[0...j]
     * 当word1[i]!=word2[j]时，
     * 1)可以是word1[0...i-1]->word2[0...j-1] 基础上替换 word1[i]->word2[j]
     * 2)可以是word1[0...i]->word2[0...j-1] 基础上插入word2[j]
     * 3)可以是先删除word1[i]，再word1[0...i-1]->word2[0...j]
     * <p>
     * 3. 初始化：
     * dp[0][0]=0，表示 "" -> ""
     * dp[i][0]=i, 0<=i<=word1.len, 表示删除word1中的i个字符串 成为 ""
     * dp[0][j]=j, 0<=j<=word2.len, 表示往""插入word2中的j个字符串成为 word2
     * 4. 遍历顺序：从左到右
     */
    public class EditDistance0 extends EditDistance {
        @Override
        public int minDistance(String word1, String word2) {
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];
            for (int i = 0; i < word1.length(); i++) {
                dp[i + 1][0] = i + 1;
            }
            for (int j = 0; j < word2.length(); j++) {
                dp[0][j + 1] = j + 1;
            }
            dp[0][0] = 0;
            for (int i = 0; i < word1.length(); i++) {
                for (int j = 0; j < word2.length(); j++) {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i + 1][j], dp[i][j + 1]) + 1);
                    } else {
                        dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i + 1][j], dp[i][j + 1])) + 1;
                    }
                }
            }
            return dp[word1.length()][word2.length()];
        }
    }

    /**
     * DP递推关系优化
     * <p>
     * 从EditDistance0的递推关系可以看出：
     * TODO 证明  dp[i][j] <= min{dp[i + 1][j], dp[i][j + 1]} + 1
     * 所以，
     * 当word1[i]==word2[j]时，不修改
     * 当word1[i]!=word2[j]时， 可以 增/删/换
     */
    public class EditDistance1 extends EditDistance {
        public int minDistance(String word1, String word2) {
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];
            for (int i = 1; i <= word1.length(); i++) {
                dp[i][0] = i;
            }
            for (int j = 1; j <= word2.length(); j++) {
                dp[0][j] = j;
            }
            dp[0][0] = 0;

            for (int i = 0; i < word1.length(); i++) {
                for (int j = 0; j < word2.length(); j++) {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        dp[i + 1][j + 1] = dp[i][j];
                    } else {
                        dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i + 1][j], dp[i][j + 1])) + 1;
                    }
                }
            }
            return dp[word1.length()][word2.length()];
        }
    }

}
