package com.brianway.learning.algorithms.leetcode.medium;

import com.brianway.learning.algorithms.leetcode.common.ListNode;

/**
 * LeetCode 2. Add Two Numbers
 * Question: https://leetcode.com/problems/add-two-numbers/
 * 关键题设：non-empty, reverse order
 *
 * @auther brian
 * @since 2022/4/18 20:58
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return null;
    }

    /**
     * 题目相对简单，注意边界条件:
     * 最后最后进1时，需要新加一个节点
     * <p>
     * 写法1： 先一起遍历，再继续遍历长的链表
     * <p>
     * 时间复杂度 O(n+m)
     * 空间复杂度 O(n+m)
     */
    public static class AddTwoNumbers0 extends AddTwoNumbers {
        @Override
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(-1);
            ListNode cur = dummyHead;
            int sum = 0;
            int flag = 0;
            while (l1 != null && l2 != null) {
                sum = l1.val + l2.val + flag;
                if (sum >= 10) {
                    sum = sum - 10;
                    flag = 1;
                } else {
                    flag = 0;
                }
                cur.next = new ListNode(sum);
                cur = cur.next;

                l1 = l1.next;
                l2 = l2.next;
            }

            ListNode rest = (l1 == null) ? l2 : l1;
            while (rest != null) {
                sum = rest.val + flag;
                if (sum >= 10) {
                    sum = sum - 10;
                    flag = 1;
                } else {
                    flag = 0;
                }
                cur.next = new ListNode(sum);
                cur = cur.next;

                rest = rest.next;
            }

            // 最后进1时，需要新加一个节点
            if (flag == 1) {
                cur.next = new ListNode(1);
            }

            return dummyHead.next;
        }
    }

    /**
     * 写法2： 先一起遍历，在循环里判断链表是否为空
     */
    public static class AddTwoNumbers1 extends AddTwoNumbers {
        @Override
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(-1);
            ListNode cur = dummyHead;
            int sum = 0;
            int flag = 0;
            while (l1 != null || l2 != null) {
                sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + flag;
                if (sum >= 10) {
                    sum = sum - 10;
                    flag = 1;
                } else {
                    flag = 0;
                }
                cur.next = new ListNode(sum);
                cur = cur.next;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            if (flag == 1) {
                cur.next = new ListNode(1);
            }

            return dummyHead.next;
        }
    }
}
