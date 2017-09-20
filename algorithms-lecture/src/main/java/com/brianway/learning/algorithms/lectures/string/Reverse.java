package com.brianway.learning.algorithms.lectures.string;

/**
 * Created by brian on 16/11/8.
 *
 * 对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，
 * 也就是说，字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。
 * 给定一个原字符串A和他的长度，请返回逆序后的字符串。
 *
 * 测试样例：
 * "dog loves pig",13
 * 返回："pig loves dog"
 */
public class Reverse {

    public String reverseSentence(String A, int n) {
        if (A == null || n == 0) {
            return null;
        }

        char[] s = A.toCharArray();
        reverse(s, 0, n - 1);
        int i = 0;
        int begin = 0;
        int end = 0;
        while (i < s.length) {
            if (s[i] == ' ') {
                end = i - 1;
                reverse(s, begin, end);
                begin = i + 1;
            }
            i++;
        }

        if (s[n - 1] != ' ') {
            reverse(s, begin, n - 1);
        }

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
        String s = "dog loves pig";
        System.out.println(s.length());
        String r = new Reverse().reverseSentence(s, s.length());
        System.out.println(r);
    }
}
