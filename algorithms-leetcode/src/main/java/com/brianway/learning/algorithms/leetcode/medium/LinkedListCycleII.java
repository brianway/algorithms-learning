package com.brianway.learning.algorithms.leetcode.medium;

import com.brianway.learning.algorithms.leetcode.common.ListNode;

/**
 * LeetCode 142. Linked List Cycle II
 * Question: https://leetcode.com/problems/linked-list-cycle-ii/
 * 关键题设：无
 *
 * @auther brian
 * @since 2022/12/11 20:19
 */
public class LinkedListCycleII {

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null) {
                fast = fast.next;
                if (fast != null) {
                    slow = slow.next;
                    fast = fast.next;
                } else {
                    return null;
                }

                // 快慢指针相遇说明有有环
                if (slow == fast) {
                    ListNode pointer = head;
                    while (slow != pointer) {
                        pointer = pointer.next;
                        slow = slow.next;
                    }
                    return pointer;
                }

            }
            return null;
        }
    }

}
