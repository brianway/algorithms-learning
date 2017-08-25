package com.brianway.learning.algorithms.leetcode.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Brian on 2016/4/30.
 */
public class FindPeakElementTest {

    private FindPeakElement testObject;

    private int[][] allNums = new int[][] {
            {1},
            {3, 4},
            {4, 2},
            {1, 2, 3},
            {3, 2, 1},
            {1, 2, 3, 1}
    };
    private int[] results = new int[] {0, 1, 0, 2, 0, 2};

    @Before
    public void SetUp() {
        testObject = new FindPeakElement().new FindPeakElement0();
    }

    @Test
    public void testFindPeakElement() {
        int[] nums = new int[] {1, 2, 3, 1};
        int result = 2;
        Assert.assertEquals(result, testObject.findPeakElement(nums));
    }

    @Test
    public void testAll() {
        for (int i = 0; i < allNums.length; i++) {
            Assert.assertEquals(results[i], testObject.findPeakElement(allNums[i]));
        }
    }

}
