package com.brianway.learning.algorithms.lectures.sort;

/**
 * Created by brian on 16/11/7.
 *
 * 现在有一个行和列都排好序的矩阵，请设计一个高效算法，快速查找矩阵中是否含有值x。
 * 给定一个int矩阵mat，同时给定矩阵大小nxm及待查找的数x，
 * 请返回一个bool值，代表矩阵中是否存在x。
 * 所有矩阵中数字及x均为int范围内整数。保证n和m均小于等于1000。
 */
public class Finder {
    public boolean findX(int[][] mat, int n, int m, int x) {
        int i = 0;
        int j = m - 1;
        while (i < n && j >= 0) {
            if (mat[i][j] == x) {
                return true;
            } else if (mat[i][j] > x) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [][]a ={{1,2,3},{4,5,6},{7,8,9}};
        Finder f = new Finder();
        boolean b = f.findX(a,3,3,10);
        System.out.println(b);
        b = f.findX(a,3,3,5);
        System.out.println(b);
    }
}
