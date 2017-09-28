package com.brianway.learning.algorithms.lectures.binarysearch;

/**
 * Created by brian on 16/11/15.
 *
 * 有一个有序数组arr，其中不含有重复元素，请找到满足arr[i]==i条件的最左的位置。
 * 如果所有位置上的数都不满足条件，返回-1。
 * 给定有序数组arr及它的大小n，请返回所求值。
 *
 * 测试样例：
 * [-1,0,2,3],4
 * 返回：2
 */
public class Find {
    public int findPos(int[] arr, int n) {
        if (arr == null || n == 0) {
            return -1;
        }

        if (arr[0] > n - 1 || arr[n - 1] < 0) {
            return -1;
        }

        int res = -1;
        int lo = 0;
        int hi = n - 1;
        int mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (arr[mid] > mid) {
                hi = mid - 1;
            } else if (arr[mid] < mid) {
                lo = mid + 1;
            } else {
                res = mid;
                hi = mid - 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 1, 2, 3, 4, 5};
        Find find = new Find();
        System.out.println(find.findPos(arr, arr.length));
    }
}
