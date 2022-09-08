package com.brianway.learning.algorithms.leetcode.easy;

/**
 * Created by brian on 16/5/30.
 * LeetCode 344. Reverse String
 * Question:https://leetcode.com/problems/reverse-string/
 * 关键题设：none
 */
public class ReverseString {
    public void reverseString(char[] s) {

    }

    /**
     * 首尾互换就行了
     * 将第i个字符和第length-1-i个字符交换
     * 0 ≤ i ≤ length/2－1
     * 这里边界不要搞错了,第一次就是想着少交换中间的一个,i 取的 0≤i≤(length-1)/2
     * 然后测试案例"a."没通过
     * <p>
     * 例子：
     * s a b c d e f
     * i 0 1 2 3 4 5
     * length = 6,中间的 i = 3，其实取到 i = 2 即可
     * a a b c d e
     * i 0 1 2 3 4
     * length = 5,中间的 i = 2，其实取到 i = 1 即可
     * <p>
     * 相关链接:http://javahungry.blogspot.com/2014/12/5-ways-to-reverse-string-in-java-with-example.html
     * <p>
     * 时间复杂度 O(n/2)
     * 空间复杂度 O(1)
     */
    public class ReverseString0 extends ReverseString {
        @Override
        public void reverseString(char[] s) {
            int length = s.length;
            char tmp;
            for (int i = 0; i < length / 2; i++) {
                tmp = s[i];
                s[i] = s[length - 1 - i];
                s[length - 1 - i] = tmp;
            }
        }
    }

    public class RevereString1 extends ReverseString {
        public void reverseString(char[] s) {
            int l = 0;
            int r = s.length - 1;
            while (l < r) {
                s[l] ^= s[r];  //构造 a ^ b 的结果，并放在 a 中
                s[r] ^= s[l];  //将 a ^ b 这一结果再 ^ b ，存入b中，此时 b = a, a = a ^ b
                s[l] ^= s[r];  //a ^ b 的结果再 ^ a ，存入 a 中，此时 b = a, a = b 完成交换
                l++;
                r--;
            }
        }
    }
}
