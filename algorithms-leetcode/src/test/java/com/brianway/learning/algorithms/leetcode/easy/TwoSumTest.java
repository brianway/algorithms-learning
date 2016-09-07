package com.brianway.learning.algorithms.leetcode.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Brian on 2016/4/19.
 */
public class TwoSumTest {

    private TwoSum testObject;

    int[] nums = new int[] {2, 7, 11, 15};
    int target = 9;
    int[] result = {0, 1};

    @Before
    public void SetUp() {
        testObject = new TwoSum().new TwoSum1();
    }

    @Test
    public void testTwoSum() {
        Assert.assertArrayEquals(result, testObject.twoSum(nums, target));

    }

}
