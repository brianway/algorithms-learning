package com.brianway.learning.algorithms.leetcode.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Brian on 2016/4/26.
 */
public class RemoveDuplicatesfromSortedArrayTest {

    private RemoveDuplicatesfromSortedArray testObject;

    @Before
    public void SetUp() {
        testObject = new RemoveDuplicatesfromSortedArray().new RemoveDuplicatesfromSortedArray0();
    }

    @Test
    public void testremoveDuplicates() {
        int[] nums = new int[] {1, 1, 2, 2, 3, 4, 7, 7, 15};
        int result = 6;
        Assert.assertEquals(result, testObject.removeDuplicates(nums));
    }
}
