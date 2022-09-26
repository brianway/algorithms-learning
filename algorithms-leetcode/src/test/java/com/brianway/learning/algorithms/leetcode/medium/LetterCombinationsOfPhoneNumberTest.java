package com.brianway.learning.algorithms.leetcode.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumberTest {

    private LetterCombinationsOfPhoneNumber testObject;

    @Before
    public void setUp() {
        testObject = new LetterCombinationsOfPhoneNumber.LetterCombinationsOfPhoneNumber0();
    }

    @Test
    public void testLetterCombinations() {
        String digits = "";
        List<String> result = new ArrayList<>();
        Assert.assertEquals(result, testObject.letterCombinations(digits));
    }
}
