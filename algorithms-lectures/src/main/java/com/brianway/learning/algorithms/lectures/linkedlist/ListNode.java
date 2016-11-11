package com.brianway.learning.algorithms.lectures.linkedlist;

import java.util.ArrayList;

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    public static ListNode createList(int[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        ListNode head = new ListNode(a[0]);
        ListNode current = head;
        for (int i = 1; i < a.length; i++) {
            current.next = new ListNode(a[i]);
            current = current.next;
        }
        return head;
    }

    public static ArrayList<Integer> getArray(ListNode head) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        while (head != null) {
            //System.out.print(head.val+",");
            array.add(head.val);
            head = head.next;
        }
        return array;
    }

    public static void print(ListNode head) {
        ArrayList<Integer> array = getArray(head);
        for (int i : array) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}

