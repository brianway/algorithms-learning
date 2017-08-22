package com.brianway.learning.algorithms.leetcode.easy;

import com.brianway.learning.algorithms.leetcode.common.ListNode;

/**
 * Created by Brian on 2016/5/4.
 * LeetCode 21. Merge Two Sorted Lists
 * Question:https://leetcode.com/problems/merge-two-sorted-lists/
 * 关键题设： two sorted linked lists
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return null;
    }

    /**
     * 链表的基本操作
     * 主要是要先添加一个头部,方便代码一致
     * 用一个指针指示当前节点的上一个节点,每次添加较小的那个
     * 直至一个其中一个遍历完，直接把另一链表全部接上即可
     *
     * 设l1长度为n1,l2长度n2
     * 时间复杂度：最坏情况O(n1+n2)
     * 空间复杂度 O(1)
     */
    public class MergeTwoSortedLists0 extends MergeTwoSortedLists {
        @Override
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(0);
            ListNode now = head;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    //now.next = new ListNode(l1.val);
                    now.next = l1;
                    l1 = l1.next;
                } else {
                    //now.next = new ListNode(l2.val);
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
