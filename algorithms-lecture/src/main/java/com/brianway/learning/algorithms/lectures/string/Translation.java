package com.brianway.learning.algorithms.lectures.string;

/**
 * Created by brian on 16/11/8.
 *
 * 对于一个字符串，请设计一个算法，将字符串的长度为len的前缀平移到字符串的最后。
 * 给定一个字符串A和它的长度，同时给定len，请返回平移后的字符串。
 *
 * 测试样例：
 * "ABCDE",5,3
 * 返回："DEABC"
 *
 */
public class Translation {
    public String stringTranslation(String A, int n, int len) {
        if (A == null || n == 0) {
            return null;
        }
        char[] s = A.toCharArray();
        reverse(s, 0, len - 1);
        reverse(s, len, n - 1);
        reverse(s, 0, n - 1);

        return new String(s);
    }

    private void reverse(char[] chars, int begin, int end) {
        char c;
        while (begin < end) {
            c = chars[begin];
            chars[begin] = chars[end];
            chars[end] = c;
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        String s = "ABCDE";
        String t = new Translation().stringTranslation(s,5,3);
        System.out.println(t);
    }
}
