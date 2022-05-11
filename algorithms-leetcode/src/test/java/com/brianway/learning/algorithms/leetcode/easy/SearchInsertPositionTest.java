package com.brianway.learning.algorithms.leetcode.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @auther brian
 * @since 2022/5/5 22:55
 */
public class SearchInsertPositionTest {
    private SearchInsertPosition testObject;

    private List<Testcase> testcases;

    @Before
    public void setUp() {
        testObject = new SearchInsertPosition.SearchInsertPosition0();

        testcases = Arrays.asList(
                Testcase.of(new int[] {1, 3, 5, 6}, 5, 2),
                Testcase.of(new int[] {1, 3, 5, 6}, 2, 1),
                Testcase.of(new int[] {1, 3, 5, 6}, 7, 4),
                Testcase.of(new int[] {2, 3, 5, 6}, 1, 0)
        );
    }

    @Test
    public void testSearchInsert() {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        int result = 2;
        Assert.assertEquals(result, testObject.searchInsert(nums, target));
    }

    @Test
    public void testAll() {
        for (Testcase tc : testcases) {
            Assert.assertEquals(tc.result, testObject.searchInsert(tc.nums, tc.target));
        }
    }

    private static class Testcase {
        int[] nums;
        int target;
        int result;

        private Testcase(int[] nums, int target, int result) {
            this.nums = nums;
            this.target = target;
            this.result = result;
        }

        public static Testcase of(int[] nums, int target, int result) {
            return new Testcase(nums, target, result);
        }
    }
}
