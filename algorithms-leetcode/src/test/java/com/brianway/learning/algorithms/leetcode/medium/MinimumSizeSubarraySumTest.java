package com.brianway.learning.algorithms.leetcode.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MinimumSizeSubarraySumTest {
    private MinimumSizeSubarraySum testObject;

    private int[][] allNums = {{2, 3, 1, 2, 4, 3}, {1, 2, 3, 4, 5}};
    private int[] ss = {7, 11};
    private int[] results = {2, 3};

    @Before
    public void SetUp() {
        testObject = new MinimumSizeSubarraySum().new MinimumSizeSubarraySum0();
    }

    @Test
    public void testMinSubArrayLen() {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        int result = 2;
        Assert.assertEquals(result, testObject.minSubArrayLen(s, nums));
    }

    @Test
    public void testAll() {
        for (int i = 0; i < allNums.length; i++) {
            int[] nums = allNums[i];
            int s = ss[i];
            int result = results[i];
            Assert.assertEquals(result, testObject.minSubArrayLen(s, nums));
        }
    }

}
