package com.brianway.learning.algorithms.leetcode.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Brian on 2016/4/19.
 */
public class TwoSumTest {

    private TwoSum[] testObjects;

    private int[][] allNums = new int[][] {
            {2, 7, 11, 15},
            {1, 4, 4, 5},
            {2, 1, 3}
    };
    private int[] targets = {9, 8, 4};
    private int[][] results = {
            {0, 1},
            {1, 2},
            {1, 2}
    };

    @Before
    public void SetUp() {
        testObjects = new TwoSum[3];
        testObjects[0] = new TwoSum().new TwoSum0();
        testObjects[1] = new TwoSum().new TwoSum1();
        testObjects[2] = new TwoSum().new TwoSum2();

    }

    @Test
    public void testTwoSum() {
        int i = 2;
        int[] nums = allNums[i];
        int target = targets[i];
        int[] result = results[i];
        Assert.assertArrayEquals(result, testObjects[1].twoSum(nums, target));
    }

    @Test
    public void testAll() {
        for (int oi = 0; oi < testObjects.length; oi++) {
            for (int i = 0; i < targets.length; i++) {
                int[] nums = allNums[i];
                int target = targets[i];
                int[] result = results[i];
                Assert.assertArrayEquals(result, testObjects[oi].twoSum(nums, target));
            }
        }
    }

}
