package com.brianway.learning.algorithms.lectures.linkedlist;

/**
 * Created by brian on 16/11/10.
 *
 * 有一个整数val，如何在节点值有序的环形链表中插入一个节点值为val的节点，并且保证这个环形单链表依然有序。
 * 给定链表的信息，及元素的值A及对应的nxt指向的元素编号同时给定val，请构造出这个环形链表，并插入该值。
 *
 * 测试样例：
 * [1,3,4,5,7],[1,2,3,4,0],2
 * 返回：{1,2,3,4,5,7}
 */
public class InsertValue {

    public ListNode insert(int[] A, int[] nxt, int val) {
        //空链表时该节点自己组环
        if (A == null || nxt == null) {
            ListNode node = new ListNode(val);
            node.next = node;
            return node;
        }

        //构造环形链表
        ListNode head = new ListNode(A[0]);
        ListNode current = head;
        for (int i = 0; i < A.length - 1; i++) {
            ListNode next = new ListNode(A[nxt[i]]);
            current.next = next;
            current = next;
        }
        current.next = head;

        ListNode pre = head;
        ListNode after = head.next;
        ListNode insert = new ListNode(val);
        while (after != head) {
            if (pre.val <= val && val < after.val) {
                pre.next = insert;
                insert.next = after;
                break;
            } else {
                pre = after;
                after = after.next;
            }
        }

        // insert 节点为最大或者最小，插入首尾之间
        if (after == head) {
            pre.next = insert;
            insert.next = head;
            if (val < after.val) {
                head = insert;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        InsertValue iv = new InsertValue();
        int[] a = {1, 3, 4, 5, 7};
        int[] next = {1, 2, 3, 4, 0};
        ListNode head = iv.insert(a, next, 2);
        ListNode current = head;
        do {
            System.out.println(current.val);
            current = current.next;
        } while (current != head);
    }
}


/*
 public ListNode insert(int[] A, int[] nxt, int val) {
        if (A == null || nxt == null) {
            ListNode node = new ListNode(val);
            //node.next = node;
            return node;
        }

        ListNode head = new ListNode(A[0]);
        ListNode current = head;
        for (int i = 0; i < A.length - 1; i++) {
            ListNode next = new ListNode(A[nxt[i]]);
            current.next = next;
            current = next;
        }
        //current.next = head;

        ListNode pre = head;
        ListNode after = head.next;
        ListNode insert = new ListNode(val);
        while (after != null) {
            if (pre.val < val && after.val >= val) {
                pre.next = insert;
                insert.next = after;
                break;
            } else {
                pre = after;
                after = after.next;
            }
        }

        if (after == null) {
            if (val <= head.val) {
                insert.next = head;
                head = insert;
            }else{
                pre.next = insert;
            }
        }

        return head;
     }
 */