package com.brianway.learning.algorithms.leetcode.medium;

import java.util.*;

/**
 * Created by brian on 16/6/5.
 * LeetCode 347
 * Question:https://leetcode.com/problems/top-k-frequent-elements/
 * 关键题设：non-empty array, time complexity must be better than O(n log n)
 */

/**
 * TODO 这里同频数的元素我是按照出现顺序列出,OJ测试结果则是频数相同按大小,但测试通过了,没报错
 * 例如:[1,1,1,2,2,3,0,0,0] 2
 * 我返回[1,0],Expected answer是[0,1],但提交代码没问题
 *
 * 哈希表+优先队列:时间空间复杂度的分析?
 * 哈希表+桶排序:为什么这个方法在OJ的运行时间比第一种还慢?理论上桶排序应该更快的啊。另外时间空间复杂度分析?
 * 参考链接:
 * http://stackoverflow.com/questions/185697/the-most-efficient-way-to-find-top-k-frequent-words-in-a-big-word-sequence
 */

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        return null;
    }

    /**
     * 哈希表+优先队列
     * 遍历一遍,统计数字出现的次数
     * 利用priorityqueue找出频数最大的前k个值
     *
     * 时间复杂度 O(n*log(k)),分析?
     * 空间复杂度 O(n)? 感觉应该是nums中unique elements的个数m,O(m)
     *
     */
    public class TopKFrequentElements0 extends TopKFrequentElements{

        class Pair{
            int num;
            int count;

            public Pair(int num,int count) {
                this.count = count;
                this.num = num;
            }
        }

        @Override
        public List<Integer> topKFrequent(int[] nums, int k) {
            HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();

            //统计频数
            for(int i=0;i<nums.length;i++){
                if(hashMap.containsKey(nums[i])){
                    hashMap.put(nums[i],hashMap.get(nums[i])+1);
                }else{
                    hashMap.put(nums[i],1);
                }
            }
            //使用优先队列找出前k个key
            Comparator<Pair>comparator = new Comparator<Pair>() {
                public int compare(Pair o1, Pair o2) {
                    return o1.count-o2.count;
                }
            };

            PriorityQueue<Pair> priorityQueue = new PriorityQueue<Pair>(k,comparator);

            for(Map.Entry<Integer,Integer> entry: hashMap.entrySet()){
                Pair pair = new Pair(entry.getKey(),entry.getValue());
                Pair peek = priorityQueue.peek();
                if(priorityQueue.size()<k){
                    priorityQueue.offer(pair);
                }else if(comparator.compare(pair,peek)>0){
                    priorityQueue.poll();
                    priorityQueue.offer(pair);
                }
            }

            //返回value最大的前k个key
            List<Integer> list  = new ArrayList<Integer>(k);
            while(priorityQueue.size()>0){
                list.add(priorityQueue.poll().num);
            }

            //因为是最小有优先队列,poll()是升序的,需要反转
            Collections.reverse(list);
            return list;
        }
    }

    /**
     * 哈希表+桶排序
     * 遍历一遍,统计数字出现的次数
     * 使用桶排序:
     *    桶的size为最大频数
     *    桶的bindex为hashmap的value,即频数count;
     *    桶中的元素为具有相同频数的num;
     *
     * 时间复杂度 O(n)
     * 空间复杂度 O(n+m)?
     */
    public class TopKFrequentElements1 extends TopKFrequentElements{
        @Override
        public List<Integer> topKFrequent(int[] nums, int k) {
            HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();

            //统计频数
            for(int i=0;i<nums.length;i++){
                if(hashMap.containsKey(nums[i])){
                    hashMap.put(nums[i],hashMap.get(nums[i])+1);
                }else{
                    hashMap.put(nums[i],1);
                }
            }

            //get the max frequency
            int max = 0;
            for(Map.Entry<Integer, Integer> entry: hashMap.entrySet()){
                max = Math.max(max, entry.getValue());
            }

            //initialize an array of ArrayList. index is frequency, value is list of numbers
            ArrayList<Integer>[] bucket = (ArrayList<Integer>[]) new ArrayList[max+1];
            for(int i=0;i<=max;i++){
                bucket[i] = new ArrayList<Integer>();
            }

            for(Map.Entry<Integer, Integer> entry: hashMap.entrySet()){
                int count  = entry.getValue();
                int num = entry.getKey();
                bucket[count].add(num);
            }

            List<Integer>result = new ArrayList<Integer>(k);
            for(int i = max;i>0&&result.size()<k;i--){
                if(bucket[i].size()>0){
                    for(int num : bucket[i]){
                        result.add(num);
                    }
                }
            }
            return result;
        }
    }


}
