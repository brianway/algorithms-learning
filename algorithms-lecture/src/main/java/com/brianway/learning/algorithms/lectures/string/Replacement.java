package com.brianway.learning.algorithms.lectures.string;

/**
 * Created by brian on 16/11/8.
 *
 * 请编写一个方法，将字符串中的空格全部替换为“%20”。假定该字符串有足够的空间存放新增的字符，并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大小写的英文字母组成。
 * 给定一个string iniString 为原始的串，以及串的长度 int len, 返回替换后的string。
 *
 * 测试样例：
 * "Mr John Smith”,13
 * 返回："Mr%20John%20Smith"
 * ”Hello  World”,12
 * 返回：”Hello%20%20World”
 */
public class Replacement {
    public String replaceSpace(String iniString, int length) {
        if (iniString == null || length == 0) {
            return null;
        }
        char[] s = iniString.toCharArray();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (s[i] == ' ') {
                count++;
            }
        }

        int i = length + 2 * count - 1;
        char[] res = new char[i + 1];
        for (int j = length - 1; j >= 0; j--) {
            if (s[j] == ' ') {
                res[i--] = '0';
                res[i--] = '2';
                res[i--] = '%';
            } else {
                res[i--] = s[j];
            }
        }

        return new String(res);
    }
}
