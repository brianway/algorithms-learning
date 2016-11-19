package com.brianway.learning.algorithms.lectures.linkedlist;

/**
 * Created by brian on 16/11/14.
 *
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）。
 */
public class CopyList {
    private static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }

    }

    public RandomListNode clone(RandomListNode pHead) {
        RandomListNode current = pHead;
        RandomListNode copy = null;
        while (current != null) {
            copy = cloneNode(current);
            current.next = copy;
            current = copy.next;
        }
        current = pHead;
        while (current != null) {
            copy = current.next;
            copy.random = copy.random == null ? null : copy.random.next;
            current = copy.next;
        }

        RandomListNode copyHead = (pHead == null ? null : pHead.next);
        current = pHead;
        while (current != null) {
            copy = current.next;
            current.next = copy.next;
            copy.next = (copy.next == null ? null : copy.next.next);
            current = current.next;
        }

        return copyHead;

    }

    private RandomListNode cloneNode(RandomListNode p) {
        RandomListNode node = new RandomListNode(p.label);
        node.next = p.next;
        node.random = p.random;
        return node;
    }

    public static void main(String[] args) {
        RandomListNode n1 = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(3);
        RandomListNode n4 = new RandomListNode(4);

        n1.next = n2; n1.random = n3;
        n2.next = n3; n2.random = null;
        n3.next = n4; n3.random = n2;
        n4.next = null; n4.random = n1;

        CopyList cl = new CopyList();
        RandomListNode cHead = cl.clone(n1);

        while (cHead != null) {
            System.out.print(cHead.label + ",");
            cHead = cHead.next;
        }
        System.out.println();
    }

}
