package com.brianway.learning.algorithms.leetcode.easy;

import com.brianway.learning.algorithms.leetcode.common.ListNode;

/**
 * Created by brian on 16/5/22.
 * LeetCode 141. Linked List Cycle
 * Question:https://leetcode.com/problems/linked-list-cycle/
 * 关键题设：without using extra space
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        return false;
    }

    /**
     * 快慢指针
     * 如果有环,两指针一定会相遇
     * 因为每次循环,快指针会追赶慢指针一个节点的距离,所以不会出现跳过的问题
     *
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * 分析可见 https://leetcode.com/articles/linked-list-cycle/
     */
    public class LinkedListCycle0 extends LinkedListCycle {
        @Override
        public boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }

            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    return true;
                }
            }
            return false;
        }
    }
}
