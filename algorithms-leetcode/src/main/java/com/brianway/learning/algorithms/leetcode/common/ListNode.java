package com.brianway.learning.algorithms.leetcode.common;

/**
 * Created by Brian on 2016/5/5.
 * Definition for singly-linked list.
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}