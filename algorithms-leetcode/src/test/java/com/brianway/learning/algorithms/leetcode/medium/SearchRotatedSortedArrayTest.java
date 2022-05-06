package com.brianway.learning.algorithms.leetcode.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @auther brian
 * @since 2022/5/5 22:55
 */
public class SearchRotatedSortedArrayTest {
    private SearchInRotatedSortedArray testObject;

    private List<Testcase> testcases;
    private int[][] allNums = {{2, 3, 1, 2, 4, 3}, {1, 2, 3, 4, 5}};
    private int[] targets = {7, 11};
    private int[] results = {2, 3};

    @Before
    public void setUp() {
        testObject = new SearchInRotatedSortedArray.SearchInRotatedSortedArray1();

        testcases = Arrays.asList(
                Testcase.of(new int[] {4, 5, 6, 7, 0, 1, 2}, 0, 4),
                Testcase.of(new int[] {3, 2}, 2, 1),
                Testcase.of(new int[] {1, 3}, 3, 1),
                Testcase.of(new int[] {4, 5, 6, 7, 8, 1, 2, 3}, 8, 4),
                Testcase.of(new int[] {1, 2, 4, 5}, 4, 2)
        );
    }

    @Test
    public void testSearch() {
        int[] nums = {4, 5, 6, 7, 8, 1, 2, 3};
        int target = 8;
        int result = 4;
        Assert.assertEquals(result, testObject.search(nums, target));
    }

    @Test
    public void testAll() {
        for (Testcase tc : testcases) {
            Assert.assertEquals(tc.result, testObject.search(tc.nums, tc.target));
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
