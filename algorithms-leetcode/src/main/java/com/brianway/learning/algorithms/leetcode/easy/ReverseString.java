package com.brianway.learning.algorithms.leetcode.easy;

/**
 * Created by brian on 16/5/30.
 * LeetCode 344. Reverse String
 * Question:https://leetcode.com/problems/reverse-string/
 * 关键题设：none
 */
public class ReverseString {
    public String reverseString(String s) {
        return null;
    }

    /**
     * 首尾互换就行了
     * 将第i个字符和第length-1-i个字符交换
     * 0 ≤ i < length/2－1
     * 这里边界不要搞错了,第一次就是想着少交换中间的一个,i 取的 0≤i≤(length-1)/2
     * 然后测试案例"a."没通过
     *
     * 例子：
     * a 1 2 3 4 5 6
     * i 0 1 2 3 4 5
     * length = 6,中间的 i = 3，其实取到 i = 2 即可
     * a 1 2 3 4 5
     * i 0 1 2 3 4
     * length = 5,中间的 i = 2，其实取到 i = 1 即可
     *
     * 相关链接:http://javahungry.blogspot.com/2014/12/5-ways-to-reverse-string-in-java-with-example.html
     *
     * 时间复杂度 O(n/2)
     * 空间复杂度 O(1)
     */
    public class ReverseString0 extends ReverseString {
        @Override
        public String reverseString(String s) {
            char[] array = s.toCharArray();
            int length = array.length;
            char tmp;
            for (int i = 0; i < length / 2; i++) {
                tmp = array[i];
                array[i] = array[length - 1 - i];
                array[length - 1 - i] = tmp;
            }
            return new String(array);
        }
    }
}
