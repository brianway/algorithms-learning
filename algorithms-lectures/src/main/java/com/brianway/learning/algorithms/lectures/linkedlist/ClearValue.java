package com.brianway.learning.algorithms.lectures.linkedlist;

/**
 * Created by brian on 16/11/12.
 *
 * 现在有一个单链表。链表中每个节点保存一个整数，再给定一个值val，把所有等于val的节点删掉。
 * 给定一个单链表的头结点head，同时给定一个值val，请返回清除后的链表的头结点，保证链表中有不等于该值的其它值。请保证其他元素的相对顺序。
 *
 * 测试样例：
 * {1,2,3,4,3,2,1},2
 * {1,3,4,3,1}
 */
public class ClearValue {
    public ListNode clear(ListNode head, int val) {
        ListNode newHead = head;
        while (newHead != null) {
            if (newHead.val != val) {
                break;
            }
            newHead = newHead.next;
        }

        ListNode current = newHead;
        ListNode pre = newHead;
        while (current != null) {
            if (current.val == val) {
                pre.next = current.next;
            } else {
                pre = current;
            }
            current = current.next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 3, 2, 1};
        ListNode head = ListNode.createList(a);
        ClearValue cv = new ClearValue();
        ListNode newHead = cv.clear(head, 2);
        ListNode.print(newHead);
    }
}
