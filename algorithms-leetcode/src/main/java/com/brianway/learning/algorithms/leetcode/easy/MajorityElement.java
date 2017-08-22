package com.brianway.learning.algorithms.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Brian on 2016/4/26.
 * LeetCode 169. Majority Element
 * Question:https://leetcode.com/problems/majority-element/
 * 关键题设：assume that the array is non-empty and the majority element always exist in the array
 */
//TODO 疑问：在leetcode提交后，运行时间为什么用哈希表的方法比快排要慢？
public class MajorityElement {
    public int majorityElement(int[] nums) {
        return 0;
    }

    /**
     * 哈希表，nums的元素值作为key，出现的次数作为value
     * 遍历两次，第一次初始化哈希表，第二次找出哈希表中的value最大的key
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public class MajorityElement0 extends MajorityElement {
        @Override
        public int majorityElement(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            int max = 0;
            int key = 0;
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    map.put(nums[i], map.get(nums[i]) + 1);
                } else {
                    map.put(nums[i], 1);
                }
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    key = entry.getKey();
                }
            }
            return key;
        }
    }

    /**
     * 快排，使用Java的Arrays工具类自带的sort方法
     * 时间复杂度 O(nlog(n))
     * 空间复杂度 O(1)
     */
    public class MajorityElement1 extends MajorityElement {
        @Override
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
    }

    /**
     * 计数，相同就加1，不同就减1，只有到0时才会更新当前被计数的key
     * 因为 MajorityElement appears more than ⌊ n/2 ⌋ times.
     * 所以最后的 result 一定是 MajorityElement
     * 最坏的情况无非是[1,1,1,1,2,2,3]这样，也抵消不了1的四次，如果[1,2,3,4,1,1,1],前面的数都"内耗了"，count不停在0~1跳动
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public class MajorityElement2 extends MajorityElement {
        @Override
        public int majorityElement(int[] nums) {
            int result = 0, count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (count == 0) {
                    result = nums[i];
                    count++;
                } else if (result == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }
            return result;
        }
    }
}
