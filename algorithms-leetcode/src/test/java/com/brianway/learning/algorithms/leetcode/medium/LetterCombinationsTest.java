package com.brianway.learning.algorithms.leetcode.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsTest {

    private LetterCombinations testObject;

    @Before
    public void SetUp() {
        testObject = new LetterCombinations().new LetterCombinations0();
    }

    @Test
    public void testLetterCombinations() {
        String digits = "";
        List<String> result = new ArrayList<>();
        Assert.assertEquals(result, testObject.letterCombinations(digits));
    }
}
