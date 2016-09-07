package com.brianway.learning.algorithms.leetcode.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Brian on 2016/4/30.
 */
public class MaximumSubarrayTest {

    private MaximumSubarray testObject;

    int[] nums = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int result = 6;

    @Before
    public void SetUp() {
        testObject = new MaximumSubarray().new MaximumSubarray1();
    }

    @Test
    public void testMaximumSubarray() {
        Assert.assertEquals(result, testObject.maxSubArray(nums));
    }
}
