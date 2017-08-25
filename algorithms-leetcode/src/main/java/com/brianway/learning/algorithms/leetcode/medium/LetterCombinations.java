package com.brianway.learning.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brian on 2017/8/25.
 * LeetCode 17. Letter Combinations of a Phone Number
 * Question:https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 * 关键题设：无
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        return null;
    }

    public class LetterCombinations0 extends LetterCombinations {
        private String[][] dictonary = {
                {}, {},
                {"a", "b", "c"},
                {"d", "e", "f"},
                {"g", "h", "i"},
                {"j", "k", "l"},
                {"m", "n", "o"},
                {"p", "q", "r", "s"},
                {"t", "u", "v"},
                {"w", "x", "y", "z"}
        };

        /**
         * 先建立一个字典表的二维数组，行标为对应数字，每一行为该数字对应的字母数组
         *
         * 1.将输入的字符串转换成数字数组 numbers
         * 2.用一个数组 indices 来储存每一个输入数字在字典表里所对应的某个字母的下标
         * 3.根据数字数组，按序取其对应的字母来拼接出某一个结果
         * 4.递增 indices 中每个元素的值，做到循环组合
         */
        @Override
        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();
            if (digits == null || digits.equals("")) {
                return result;
            }
            char[] chars = digits.toCharArray();
            int[] numbers = charToInt(chars);
            int[] indices = new int[chars.length];
            int total = 1;
            for (int i = 0; i < numbers.length; i++) {
                total = total * dictonary[numbers[i]].length;
            }

            int count = 0;
            StringBuilder tmp = new StringBuilder();
            while (count < total) {
                tmp.setLength(0);
                for (int i = 0; i < numbers.length; i++) {
                    tmp.append(dictonary[numbers[i]][indices[i]]);
                }
                result.add(tmp.toString());
                count++;

                //update indices of each number
                indices[numbers.length - 1]++;
                for (int i = numbers.length - 1; i > 0; i--) {
                    if (indices[i] >= dictonary[numbers[i]].length) {
                        indices[i] = 0;
                        indices[i - 1] = indices[i - 1] + 1;
                    } else {
                        break;
                    }
                }
            }
            return result;
        }

        private int[] charToInt(char[] chars) {
            int[] ints = new int[chars.length];
            int i = 0;
            for (char c : chars) {
                if (c >= '2' && c <= '9') {
                    ints[i++] = c - '0';
                } else {
                    return new int[1];
                }
            }
            return ints;
        }

    }

}
