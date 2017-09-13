package com.brianway.learning.algorithms.leetcode.hard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RegularExpressionMatchingTest {
    private RegularExpressionMatching testObject;

    private String[][] sp = {
            {"aa", "a*"},
            {"aaa", "ab*a*c*a"}
    };

    private boolean[] results = {true, true};

    @Before
    public void SetUp() {
        testObject = new RegularExpressionMatching().new RegularExpressionMatching1();
    }

    @Test
    public void testIsMatch() {
        String s = "aab";
        String p = "c*a*b";
        Assert.assertEquals(true, testObject.isMatch(s, p));
    }

    @Test
    public void testAll() {
        for (int i = 0; i < sp.length; i++) {
            Assert.assertEquals(results[i], testObject.isMatch(sp[i][0], sp[i][1]));
        }
    }
}
