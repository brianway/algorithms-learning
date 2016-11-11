package com.brianway.learning.algorithms.lectures.linkedlist;

/**
 * Created by brian on 16/11/11.
 *
 * 现在有一个单链表。链表中每个节点保存一个整数，再给定一个值val，把所有等于val的节点删掉。
 * 给定一个单链表的头结点head，同时给定一个值val，请返回清除后的链表的头结点，
 * 保证链表中有不等于该值的其它值。请保证其他元素的相对顺序。
 *
 * 测试样例：
 * {1,2,3,4,3,2,1},2
 * {1,3,4,3,1}
 */
public class KInverse {
    public ListNode inverse(ListNode head, int k) {
        if (k < 2) {
            return head;
        }

        ListNode newHead = null;
        ListNode kHead = head;
        ListNode next = null;
        ListNode lastTail = null;
        ListNode current = head;
        int count = 0;

        while (current != null) {
            next = current.next;
            count++;

            //System.out.println("current: " + current.val);
            if (count == k) {
                if (newHead == null) {
                    newHead = reverse(kHead, k);
                } else {
                    lastTail.next = reverse(kHead, k);
                }
                lastTail = kHead;
                kHead = next;
                count = 0;
            }
            current = next;
        }

        return newHead;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode newHead = null;
        ListNode current = head;
        ListNode pre = null;
        ListNode next = null;
        for (int i = 0; i < k; i++) {
            newHead = current;
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        head.next = next;

        return newHead;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 5, 11};
        ListNode head = ListNode.createList(a);
        ListNode.print(head);
        KInverse ki = new KInverse();
        ListNode newHead = ki.inverse(head, 2);
        ListNode.print(newHead);
    }
}
