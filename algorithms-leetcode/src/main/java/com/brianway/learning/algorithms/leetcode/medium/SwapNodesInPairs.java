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
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度 O(1)
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
     * 非递归的写法
     * 借助哨兵节点简化写法
     * <p>
     * 假设当前：n0(pre) -> n1 (cur)-> n2 -> n3 -> n4...,  此时 pre = n0, cur= n1
     * 期望单次循环后的结果：n0->n2->n1(pre)->n3(cur)->n4
     * <p>
     * 1. n0(pre)->n2, n1(cur)->n2->n3->n4   //  pre.next = cur.next;
     * 2. n0(pre)->n2, n1(cur)->n3->n4       //  cur.next = cur.next.next;
     * 3. n0(pre)->n2->n1(cur)->n3->n4       //  pre.next.next = cur;
     * 4. n0->n2->n1(pre)->n3(cur)->4        //  pre = pre.next.next; cur = cur.next;
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度 O(1)
     */
    public class SwapNodesInPairs1 extends SwapNodesInPairs {
        @Override
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;

            ListNode pre = dummyHead;
            ListNode cur = head;

            // 循环swap剩下的
            while (cur != null && cur.next != null) {
                // swap cur and cur.next
                pre.next = cur.next;
                cur.next = cur.next.next;
                pre.next.next = cur;

                // 移动pre和cur的指向以便下一次迭代
                pre = pre.next.next;
                cur = cur.next;
            }

            return dummyHead.next;
        }
    }
}
