package com.brianway.learning.algorithms.lectures.dp;

/**
 * Created by brian on 16/11/20.
 *
 * 有一个矩阵map，它每个格子有一个权值。从左上角的格子开始每次只能向右或者向下走，
 * 最后到达右下角的位置，路径上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。
 * 给定一个矩阵map及它的行数n和列数m，请返回最小路径和。保证行列数均小于等于100.
 *
 * 测试样例：
 * [[1,2,3],[1,1,1]],2,3
 * 返回：4
 */
public class MinimumPath {
    public int getMin(int[][] map, int n, int m) {
        int[][] sum = new int[n][m];
        sum[0][0] = map[0][0];
        for (int i = 1; i < n; i++) {
            sum[i][0] = sum[i - 1][0] + map[i][0];
        }
        for (int j = 1; j < m; j++) {
            sum[0][j] = sum[0][j - 1] + map[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                sum[i][j] = Math.min(sum[i][j - 1], sum[i - 1][j]) + map[i][j];
            }
        }
        return sum[n - 1][m - 1];
    }
}
