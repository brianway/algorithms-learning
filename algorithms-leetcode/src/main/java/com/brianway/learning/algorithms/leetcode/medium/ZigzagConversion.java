package com.brianway.learning.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 6. Zigzag Conversion
 * Question: https://leetcode.com/problems/zigzag-conversion/
 * 关键题设：无
 *
 * @auther brian
 * @since 2022/9/15 23:44
 */
public class ZigzagConversion {
    public String convert(String s, int numRows) {
        return null;
    }

    /**
     * 解法1：
     * 每行一个数组，由于按从左到右的顺序生成的，所以每一行的左右相对顺序和生成的相对顺序一致
     * <p>
     * 有几个控制变量：
     * isUp: 表示当前处于Z的哪个垂直方向，向上/向下
     * j：表示当前在第几行
     */
    public class ZigzagConversion0 extends ZigzagConversion {
        @Override
        public String convert(String s, int numRows) {
            List<List<Character>> rows = new ArrayList<>(numRows);
            // init
            for (int i = 0; i < numRows; i++) {
                rows.add(new ArrayList<>());
            }

            int j = 0;
            boolean isUp = false;

            for (int i = 0; i < s.length(); i++) {
                List<Character> row;
                if (isUp) {
                    row = rows.get(j--);
                } else {
                    row = rows.get(j++);
                }

                row.add(s.charAt(i));

                if (j == numRows) {
                    isUp = true;
                    j = Math.max(numRows - 2, 0);
                }

                if (j == 0) {
                    isUp = false;
                }

            }

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < numRows; i++) {
                List<Character> row = rows.get(i);
                for (Character character : row) {
                    sb.append(character);
                }

            }

            return sb.toString();
        }
    }
}
