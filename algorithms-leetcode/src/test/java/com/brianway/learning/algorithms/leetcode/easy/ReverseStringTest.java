package com.brianway.learning.algorithms.leetcode.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Brian on 2016/4/19.
 */
public class ReverseStringTest {

    private ReverseString testObject;

    @Before
    public void SetUp() {
        testObject = new ReverseString().new ReverseString0();
    }

    @Test
    public void testAll() {
        String[] origin = new String[] {"", "123", "a.", "asdfg", "asdfgh"};
        String[] result = {"", "321", ".a", "gfdsa", "hgfdsa"};
        for (int i = 0; i < origin.length; i++) {
            Assert.assertEquals(result[i], testObject.reverseString(origin[i]));
        }
    }

}
