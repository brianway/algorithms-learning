package com.brianway.learning.algorithms.leetcode;

import java.util.HashMap;

/**
 * Created by Brian on 2016/4/19.
 * LeetCode
 * Question:https://leetcode.com/problems/two-sum/
 * 关键题设：You may assume that each input would have exactly one solution.找出一解即可
 */

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        return null;
    }


}

class TwoSum0 extends TwoSum{
    /**
     * 暴力求解
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     * @param nums
     * @param target
     * @return
     */
    @Override
    public int[] twoSum(int[] nums, int target) {
        for(int i =0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}


class TwoSum1 extends TwoSum{
    /**
     * 哈希表，把值映射到下标索引，求(target-当前值)得到key即可
     * 方法1：一次循环初始化，一次循环进行搜索匹配，2次遍历
     * √方法2：一遍搜索一遍初始化哈希表，一次遍历
     * (target-当前值)是在已经初始化的集合中找的，所以映射的下标一定小于当前下标i,故放前面
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     * @param nums
     * @param target
     * @return
     */
    @Override
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            int complement = target-nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}