package com.brianway.learning.algorithms.lectures.linkedlist;

/**
 * Created by brian on 16/11/10.
 *
 * 对于一个链表，我们需要用一个特定阈值完成对它的分化，
 * 使得小于等于这个值的结点移到前面，大于该值的结点在后面，
 * 同时保证两类结点内部的位置关系不变。
 * 给定一个链表的头结点head，同时给定阈值val，请返回一个链表，
 * 使小于等于它的结点在前，大于等于它的在后，保证结点值不重复。
 *
 * 测试样例：
 * {1,4,2,5},3
 * {1,2,4,5}
 */
public class Divide {
    public ListNode listDivide(ListNode head, int val) {
        ListNode smallHead = null;
        ListNode smallTail = null;
        ListNode bigHead = null;
        ListNode bigTail = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = null;
            if (current.val <= val) {
                if (smallHead == null) {
                    smallHead = current;
                    smallTail = current;
                } else {
                    smallTail.next = current;
                    smallTail = smallTail.next;
                }
            } else {
                if (bigHead == null) {
                    bigHead = current;
                    bigTail = current;
                } else {
                    bigTail.next = current;
                    bigTail = bigTail.next;
                }
            }
            current = next;
        }

        if (smallTail != null) {
            smallTail.next = bigHead;
        } else {
            smallHead = bigHead;
        }
        return smallHead;
    }
}
