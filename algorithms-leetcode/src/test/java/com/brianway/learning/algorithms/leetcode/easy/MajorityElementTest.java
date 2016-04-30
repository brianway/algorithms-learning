package com.brianway.learning.algorithms.leetcode.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Brian on 2016/4/26.
 */
public class MajorityElementTest {

    private MajorityElement testObject;

    int []nums = new int[]{1,1,1,2,2,2,2,2,3};
    int result = 2;


    @Before
    public void SetUp(){
        testObject = new MajorityElement().new MajorityElement0();
    }

    @Test
    public void testremoveDuplicates(){
        Assert.assertEquals(result,testObject.majorityElement(nums));
    }
}
