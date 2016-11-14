package com.brianway.learning.algorithms.lectures.linkedlist;

/**
 * Created by brian on 16/11/14.
 *
 * 如何判断两个有环单链表是否相交？相交的话返回第一个相交的节点，不想交的话返回空。
 * 如果两个链表长度分别为N和M，请做到时间复杂度O(N+M)，额外空间复杂度O(1)。
 * 给定两个链表的头结点head1和head2(注意，另外两个参数adjust0和adjust1用于调整数据,与本题求解无关)。
 * 请返回一个bool值代表它们是否相交。
 */
public class ChkIntersection {
    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        ListNode node1 = chkLoop(head1);
        ListNode node2 = chkLoop(head2);

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
}
