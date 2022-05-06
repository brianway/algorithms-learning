package com.brianway.learning.algorithms.leetcode.medium;

import com.brianway.learning.algorithms.leetcode.common.ListNode;

/**
 * LeetCode 24. Swap Nodes in Pairs
 * Question https://leetcode.com/problems/swap-nodes-in-pairs/
 * 关键题设：without modifying the values in the list's nodes
 *
 * @auther brian
 * @since 2022/5/6 22:58
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        return null;
    }

    /**
     * 递归写法
     * n1->n2->n3->n4
     * <p>
     * 第1步(可选，没有也不影响)：断开第二个节点的next。 n1->n2  n3->n4
     * 第2步：反转后面的子链表 n3->n4 为 n4->n3
     * 第3步：反转n1和n2：
     * 3.1 修改n2.next指向  n1<=>n2 即 n2<=>n1
     * 3.2 修改n1.next指向  n2->n1->（n4->n3）
     * 返回n2即可
     */
    public class SwapNodesInPairs0 extends SwapNodesInPairs {
        @Override
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            // 递归swap子链表
            ListNode headOfSub = head.next.next;
            ListNode swappedSubHead = swapPairs(headOfSub);

            ListNode newHead = head.next;
            // swap head and head.next
            newHead.next = head;
            head.next = swappedSubHead;
            return newHead;
        }
    }

    /**
     * TODO 非递归的写法
     * 借助哨兵节点简化写法
     */
    public class SwapNodesInPairs1 extends SwapNodesInPairs {
        @Override
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;

            // swap head and head.next

            // 循环swap剩下的

            return dummyHead.next;
        }
    }
}
