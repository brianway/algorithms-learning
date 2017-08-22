package com.brianway.learning.algorithms.leetcode.medium;

import com.brianway.learning.algorithms.leetcode.common.ListNode;

/**
 * Created by brian on 16/5/22.
 * LeetCode 148. Sort List
 * Question:https://leetcode.com/problems/sort-list/
 * 关键题设： Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        return null;
    }

    /**
     * 归并排序
     * 使用快慢指针得到链表中点,快指针一次进两个节点,慢指针一次一个
     * 分别排序前一半和后一半(前一半的最后一个节点的next要置为null)
     * 合并两个已排序的子链表(参考LeetCode 21)
     * 时间复杂度 O(n log n)
     * 空间复杂度 O(1),但是方法栈用了空间
     *
     * [1]-[2]-[3]-[4]-[5]-[6]
     * slow->3,fast->5
     *
     * [1]-[2]-[3]-[4]-[5]-[6]-[7]
     * slow->4,fast->7
     */
    public class SortList0 extends SortList {
        @Override
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            //得到链表的前一半和后一半
            fast = slow.next;
            slow.next = null;
            ListNode l1 = sortList(fast);
            ListNode l2 = sortList(head);

            return mergeTwoLists(l1, l2);

        }

        /**
         * 该方法可参考 LeetCode 21
         * Question:https://leetcode.com/problems/merge-two-sorted-lists/
         *
         * @param l1
         * @param l2
         * @return
         */
        private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(0);
            ListNode now = head;

            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    now.next = l1;
                    l1 = l1.next;
                } else {
                    now.next = l2;
                    l2 = l2.next;
                }
                now = now.next;
            }
            if (l1 != null) {
                now.next = l1;
            }
            if (l2 != null) {
                now.next = l2;
            }
            return head.next;
        }
    }

}
