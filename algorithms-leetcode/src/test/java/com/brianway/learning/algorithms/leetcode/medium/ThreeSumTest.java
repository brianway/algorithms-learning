package com.brianway.learning.algorithms.leetcode.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Brian on 2016/4/30.
 */
public class ThreeSumTest {

    private ThreeSum testObject;

    private int[] nums;
    private ArrayList<ArrayList<Integer>> result;//= new ArrayList<ArrayList<Integer>>();

    @Before
    public void SetUp() {
        nums = new int[] {1, -1, -1, 2, 0, 1};
        int[][] array = {
                {-1, -1, 2},
                {-1, 0, 1}
        };
        result = getArrayList(array);
        testObject = new ThreeSum().new ThreeSum0();
    }

    private ArrayList<ArrayList<Integer>> getArrayList(int[][] array) {
        ArrayList<ArrayList<Integer>> all = new ArrayList<>();
        int size = 3;
        for (final int[] anArray : array) {
            ArrayList<Integer> match = new ArrayList<>(size);
            for (int j = 0; j < size; j++) {
                match.add(anArray[j]);
            }
            all.add(match);
        }
        return all;
    }

    @Test
    public void testThreeSum() {
        Assert.assertEquals(result, testObject.threeSum(nums));
    }

}
