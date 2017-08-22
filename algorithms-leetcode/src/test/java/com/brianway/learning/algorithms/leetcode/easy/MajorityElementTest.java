package com.brianway.learning.algorithms.leetcode.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Brian on 2016/4/26.
 */
public class MajorityElementTest {

    private MajorityElement[] testObjects;

    @Before
    public void SetUp() {
        testObjects = new MajorityElement[3];
        testObjects[0] = new MajorityElement().new MajorityElement0();
        testObjects[1] = new MajorityElement().new MajorityElement1();
        testObjects[2] = new MajorityElement().new MajorityElement2();
    }

    @Test
    public void testremoveDuplicates() {
        int[] nums = new int[] {1, 1, 1, 2, 2, 2, 2, 2, 3};
        int result = 2;
        Assert.assertEquals(result, testObjects[0].majorityElement(nums));
        Assert.assertEquals(result, testObjects[1].majorityElement(nums));
        Assert.assertEquals(result, testObjects[2].majorityElement(nums));
    }
}
