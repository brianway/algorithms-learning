package com.brianway.learning.algorithms.lectures.binarysearch;

/**
 * Created by brian on 16/11/15.
 *
 * 定义局部最小的概念。arr长度为1时，arr[0]是局部最小。
 * arr的长度为N(N>1)时，如果arr[0]<arr[1]，那么arr[0]是局部最小；
 * 如果arr[N-1]<arr[N-2]，那么arr[N-1]是局部最小；
 * 如果0<i<N-1，既有arr[i]<arr[i-1]又有arr[i]<arr[i+1]，那么arr[i]是局部最小。
 * 给定无序数组arr，已知arr中任意两个相邻的数都不相等，写一个函数，只需返回arr中任意一个局部最小出现的位置即可。
 */
public class LocalMin {
    public int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }

        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        int lo = 0;
        int hi = arr.length - 1;
        int mid = 0;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            //System.out.println("lo:" + lo + " hi:" + hi + " mid:" + mid);
            if (arr[mid] > arr[mid - 1]) {
                hi = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] a = {5, 4, 1, 3, 6, 7, 8, 9};
        LocalMin lm = new LocalMin();
        int index = lm.getLessIndex(a);
        System.out.println("a[" + index + "]=" + a[index]);
    }
}
