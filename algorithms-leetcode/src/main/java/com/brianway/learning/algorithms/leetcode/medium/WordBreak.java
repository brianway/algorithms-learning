package com.brianway.learning.algorithms.leetcode.medium;

import java.util.List;

/**
 * LeetCode 139. Word Break
 * Question: https://leetcode.com/problems/word-break/
 * 关键题设: 无
 *
 * @auther brian
 * @since 2022/7/11 21:19
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        return false;
    }

    /**
     * DP，完全背包
     * <p>
     * 1. dp数组下标及含义：dp[j] 表示用字典里的词能否匹配到s中从开头开始长度为j的字符
     * 2. 递推关系：
     * 如果 s[0...j-1] 以wordDict中的某个单词word结尾，则dp[j] = dp[j-word.length] || dp[j]
     * （这里用 或，而不是直接dp[j] = dp[j-word.length]，是因为任一匹配即可，不能因为某次以单词word结尾，但dp[j-word.length]=false 而导致dp[j]被覆盖为false，
     * 应该只要匹配过一次true就算true）
     * 否则 dp[j] = false
     * <p>
     * 3. 初始化： dp[0] = true，表示s长度为0时默认匹配。很关键
     * 4. 遍历顺序：外层j，从左到右，内层 wordDict。
     */
    public static class WordBreak0 extends WordBreak {
        @Override
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int j = 1; j <= s.length(); j++) {
                String stageS = s.substring(0, j);
                for (String word : wordDict) {
                    if (stageS.endsWith(word)) {
                        // 之前匹配过即可
                        dp[j] = dp[j] || dp[j - word.length()];
                    }
                }
            }
            return dp[s.length()];
        }
    }
}
