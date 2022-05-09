package com.brianway.learning.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 268. Missing Number
 * Question: https://leetcode.com/problems/missing-number/
 * 关键题设：  distinct numbers in the range [0, n]，  only number
 *
 * @auther brian
 * @since 2022/5/9 21:55
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        return 0;
    }

    /**
     * 解法1: 哈希表
     * 把每个输入存起来，再遍历哈希表, key=[0,n]，看哪个输入没出现过
     */
    public static class MissingNumber0 extends MissingNumber {
        @Override
        public int missingNumber(int[] nums) {
            Map<Integer, Boolean> map = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], true);
            }

            for (int i = 0; i <= nums.length; i++) {
                if (map.get(i) == null) {
                    return i;
                }
            }
            throw new IllegalArgumentException("should never reach");
        }
    }

    /**
     * 解法2：数学方法
     * 计算 0+1+2+...n 的和，减去 nums的所有元素和，差值即missing number
     * <p>
     * PS：这里没有考虑整数取值范围越界的问题
     */
    public static class MissingNumber1 extends MissingNumber {
        @Override
        public int missingNumber(int[] nums) {
            int sum = 0;
            int sumOfNums = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += i;
                sumOfNums += nums[i];
            }
            return sum + nums.length - sumOfNums;
        }
    }

    /**
     * 解法3：位运算
     * 通过异或操作
     * (0^1^2...^n)^(num[0]^num[1]...num[n-1])
     * 利用交换律将两个括号内的相同的数两两结合，x ^ x = 0
     * 得到 0^0...^0^missingNumber = missingNumber
     * <p>
     * PS： 异或的一些定律：
     * 1. 归零律：x ^ x = 0
     * 2. 恒等律：x ^ 0 = x
     * 3. 交换律：x ^ y = y ^ x
     * 4. 结合律：x ^ (y ^ z) = (x ^ y) ^ z;
     * 5. 自反：a ^ b ^ a = b
     * 6. d = a ^ b ^ c 可以推出 a = d ^ b ^ c.
     */
    public static class MissingNumber2 extends MissingNumber {
        @Override
        public int missingNumber(int[] nums) {
            int xor = 0;
            for (int i = 0; i < nums.length; i++) {
                xor = xor ^ i ^ nums[i];
            }
            return xor ^ nums.length;
        }
    }
}
