package com.brianway.learning.algorithms.leetcode.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Brian on 2016/4/19.
 */
public class PowerOfTwoTest {

    private PowerOfTwo testObject;

    int[] nums = new int[] {0, 2, -4, 11, 16};

    boolean[] result = {false, true, false, false, true};

    @Before
    public void SetUp() {
        testObject = new PowerOfTwo().new PowerOfTwo1();
    }

    @Test
    public void testIsPowerOfTwo() {
        for (int i = 0; i < nums.length; i++) {
            Assert.assertEquals(result[i], testObject.isPowerOfTwo(nums[i]));
        }

    }

}
