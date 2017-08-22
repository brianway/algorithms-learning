package com.brianway.learning.algorithms.leetcode.easy;

import java.util.HashSet;

/**
 * Created by brian on 2016/5/15.
 * LeetCode 202. Happy Number
 * Question:https://leetcode.com/problems/happy-number/
 * 关键题设： or it loops endlessly in a cycle which does not include 1
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        return false;
    }

    /**
     * 哈希表
     * 结果总会出现环的，所以只需要每次都记录sum,每次算完sum查看是否已经存在
     * 若存在则跳出循环，返回
     * 若不存在则添加进HashSet，更新n
     * TODO 时间复杂度 空间复杂度
     */
    public class HappyNumber0 extends HappyNumber {
        @Override
        public boolean isHappy(int n) {
            HashSet<Integer> set = new HashSet<Integer>();
            int sum = 0;
            while (true) {
                sum = 0;
                while (n != 0) {
                    sum += (n % 10) * (n % 10);
                    n = n / 10;
                }
                if (set.contains(sum)) {
                    return sum == 1;
                } else {
                    set.add(sum);
                    n = sum;
                }
            }

        }
    }

}
