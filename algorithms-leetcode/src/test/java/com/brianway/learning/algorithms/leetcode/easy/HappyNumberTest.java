package com.brianway.learning.algorithms.leetcode.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Brian on 2016/4/30.
 */
public class HappyNumberTest {

    private HappyNumber testObject;

    int[] nums = new int[] {19, 11};

    boolean[] result_array = new boolean[] {true, false};

    @Before
    public void SetUp() {
        testObject = new HappyNumber().new HappyNumber0();
    }

    @Test
    public void testHappyNumberMore() {
        for (int i = 0; i < nums.length; i++) {
            Assert.assertEquals(result_array[i], testObject.isHappy(nums[i]));
        }
    }

}
