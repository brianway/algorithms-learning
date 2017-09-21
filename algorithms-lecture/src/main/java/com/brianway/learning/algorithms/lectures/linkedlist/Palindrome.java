package com.brianway.learning.algorithms.lectures.linkedlist;

/**
 * Created by brian on 16/11/13.
 *
 * 请编写一个函数，检查链表是否为回文。
 * 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
 *
 * 测试样例：
 * {1,2,3,2,1}
 * 返回：true
 * {1,2,3,2,3}
 * 返回：false
 */
public class Palindrome {
    public boolean isPalindrome(ListNode pHead) {
        if (pHead == null) {
            return false;
        }

        ListNode slow = pHead;
        ListNode quick = pHead;
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }

        boolean result = false;
        ListNode mid = slow;
        if (quick.next == null) {//单数个节点
            ListNode tail = reverse(mid);
            result = meetToMid(pHead, tail);
            reverse(tail);
        } else {
            mid = slow.next;
            slow.next = null;//int[] a = {1, 2, 3, 3, 2, 1};
            ListNode tail = reverse(mid);
            result = meetToMid(pHead, tail);
            slow.next = reverse(tail);
        }

        return result;
    }

    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        ListNode pre = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            newHead = current;
            newHead.next = pre;
            pre = current;
            current = next;
        }
        return newHead;
    }

    private boolean meetToMid(ListNode head, ListNode tail) {
        while (head != null && tail != null) {
            if (head.val != tail.val) {
                return false;
            }
            head = head.next;
            tail = tail.next;
        }

        return (head == null && tail == null);
    }

    public static void main(String[] args) {
        //int []a  = {5,2,2,3,7,0,7,2,1,0,6,1,0,3,3,3,4,3,4,5,5,4,9,0,9,4,0,6,3,2,2,1,6,7,1,8,2,8,0,6,0,0,4,1,8,2,2,8,1,4,0,0,6,0,8,2,8,1,7,6,1,2,2,3,6,0,4,9,0,9,4,5,5,4,3,4,3,3,3,0,1,6,0,1,2,7,0,7,3,2,2,5};
        int[] a = {1, 2, 3, 3, 2, 1};
        //int[] a = {1, 2, 3, 2, 1};
        //int[]a = {1,1};
        //int [] a = {1};
        Palindrome p = new Palindrome();
        ListNode head = ListNode.createList(a);
        boolean b = p.isPalindrome(head);
        System.out.println(b);
    }
}
