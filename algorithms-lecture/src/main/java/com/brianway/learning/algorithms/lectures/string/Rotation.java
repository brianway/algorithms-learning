package com.brianway.learning.algorithms.lectures.string;

/**
 * Created by brian on 16/11/2.
 *
 * 如果对于一个字符串A，将A的前面任意一部分挪到后边去形成的字符串称为A的旋转词。
 * 比如A="12345",A的旋转词有"12345","23451","34512","45123"和"51234"。
 * 对于两个字符串A和B，请判断A和B是否互为旋转词。
 * 给定两个字符串A和B及他们的长度lena，lenb，请返回一个bool值，代表他们是否互为旋转词。
 */

public class Rotation {
    public boolean chkRotation(String A, int lena, String B, int lenb) {
        if (lena != lenb) {
            return false;
        }
        String doubleA = A + A;
        return doubleA.contains(B);
    }

    public static void main(String[] args) {
        boolean b = new Rotation().chkRotation("cdab", 4, "abcd", 4);
        System.out.println(b);
    }
}
