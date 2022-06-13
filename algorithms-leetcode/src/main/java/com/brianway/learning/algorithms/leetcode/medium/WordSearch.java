package com.brianway.learning.algorithms.leetcode.medium;

/**
 * LeetCode 79. Word Search
 * Question: https://leetcode.com/problems/word-search/
 * 关键题设：无
 *
 * @auther brian
 * @since 2022/6/13 21:52
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        return false;
    }

    /**
     * 思路：回溯， 先画递归树
     * 每个方格都可以作为第一字母，所以有n*m个起始方格，以任意一个为例：
     * 每个方格有上下左右四个方向可以探索，可以按顺时针顺序依次探索每个方向。
     * 如果某个方格被探索过，则设为true。如果第k个方格和 word[k]匹配，则继续，否则终止该分支的探索。
     * 如果某个方格的四个方向都没有匹配的结果，则将该方格回退，即将该方格是否被探索过设为false
     * <p>
     * 以board = [
     * ["A","B","C","E"],
     * ["S","F","C","S"],
     * ["A","D","E","E"]
     * ] 为例子，
     * A
     * /       \
     * B        S
     * / \     / \
     * C  F   F  A
     */
    public static class WordSearch0 extends WordSearch {
        @Override
        public boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (exist(board, i, j, word, 0, new boolean[board.length][board[i].length])) {
                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * @param board   方格
         * @param i       方格里开始匹配的位置第几行，0开始
         * @param j       方格里开始匹配的位置第几列，0开始
         * @param word    要匹配的单次
         * @param k       从第几个字符开始匹配
         * @param visited 每个方格是否被访问过
         * @return 是否匹配
         */
        private boolean exist(char[][] board, int i, int j, String word, int k, boolean[][] visited) {
            // 当前方格不匹配，将该方格是否被探索过设为false，并直接返回
            if (board[i][j] != word.charAt(k)) {
                visited[i][j] = false;
                return false;
            }

            // 当前方格匹配
            visited[i][j] = true;

            // 且是最后一个字符，直接返回true
            if (k == word.length() - 1) {
                return true;
            }

            // 按顺时针顺序依次探索每个方向
            boolean exist = (i > 0 && !visited[i - 1][j] && exist(board, i - 1, j, word, k + 1, visited)) // 上
                    || (j < board[i].length - 1 && !visited[i][j + 1] && exist(board, i, j + 1, word, k + 1, visited)) // 右
                    || (i < board.length - 1 && !visited[i + 1][j] && exist(board, i + 1, j, word, k + 1, visited)) // 下
                    || (j > 0 && !visited[i][j - 1] && exist(board, i, j - 1, word, k + 1, visited)) // 左
                    ;

            // 四个方向都没匹配的，则将该方格回退
            if (!exist) {
                visited[i][j] = false;
            }

            return exist;
        }
    }

}
