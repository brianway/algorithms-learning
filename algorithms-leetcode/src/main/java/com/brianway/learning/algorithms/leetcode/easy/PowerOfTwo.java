package com.brianway.learning.algorithms.leetcode.easy;

/**
 * Created by brian on 16/5/23.
 * LeetCode 231. Power of Two
 * Question:https://leetcode.com/problems/power-of-two/
 * 关键题设：power of two
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return false;
    }

    /**
     * 2的幂实际上就是通过1向右移位得到的,每乘以2就是向右移动一位
     * 所以其二进制高位只有一个1,其余位为0
     * 此方法好像并不受小于0的数影响
     */
    public class PowerOfTwo0 extends PowerOfTwo {
        @Override
        public boolean isPowerOfTwo(int n) {
            // if(n<0) return false;//多余,while能直接办到
            boolean hasOne = false;
            while (n > 0) {
                if ((n & 1) == 1) {
                    if (hasOne) {//已经有1了,再次遇到1,非2的幂
                        return false;
                    } else {//第一次1
                        hasOne = true;
                    }
                }
                n >>= 1;//右移一位
            }
            return hasOne;
        }
    }

    /**
     * n 与 n-1 按位与
     * 好像并不受小于0的数影响,小于稳定返回false
     * 注意零值
     */
    public class PowerOfTwo1 extends PowerOfTwo {
        @Override
        public boolean isPowerOfTwo(int n) {
            return n > 0 && (n & (n - 1)) == 0;
        }
    }
}
