package com.brianway.learning.algorithms.leetcode.hard;

/**
 * LeetCode 41. First Missing Positive
 * Question: https://leetcode.com/problems/first-missing-positive/
 * 关键题设：unsorted integer array, runs in O(n) time and uses constant extra space.
 *
 * @auther brian
 * @since 2022/5/10 22:23
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        return 0;
    }

    /**
     * 解法1：原地哈希，通过正负号来标记是正整数否出现过。
     * <p>
     * 前提：需要推导出 缺失的正整数范围一定落在[1, n+1]之间, n为数组长度。
     * 推导过程：数组nums长度为n,则最多只能覆盖n个正整数，且nums里每多一个负数或重复的数，则少覆盖一个正整数的范围
     * 所以按照数值1，2...开始检查nums值中是否有缺失的，缺失的值的范围一定落在 [1, n+1]之间
     * <p>
     * 思路1：另外构建哈希表，空间复杂度O(n)，不满足题目要求的constant extra space。
     * 具体实现：以nums的值为key, 下标或者 true/false 为value，构建HashMap，
     * 然后再从1到n作为key依次查询HashMap里是否有对应value。
     * <p>
     * 思路2：数组inplace排序，时间复杂度O(n log n), 不满足题目要求的 O(n) time.
     * 具体实现：先对数组排序，找到数组的最小整数的位置p，然后从p开始，依次比较数组的值和1~n的值，
     * 即nums[p]==1, nums[p+1]==2, ... 找出第一个不相等的即是缺失的
     * <p>
     * 思路3：从前的分析可以看出，需要原地哈希。
     * 关键分析：
     * 1.如果nums[i]的值（记为x）的范围落在[1,n]之间，则将对应下标（偏移1，即nums[i]-1）的数组值 标记为负，表示x出现过
     * 2.为了避免 原数组的负数的干扰，所以需要将原负数改为特殊值（题设nums[i] <= 2^31 - 1，所以没法取IntMax这样的值，索性改为1，在改前先判断1是否有即可）
     * 3.经过上面的改造，数组里第一个正数对应的下标+1即是 缺失的正整数
     * <p>
     * 边界条件：
     * 1.是否出现数值1
     * 2.重复数字的处理
     * <p>
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public class FirstMissingPositive0 extends FirstMissingPositive {
        @Override
        public int firstMissingPositive(int[] nums) {
            return super.firstMissingPositive(nums);
        }
    }

}
