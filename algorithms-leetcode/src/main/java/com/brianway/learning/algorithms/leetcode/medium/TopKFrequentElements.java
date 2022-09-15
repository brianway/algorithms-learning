package com.brianway.learning.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by brian on 16/6/5.
 * LeetCode 347. Top K Frequent Elements
 * Question:https://leetcode.com/problems/top-k-frequent-elements/
 * 关键题设：non-empty array, time complexity must be better than O(n log n)
 * <p>
 * 参考链接：
 * http://stackoverflow.com/questions/185697/the-most-efficient-way-to-find-top-k-frequent-words-in-a-big-word-sequence
 */

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        return null;
    }

    /**
     * 哈希表+优先队列
     * 遍历一遍,统计数字出现的次数
     * 利用 PriorityQueue 找出频数最大的前k个值
     * <p>
     * 优先级队列：一个披着队列外衣的堆。
     * 堆是一棵完全二叉树，树中每个结点的值都不小于（或不大于）其左右孩子的值
     * <p>
     * 时间复杂度 O(n*log(k))
     * 空间复杂度 O(n)
     */
    public class TopKFrequentElements0 extends TopKFrequentElements {

        class Pair {
            int num;
            int count;

            Pair(int num, int count) {
                this.num = num;
                this.count = count;
            }
        }

        @Override
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> numToFreqMap = new HashMap<Integer, Integer>();

            //统计频数
            for (int i = 0; i < nums.length; i++) {
                numToFreqMap.put(nums[i], numToFreqMap.getOrDefault(nums[i], 0) + 1);
            }

            //使用优先队列找出前k个key，默认是一个小顶堆
            Comparator<Pair> comparator = Comparator.comparingInt(o -> o.count);

            PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(k, comparator);

            for (Map.Entry<Integer, Integer> entry : numToFreqMap.entrySet()) {
                Pair pair = new Pair(entry.getKey(), entry.getValue());
                Pair peek = priorityQueue.peek();
                if (priorityQueue.size() < k) {
                    priorityQueue.offer(pair);
                } else if (comparator.compare(pair, peek) > 0) {
                    priorityQueue.poll();
                    priorityQueue.offer(pair);
                }
            }

            // 返回value最大的前k个key
            int[] result = new int[k];
            int i = 0;
            while (priorityQueue.size() > 0) {
                result[i++] = priorityQueue.poll().num;
            }

            return result;
        }
    }

    /**
     * 哈希表+桶排序
     * 遍历一遍,统计数字出现的次数
     * 使用桶排序:
     * 桶的 size 为最大频数
     * 桶的 bindex 为 hashmap 的 value,即频数 count;
     * 桶中的元素为具有相同频数的 num;
     * <p>
     * 时间复杂度 O(n)
     * 空间复杂度?
     */
    public class TopKFrequentElements1 extends TopKFrequentElements {
        @Override
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

            //统计频数
            for (final int value : nums) {
                hashMap.put(value, hashMap.getOrDefault(value, 0) + 1);
            }

            //get the max frequency
            int max = 0;
            for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
                max = Math.max(max, entry.getValue());
            }

            // initialize an array of ArrayList. index is frequency, value is list of numbers
            @SuppressWarnings("unchecked")
            ArrayList<Integer>[] bucket = (ArrayList<Integer>[]) new ArrayList[max + 1];

            for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
                int count = entry.getValue();
                int num = entry.getKey();
                if (bucket[count] == null) {
                    bucket[count] = new ArrayList<>();
                }
                bucket[count].add(num);
            }

            int[] result = new int[k];
            int j = 0;
            for (int i = max; i > 0 && j < k; i--) {
                if (bucket[i] != null) {
                    for (int m = 0; m < bucket[i].size(); m++) {
                        result[j++] = bucket[i].get(m);
                    }

                }
            }
            return result;
        }

    }

}
