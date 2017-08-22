package com.brianway.learning.algorithms.leetcode.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Brian on 2016/4/30.
 */
public class MaximumSubarrayTest {

    private MaximumSubarray[] testObjects;

    @Before
    public void SetUp() {
        testObjects = new MaximumSubarray[2];
        testObjects[0] = new MaximumSubarray().new MaximumSubarray0();
        testObjects[1] = new MaximumSubarray().new MaximumSubarray1();
    }

    @Test
    public void testMaximumSubarray() {
        int[] nums = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = 6;
        Assert.assertEquals(result, testObjects[0].maxSubArray(nums));
        Assert.assertEquals(result, testObjects[1].maxSubArray(nums));
    }
}
