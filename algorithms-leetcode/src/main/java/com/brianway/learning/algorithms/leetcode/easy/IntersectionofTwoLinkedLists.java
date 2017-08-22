package com.brianway.learning.algorithms.leetcode.easy;

import com.brianway.learning.algorithms.leetcode.common.ListNode;

/**
 * Created by Brian on 2016/5/4.
 * LeetCode 160. Intersection of Two Linked Lists
 * Question:https://leetcode.com/problems/intersection-of-two-linked-lists/
 * 关键题设：  preferably run in O(n) time and use only O(1) memory
 */
public class IntersectionofTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return null;
    }

    /**
     * 两次遍历，第一次分别遍历两链表，找长度的差值，第二次从距离交点等距的地方向后遍历
     * 时间复杂度O(n1+n2)
     * 空间复杂度O(1)
     */
    public class IntersectionofTwoLinkedLists0 extends IntersectionofTwoLinkedLists {
        @Override
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode a = headA;
            ListNode b = headB;
            int countA = 0;
            int countB = 0;

            while (a != null) {
                countA++;
                a = a.next;
            }
            while (b != null) {
                countB++;
                b = b.next;
            }
            a = headA;
            b = headB;
            if (countA > countB) {
                for (int i = 0; i < countA - countB; i++) {
                    a = a.next;
                }
            } else {
                for (int i = 0; i < countB - countA; i++) {
                    b = b.next;
                }
            }

            while (a != null) {
                if (a == b) {
                    return a;
                }
                a = a.next;
                b = b.next;
            }

            return null;

        }
    }
}
