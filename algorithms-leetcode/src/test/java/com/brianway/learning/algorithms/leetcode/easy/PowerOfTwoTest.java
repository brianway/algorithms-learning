package com.brianway.learning.algorithms.leetcode.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Brian on 2016/4/19.
 */
public class PowerOfTwoTest {

    private PowerOfTwo[] testObjects;

    @Before
    public void SetUp() {
        testObjects = new PowerOfTwo[2];
        testObjects[0] = new PowerOfTwo().new PowerOfTwo0();
        testObjects[1] = new PowerOfTwo().new PowerOfTwo1();
    }

    @Test
    public void testIsPowerOfTwo() {
        int[] nums = new int[] {0, 2, -4, 11, 16, -6};
        boolean[] result = {false, true, false, false, true, false};
        for (int i = 0; i < nums.length; i++) {
            Assert.assertEquals(result[i], testObjects[0].isPowerOfTwo(nums[i]));
            Assert.assertEquals(result[i], testObjects[1].isPowerOfTwo(nums[i]));
        }
    }

}
