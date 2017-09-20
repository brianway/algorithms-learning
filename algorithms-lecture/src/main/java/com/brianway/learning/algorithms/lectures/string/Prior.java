package com.brianway.learning.algorithms.lectures.string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by brian on 16/11/8.
 *
 * 对于一个给定的字符串数组，请找到一种拼接顺序，
 * 使所有小字符串拼接成的大字符串是所有可能的拼接中字典序最小的。
 * 给定一个字符串数组strs，同时给定它的大小，请返回拼接成的串。
 *
 * 测试样例：
 * ["abc","de"],2
 * "abcde"
 */
public class Prior {
    public String findSmallest(String[] strs, int n) {
        if(strs == null|| n==0){
            return null;
        }

        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strs.length;i++){
            sb.append(strs[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String [] strs = {"abc","de"};
        System.out.println(new Prior().findSmallest(strs,2));
    }
}
