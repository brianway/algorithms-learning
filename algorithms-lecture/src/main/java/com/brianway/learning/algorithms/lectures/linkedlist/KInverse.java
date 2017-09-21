package com.brianway.learning.algorithms.lectures.linkedlist;

/**
 * Created by brian on 16/11/11.
 *
 * 有一个单链表，请设计一个算法，使得每K个节点之间逆序，
 * 如果最后不够K个节点一组，则不调整最后几个节点。
 * 例如链表1->2->3->4->5->6->7->8->null，K=3这个例子。
 * 调整后为，3->2->1->6->5->4->7->8->null。
 * 因为K==3，所以每三个节点之间逆序，但其中的7，8不调整，因为只有两个节点不够一组。
 * 给定一个单链表的头指针head,同时给定K值，返回逆序后的链表的头指针。
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
        for (int i = 0; i < k; i++) {
            pre = newHead;
            newHead = current;
            current = current.next;
            newHead.next = pre;
        }
        head.next = current;

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

/*
 private ListNode reverse(ListNode head, int k) {
        ListNode newHead = null;
        ListNode current = head;
        ListNode pre = null;
        ListNode next = null;
        for (int i = 0; i < k; i++) {
            pre = newHead;
            next = current.next;
            newHead = current;
            current.next = pre;
            current = next;
        }
        head.next = next;

        return newHead;
    }
 */