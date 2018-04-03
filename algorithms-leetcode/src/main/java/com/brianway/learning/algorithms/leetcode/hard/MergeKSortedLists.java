package com.brianway.learning.algorithms.leetcode.hard;

import com.brianway.learning.algorithms.leetcode.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeetCode 23. Merge k Sorted Lists
 * Question: https://leetcode.com/problems/merge-k-sorted-lists/description/
 * 关键题设： k sorted linked lists
 * TODO 还可以用归并方法
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return null;
    }

    /**
     * 超时了
     * 每词遍历 k 个链表的头节点，选最小的加入新链表
     *
     * 设所有链表节点总数为 N
     * 时间复杂度: O(k*N)
     * 空间复杂度: O(1)
     */
    public class MergeKSortedLists0 extends MergeKSortedLists {
        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1 == null) {
                    return 1;
                }
                if (o2 == null) {
                    return -1;
                }
                return o1.val - o2.val;
            }
        };

        @Override
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }

            ListNode head = null;
            ListNode current = null;
            int minIndex = getMinIndex(lists);
            while (minIndex != -1) {
                if (head == null) {
                    head = lists[minIndex];
                    current = lists[minIndex];
                    lists[minIndex] = lists[minIndex].next;
                    current.next = null;
                } else {
                    current.next = lists[minIndex];
                    current = current.next;
                    lists[minIndex] = lists[minIndex].next;
                    current.next = null;
                }
                minIndex = getMinIndex(lists);
            }
            return head;

        }

        public int getMinIndex(ListNode[] lists) {
            int minIndex = 0;
            for (int i = 1; i < lists.length; i++) {
                if (comparator.compare(lists[minIndex], lists[i]) > 0) {
                    minIndex = i;
                }
            }
            return lists[minIndex] == null ? -1 : minIndex;
        }

    }

    /**
     * 用最小堆
     * 有少许优化，不是在循环里每次判断 head 是否为空，而是先初始化
     *
     * 设所有链表节点总数为 N
     * 时间复杂度: O(N*log k)
     */
    public class MergeKSortedLists1 extends MergeKSortedLists {
        @Override
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }

            PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val - o2.val;
                }
            });
            for (ListNode node : lists) {
                if (node != null) {
                    heap.add(node);
                }
            }

            ListNode head = heap.isEmpty() ? null : heap.poll();
            ListNode current = head;
            while (!heap.isEmpty()) {
                if (current.next != null) {
                    heap.add(current.next);
                }
                current.next = heap.poll();
                current = current.next;
            }
            return head;
        }
    }

}
