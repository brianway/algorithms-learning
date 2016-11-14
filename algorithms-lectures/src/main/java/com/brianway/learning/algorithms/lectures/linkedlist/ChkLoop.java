package com.brianway.learning.algorithms.lectures.linkedlist;

/**
 * Created by brian on 16/11/14.
 *
 * 如何判断一个单链表是否有环？
 * 有环的话返回进入环的第一个节点的值，无环的话返回-1。
 * 如果链表的长度为N，请做到时间复杂度O(N)，额外空间复杂度O(1)。
 *
 * 给定一个单链表的头结点head（注意另一个参数adjust为加密后的数据调整参数，
 * 方便数据设置，与本题求解无关)，请返回所求值。
 *
 * 参考:
 * http://blog.csdn.net/wuzhekai1985/article/details/6725263
 * http://blog.sina.com.cn/s/blog_6a0e04380101a9o2.html
 */
public class ChkLoop {
    public int chkLoop(ListNode head, int adjust) {
        if (head == null) {
            return -1;
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
            return slow.val;
        }

        return -1;

    }
}
