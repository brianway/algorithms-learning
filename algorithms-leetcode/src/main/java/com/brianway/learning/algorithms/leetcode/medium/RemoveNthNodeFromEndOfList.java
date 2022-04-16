package com.brianway.learning.algorithms.leetcode.medium;

import com.brianway.learning.algorithms.leetcode.common.ListNode;

/**
 * LeetCode 19. Remove Nth Node From End of List
 * Question: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 关键题设：from the end of the list
 *
 * @auther brian
 * @since 2022/4/16 23:45
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        return null;
    }

    /**
     * 遍历两遍：
     * 先从头遍历一遍得到链表长度，记为length
     * 再从头遍历至倒数第n-1个节点(假如是nk)的地方，令 nk.next = nk.next.next
     * <p>
     * 需要考虑边界情况
     * 1. n = length 时，即要删除的是头节点，单独处理
     * 2. 其他情况下，要删除的是非头节点
     * 3. 从head开始统计length时，如果根据cur!=null,就是从0计数；如果根据cur.next!=null，就是从1计数
     * <p>
     * 例子：
     * n1->n2->n3->n4
     * <p>
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public static class RemoveNthNodeFromEndOfList0 extends RemoveNthNodeFromEndOfList {
        @Override
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // 题目约束条件里约定链表非空，所以head=null边界不用考虑
            if (head == null) {
                throw new IllegalArgumentException("list size should >= 1");
            }

            ListNode cur = head;
            int length = 0;
            while (cur != null) {
                length++;
                cur = cur.next;
            }

            // 倒数第n-1个节点 是 顺数第k个节点（从1开始）
            int k = length - n;
            if (k == 0) {
                return head.next;
            }

            int i = 1;
            cur = head;
            while (i < k) {
                cur = cur.next;
                i++;
            }
            // now i is equal to k and cur is point at nk
            cur.next = cur.next.next;

            return head;
        }
    }

    /**
     * 双指针，只用遍历一遍
     * <p>
     * 关于指针的距离分析：
     * 例子：输入[n1,n2,n3,n4], 2
     * n1->n2->n3->n4 可以看作 n1->n2->n3->n4->null
     * 其中tail节点(即n4)的next是null,可以倒数第0个,则n3是倒数第2个，n3到null距离是2;
     * 同理，如果fast和slow的距离也是n,即pos(fast)-pos(slow)=2，则fast指向结尾的null时，slow刚好指向倒数第2个节点，即n3（也是要删除的节点）
     * fast和slow同时向前挪一个，对应的是fast指向tail节点即n4时，slow刚好指向倒数第3个，即n2
     * <p>
     * 需要考虑边界情况
     * 1. n = length 时，即要删除的是头节点，单独处理。对应代码中（fast == null的分支判断）
     * <p>
     * 例子：
     * n1->n2->n3->n4
     */
    public static class RemoveNthNodeFromEndOfList1 extends RemoveNthNodeFromEndOfList {
        @Override
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // 题目约束条件里约定链表非空，所以head=null边界不用考虑
            if (head == null) {
                throw new IllegalArgumentException("list size should >= 1");
            }

            ListNode slow = head;
            ListNode fast = head;
            while (n > 0) {
                n--;
                fast = fast.next;
            }

            if (fast == null) {
                // n is equal to length
                return head.next;
            }

            // now, slow is after fast n nodes
            // assume that show index is s, fast index is f, then f-s = n
            // thus when fast reach tail's next (null), slow reach the node to delete
            // that is to say,  when fast reach tail, slow reach the pre node of node to delete
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;

            return head;
        }
    }

    /**
     * 双指针的哨兵写法
     * <p>
     * 相比于不用哨兵，省去了边界情况n = length 的单独处理逻辑，逻辑可以合并在循环里
     */
    public static class RemoveNthNodeFromEndOfList2 extends RemoveNthNodeFromEndOfList {
        @Override
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // 哨兵头的值不能和链表的合法值冲突，题设里0 <= Node.val <= 100，所以这里随便取的负数
            ListNode dummyHead = new ListNode(-1, head);
            ListNode slow = dummyHead;
            ListNode fast = dummyHead;
            while (n > 0) {
                n--;
                fast = fast.next;
            }

            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return dummyHead.next;
        }
    }

}

