package com.brianway.learning.algorithms.lectures.linkedlist;

/**
 * Created by brian on 16/11/14.
 *
 * 给定两个单链表的头节点head1和head2，如何判断两个链表是否相交？
 * 相交的话返回true，不想交的话返回false。
 * 给定两个链表的头结点head1和head2(注意，另外两个参数adjust0和adjust1用于调整数据,与本题求解无关)。
 * 请返回一个bool值代表它们是否相交。
 */
public class ChkIntersection2 {
    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        ListNode node1 = chkLoop(head1);
        ListNode node2 = chkLoop(head2);

        if (node1 == null && node2 == null) {
            return checkLinearIntersect(head1, head2);
        } else if (node1 != null && node2 != null) {
            return checkCircleIntersect(node1, node2);
        } else {
            return false;
        }

    }

    private ListNode chkLoop(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == slow) {
            slow = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }

        return null;

    }

    private boolean checkLinearIntersect(ListNode headA, ListNode headB) {
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

    private boolean checkCircleIntersect(ListNode node1, ListNode node2) {

        if (node1 == null || node2 == null) {
            return false;
        }

        if (node1 == node2) {
            return true;
        }

        ListNode current = node1.next;
        while (current != node1) {
            if (current == node2) {
                return true;
            }
            current = current.next;
        }

        return false;

    }
}
