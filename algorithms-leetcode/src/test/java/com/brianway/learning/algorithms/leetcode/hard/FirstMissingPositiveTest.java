package com.brianway.learning.algorithms.leetcode.hard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @auther brian
 * @since 2022/5/5 22:55
 */
public class FirstMissingPositiveTest {
    private FirstMissingPositive testObject;

    private List<Testcase> testcases;

    @Before
    public void setUp() {
        testObject = new FirstMissingPositive.FirstMissingPositive0();

        testcases = Arrays.asList(
                Testcase.of(new int[] {1, 2, 0}, 3),
                Testcase.of(new int[] {3, 4, -1, 1}, 2),
                Testcase.of(new int[] {7,8,9,11,12}, 1)
        );
    }

    @Test
    public void testFirstMissingPositive() {
        int[] nums = {3, 4, -1, 1};
        int result = 2;
        Assert.assertEquals(result, testObject.firstMissingPositive(nums));
    }

    @Test
    public void testAll() {
        for (Testcase tc : testcases) {
            Assert.assertEquals(tc.result, testObject.firstMissingPositive(tc.nums));
        }
    }

    private static class Testcase {
        int[] nums;
        int result;

        private Testcase(int[] nums, int result) {
            this.nums = nums;
            this.result = result;
        }

        public static Testcase of(int[] nums, int result) {
            return new Testcase(nums, result);
        }
    }
}
