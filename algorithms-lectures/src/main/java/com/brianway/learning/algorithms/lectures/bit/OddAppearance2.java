package com.brianway.learning.algorithms.lectures.bit;

/**
 * Created by brian on 16/11/18.
 *
 * 给定一个整型数组arr，其中有两个数出现了奇数次，其他的数都出现了偶数次，找到这两个数。
 * 要求时间复杂度为O(N)，额外空间复杂度为O(1)。
 * 给定一个整形数组arr及它的大小n，请返回一个数组，其中两个元素为两个出现了奇数次的元素,请将他们按从小到大排列。
 *
 * 测试样例：
 * [1,2,4,4,2,1,3,5],8
 * 返回：[3,5]
 */
public class OddAppearance2 {
    public int[] findOdds(int[] arr, int n) {
        if (arr == null || n % 2 != 0) {
            throw new RuntimeException("error param");
        }

        int base = 0;
        for (int i = 0; i < n; i++) {
            base = base ^ arr[i];
        }
        int p = 0;
        while (((base >> p) & 1) != 1) {
            p++;
        }
        int one = 0;
        for (int i = 0; i < n; i++) {
            //if (((arr[i] >> p) & 1) != 0) {
            if (((1 << p) & arr[i]) != 0) {
                one = one ^ arr[i];
            }
        }

        int two = one ^ base;

        return one < two ? new int[] {one, two} : new int[] {two, one};

    }
}
