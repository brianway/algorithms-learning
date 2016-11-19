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

    public static ArrayList<Integer> toArrayList(ListNode head) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        while (head != null) {
            //System.out.print(head.val+",");
            arrayList.add(head.val);
            head = head.next;
        }
        return arrayList;
    }

    public static int[] toArray(ListNode head) {
        ArrayList<Integer> arrayList = toArrayList(head);
        int[] arr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            arr[i] = arrayList.get(i);
        }
        return arr;
    }

    public static void print(ListNode head) {
        ArrayList<Integer> array = toArrayList(head);
        for (int i : array) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}

