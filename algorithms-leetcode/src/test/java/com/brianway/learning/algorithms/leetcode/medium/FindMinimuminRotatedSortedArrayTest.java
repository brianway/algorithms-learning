package com.brianway.learning.algorithms.leetcode.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FindMinimuminRotatedSortedArrayTest {

    private FindMinimuminRotatedSortedArray[] testObjects;

    private int[][] allNums = {
            {0, 1, 2, 4, 5, 6, 7},
            {6, 7, 0, 1, 2, 4, 5},
            {2, 4, 5, 6, 7, 0, 1}
    };
    private int[] results = {0, 0, 0};

    @Before
    public void SetUp() {
        testObjects = new FindMinimuminRotatedSortedArray[2];
        testObjects[0] = new FindMinimuminRotatedSortedArray().new FindMinimuminRotatedSortedArray0();
        testObjects[1] = new FindMinimuminRotatedSortedArray().new FindMinimuminRotatedSortedArray1();

    }

    @Test
    public void testFindMin() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int result = 0;
        Assert.assertEquals(result, testObjects[0].findMin(nums));
        Assert.assertEquals(result, testObjects[1].findMin(nums));
    }

    @Test
    public void testAll() {
        for (int oi = 0; oi < testObjects.length; oi++) {
            for (int i = 0; i < allNums.length; i++) {
                int[] nums = allNums[i];
                int result = results[i];
                Assert.assertEquals(result, testObjects[oi].findMin(nums));
            }
        }
    }

}
