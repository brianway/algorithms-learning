package com.brianway.learning.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by brian on 16/6/6.
 * LeetCode 349. Intersection of Two Arrays
 * Question:https://leetcode.com/problems/intersection-of-two-arrays/
 * 关键题设：Each element in the result must be unique.The result can be in any order
 */
public class IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        return null;
    }

    /**
     * 哈希表
     * 遍历两个数组各一遍,没有键值则添加,有键值则+1
     * 同一个数组只加一次
     * 遍历哈希表,列出所有计数为2的键值即可
     *
     * 时间复杂度 O(n1+n2)
     * 空间复杂度 O(n1)
     */
    public class IntersectionofTwoArrays0 extends IntersectionofTwoArrays {
        @Override
        public int[] intersection(int[] nums1, int[] nums2) {
            HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
            for (int num : nums1) {
                if (!hashMap.containsKey(num)) {
                    hashMap.put(num, 1);
                }
            }
            //这里做了点简化,若hashMap中不含该键值,则不用添加,因为num1中没有,肯定不是交集
            for (int num : nums2) {
                if (hashMap.containsKey(num)) {
                    hashMap.put(num, 2);
                }
            }

            List<Integer> list = new ArrayList<>();

            for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
                if (entry.getValue() == 2) {
                    list.add(entry.getKey());
                }
            }

            int[] result = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }
            return result;
        }
    }

    /**
     * 哈希表
     * 使用两个哈希表,减少遍历次数
     * hashMap1 存放数组1中的元素；hashMap2 存放两个数组的交集
     * 确实快了一些
     *
     * 时间复杂度 O(n1+n2)
     * 空间复杂度 O(n1+n1交n2)
     */
    public class IntersectionofTwoArrays1 extends IntersectionofTwoArrays {
        @Override
        public int[] intersection(int[] nums1, int[] nums2) {
            HashMap<Integer, Integer> hashMap1 = new HashMap<>();
            HashMap<Integer, Integer> hashMap2 = new HashMap<>();
            for (int num : nums1) {
                if (!hashMap1.containsKey(num)) {
                    hashMap1.put(num, 1);
                }
            }

            for (int num : nums2) {
                if (hashMap1.containsKey(num)) {
                    hashMap2.put(num, 2);
                }
            }

            List<Integer> list = new ArrayList<>();

            for (Map.Entry<Integer, Integer> entry : hashMap2.entrySet()) {
                list.add(entry.getKey());
            }

            int[] result = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }
            return result;
        }
    }

}
