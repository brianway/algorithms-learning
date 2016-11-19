package com.brianway.learning.algorithms.lectures.linkedlist;

/**
 * Created by brian on 16/11/14.
 *
 * 现在有两个无环单链表，若两个链表的长度分别为m和n，
 * 请设计一个时间复杂度为O(n + m)，额外空间复杂度为O(1)的算法，判断这两个链表是否相交。
 * 给定两个链表的头结点headA和headB，请返回一个bool值，代表这两个链表是否相交。
 * 保证两个链表长度小于等于500。
 */
public class CheckIntersect {
    public boolean chkIntersect(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return false;
        }

        ListNode a = headA;
        ListNode b = headB;
        int m = 0;
        int n = 0;
        while (a != null) {
            a = a.next;
            m++;
        }
        while (b != null) {
            b = b.next;
            n++;
        }

        a = headA;
        b = headB;
        if (m >= n) {
            for (int i = 0; i < m - n; i++) {
                a = a.next;
            }
        } else {
            for (int i = 0; i < n - m; i++) {
                b = b.next;
            }
        }

        while (a != null) {
            if (a == b) {
                return true;
            }
            a = a.next;
            b = b.next;
        }

        return false;

    }
}
