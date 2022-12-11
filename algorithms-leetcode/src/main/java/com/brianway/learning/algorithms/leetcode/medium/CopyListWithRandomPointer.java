package com.brianway.learning.algorithms.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 138. Copy List with Random Pointer
 * Question: https://leetcode.com/problems/copy-list-with-random-pointer/
 * 关键题设：None of the pointers in the new list should point to nodes in the original list.
 *
 * @auther brian
 * @since 2022/12/11 19:47
 */
public class CopyListWithRandomPointer {

    // Definition for a Node.
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 哈希表，key:老节点，value: 新节点
     * <p>
     * 时间复杂度 O(n), 遍历两遍
     * 空间复杂度 O(n)，额外的哈希表
     */
    class Solution {
        public Node copyRandomList(Node head) {
            Map<Node, Node> oldToNew = new HashMap<>();
            Node cur = head;
            while (cur != null) {
                Node copyOfCur = new Node(cur.val);
                oldToNew.put(cur, copyOfCur);
                cur = cur.next;
            }
            cur = head;
            while (cur != null) {
                Node copyOfCur = oldToNew.get(cur);
                Node copyOfNext = oldToNew.get(cur.next);
                Node copyOfRandom = oldToNew.get(cur.random);
                copyOfCur.next = copyOfNext;
                copyOfCur.random = copyOfRandom;
                cur = cur.next;
            }

            return oldToNew.get(head);

        }
    }

    // TODO 不使用额外空间的解法

}
