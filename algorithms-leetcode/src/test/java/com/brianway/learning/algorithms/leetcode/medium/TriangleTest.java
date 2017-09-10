package com.brianway.learning.algorithms.leetcode.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TriangleTest {

    private Triangle testObject;

    @Before
    public void setUp() {
        testObject = new Triangle().new Triangle1();
    }

    @Test
    public void testMinimumTotal() {
        //[[2],[3,4], [6,5,7],[4,1,8,3]]
        int[][] a = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        int result = 11;
        List<List<Integer>> triangle = transform(a);
        //System.out.println(triangle);
        Assert.assertEquals(result, testObject.minimumTotal(triangle));
    }

    private List<List<Integer>> transform(int[][] a) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (a == null) {
            return triangle;
        }
        List<Integer> row;
        for (int i = 0; i < a.length; i++) {
            row = IntStream.of(a[i]).boxed().collect(Collectors.toList());
            triangle.add(row);
        }
        return triangle;
    }
}
