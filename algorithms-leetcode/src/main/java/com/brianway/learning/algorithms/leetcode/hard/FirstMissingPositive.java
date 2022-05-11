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
     * 解法1：原地哈希，将数组下标作为key，通过数组值的正负号来标记是正整数是否出现过。
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
     * 思路3：从前的分析可以看出，需要原地哈希。数组下标看作key，数组值的正负号看作value表示是否出现过
     * 关键分析：
     * 1.如果nums[i]的值（记为x）的范围落在[1,n]之间，则将对应下标（偏移1，即nums[i]-1）的数组值 标记为负，表示x出现过
     * 2.为了避免原数组中的负数的干扰，所以需要将原负数改为特殊值（题设nums[i] <= 2^31 - 1，所以没法取Integer.MAX_VALUE这样的值，
     * 索性将负数都改为1，在改前先判断1是否有即可）。另外，nums[i]值在范围[1, n]外的也没必要额外处理，跳过即可。
     * 3.经过上面的改造，数组里第一个正数对应的下标+1即是 缺失的正整数
     * <p>
     * 边界条件：
     * 1.是否出现数值1
     * 2.重复数字的处理
     * <p>
     * 时间复杂度 O(n), 遍历了4遍数组, 其实前两遍遍历可以合并的，为了代码可读性就不合了。
     * 空间复杂度 O(1)
     */
    public static class FirstMissingPositive0 extends FirstMissingPositive {
        @Override
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;

            // fisrt pass, 特殊处理1
            boolean has1 = false;
            for (int i = 0; i < n; i++) {
                if (nums[i] == 1) {
                    has1 = true;
                    break;
                }
            }
            if (!has1) {
                return 1;
            }

            // second pass, 将负数都设置成1
            for (int i = 0; i < n; i++) {
                if (nums[i] <= 0) {
                    nums[i] = 1;
                }
            }

            // third pass, 做原地hash, 根据 nums[i]的绝对值，给对应下标上的数做符号标记，支持幂等
            for (int i = 0; i < n; i++) {
                int abs = Math.abs(nums[i]);
                if (abs >= 1 && abs <= n) {
                    nums[abs - 1] = -Math.abs(nums[abs - 1]);
                }
            }

            // forth pass, 再次遍历nums，找到第一个非负的
            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) {
                    return i + 1;
                }
            }

            // 遍历完数组都没负数，说明正整数1~n都出现了
            return n + 1;
        }
    }

    /**
     * 解法2：原地哈希，将数组下标作为key，通过数据交换，把对应的数换到对应下标，key和value满足映射关系表示出现过。
     * <p>
     * 前提同解法1，需要推导出 缺失的正整数范围一定落在[1, n+1]之间, n为数组长度。
     * <p>
     * 对于数组内的每个元素，通过数据交换，将其放到对应的下标。规则为：
     * 如果nums的元素值nums[i]大小为p，若1<=p<=n （n=nums.length）,则将其交换到下标为p-1的位置，即swap 下标i 和下标 p-1的 元素。
     * 需要注意:
     * 1. 如果下标p-1的元素已经满足映射关系，即nums[p-1]=p，则无需交换，否则需要继续对当前下标i的元素做交换，直至nums[i]的值范围不在1~n之间
     *
     * <p>
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public static class FirstMissingPositive1 extends FirstMissingPositive {
        @Override
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                while (nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                    swap(nums, i, nums[i] - 1);
                }
            }

            for (int i = 0; i < n; i++) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }

            return n + 1;

        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
