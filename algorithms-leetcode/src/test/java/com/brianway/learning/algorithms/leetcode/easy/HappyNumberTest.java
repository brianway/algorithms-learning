package com.brianway.learning.algorithms.leetcode.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Brian on 2016/4/30.
 */
public class HappyNumberTest {

    private HappyNumber testObject;

    private int[] nums = new int[] {19, 11};

    private boolean[] results = new boolean[] {true, false};

    @Before
    public void SetUp() {
        testObject = new HappyNumber().new HappyNumber0();
    }

    @Test
    public void testAll() {
        for (int i = 0; i < nums.length; i++) {
            Assert.assertEquals(results[i], testObject.isHappy(nums[i]));
        }
    }

}
