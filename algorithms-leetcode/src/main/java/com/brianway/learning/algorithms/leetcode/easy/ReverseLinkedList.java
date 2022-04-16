package com.brianway.learning.algorithms.leetcode.easy;

import com.brianway.learning.algorithms.leetcode.common.ListNode;

/**
 * LeetCode 206. Reverse Linked List
 * Question: https://leetcode.com/problems/reverse-linked-list/
 * 关键题设：reverse
 *
 * @auther brian
 * @since 2022/4/16 14:10
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        return null;
    }

    /**
     * 不使用哨兵节点，写法1
     * 边界情况没能统一到循环中，写法不够优雅简洁
     * <p>
     * 需要三个临时变量，分别指向当前节点以及其前的后相邻节点，分别是cur,pre,next
     * <p>
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public static class ReverseLinkedList0 extends ReverseLinkedList {
        @Override
        public ListNode reverseList(ListNode head) {
            // 至少需要两个非空节点才好写统一的逻辑
            // 应该是 if(head == null)  和 if(head.next == null) 分别讨论
            // 碰巧返回值一样，所以合并了
            if (head == null || head.next == null) {
                return head;
            }

            ListNode pre = null;
            ListNode cur = head;
            // next变量定义在循环外
            ListNode next = head.next;
            while (next != null) {
                cur.next = pre;

                // 全部指针往后移动一个节点
                pre = cur;
                cur = next; // 注意，此时新的cur的next指针并没有被设置
                next = cur.next;
            }

            // next=null退出循环，说明cur是尾节点，需要指向pre才最终完成反转
            cur.next = pre;
            return cur;
        }

    }

    /**
     * 【推荐】
     * 不使用哨兵节点，写法2
     * 边界情况可以纳入while里，无需单独处理，较简洁
     * <p>
     * 需要三个临时变量，分别指向当前节点以及其前的后相邻节点，分别是cur,pre,next
     * 主要使用cur和pre，next只是临时保存cur的后继节点
     * <p>
     * 注意下起止条件:
     * pre是head前的null起，tail结束
     * cur是head起，tail后的null结束
     * <p>
     * 过程演示：
     * 1) (null->) n1->n2->n3->n4,
     * - 1.1) 当 pre=null, cur=n1，令 tmpNext = n2 // 对应 tmpNext = cur.next;
     * - 1.2) 反转cur：令n1.next=pre 即 null<-n1  n2->n3->n4  // 对应cur.next = pre;
     * - 1.3) pre,cur向前挪动， 即 pre=n1, cur=n2 // 对应 pre = cur; cur = tmpNext;
     * 2) 同上，操作完后，依次变成
     * null<-n1<-n2 n3->n4，此时pre=n2, cur=n3
     * null<-n1<-n2<-n3 n4, 此时pre=n3, cur=n4
     * 3）直至
     * null<-n1<-n2<-n3<-n4 null, 此时pre=n4, cur=null
     * <p>
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public static class ReverseLinkedList1 extends ReverseLinkedList {
        @Override
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            // 这个命名主要是用于强调next仅在while中用于临时保存cur的后继节点
            ListNode tmpNext;
            while (cur != null) {
                // 临时&提前保存cur的后继节点的引用，避免后续修改cur.next指针时丢失
                tmpNext = cur.next;

                //reverse
                cur.next = pre;

                // pre和cur向后移动
                pre = cur;
                cur = tmpNext;
            }

            return pre;
        }
    }

    /**
     * 不使用哨兵节点，写法3 (有点绕，不推荐)
     * <p>
     * 原链表的头结点就是反转之后链表的尾结点，使用 head 标记.
     * 定义指针 cur，初始化为 head.
     * 每次都让 head 下一个结点（需非空）的next指向 cur ，实现一次局部反转
     * <p>
     * 注意：
     * head.next 并不能用 变量 ListNode tmpNext = head.next 代替
     * 因为循环中的 head.next = to 修改的是head节点的next指针
     * 而假如改为 tmpNext=to，则是将tmpNext指向to, 并未修改head节点的next指针，原理同"行参/实参的传递"
     * <p>
     * 过程演示：
     * 1) n1->n2->n3->n4, 此时head=n1,cur=n1
     * - 1.1)
     * n1->n2->n3->n4,  head=n1,cur=n1,to=n3 // 对应 to = head.next.next;
     * - 1.2)
     * n1<=>n2 n3->n4,  head=n1,cur=n1,to=n3 // 对应 head.next.next = cur;
     * - 1.3)
     * n1<=>n2 n3->n4,  head=n1,cur=n2,to=n3 // 对应 cur = head.next;
     * - 1.4)
     * n1<-n2 n3->n4,   head=n1,cur=n2,to=n3  // 对应head.next = to;
     * |______⬆
     * - 2)
     * - 2.1)
     * n1<-n2 n3->n4,   head=n1,cur=n2,to=n4  // to = head.next.next;
     * |______⬆
     * - 2.2)
     * n1<-n2<-n3 n4,   head=n1,cur=n2,to=n4 // 对应 head.next.next = cur;
     * |_______⬆
     * - 2.3)
     * n1<-n2<-n3 n4,   head=n1,cur=n3,to=n4 // 对应 cur = head.next;
     * |_______⬆
     * - 2.4)
     * n1<-n2<-n3 n4,   head=n1,cur=n3,to=n4  // 对应head.next = to;
     * |__________⬆
     * 3)
     * n1<-n2<-n3<-n4 null,   head=n1,cur=n2,to=null  // 对应head.next = to;
     * |_______________⬆
     * 参考：https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-shuang-zhi-zhen-di-gui-yao-mo-/
     */
    public static class ReverseLinkedList3 extends ReverseLinkedList {
        @Override
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode cur = head;
            ListNode to;
            while (head.next != null) {
                // 预存head 下一个结点（非空）的 下一节点
                to = head.next.next;
                head.next.next = cur;
                // cur往后挪一个, head的next指针也往后挪一个（挪到结尾就是null）
                cur = head.next;
                head.next = to;
            }
            return cur;
        }

    }

    /**
     * 使用哨兵节点
     * // TODO
     */
    public static class ReverseLinkedList4 extends ReverseLinkedList {
        @Override
        public ListNode reverseList(ListNode head) {
            return null;
        }

    }

    /**
     * 递归实现
     * <p>
     * 例子：n1->n2->n3->n4
     * 反转n2->n3->n4子链表后，返回的头节点是n4，整个链表状态是n1->n2<-n3<-n4
     * <p>
     * 注意：
     * 1.因为reverseList只会改变其头节点的next指针(to方向)，不会改变指向头节点的指针（from方向）。
     * 所以n1->n2的指针，在反转n2->n3子链表后并不会变，利用这个特性可以快速得到反转后的尾节点，而无需遍历
     * 2.除了利用上述特性将当前节点拼在反转后的尾节点之外，还需要将当前节点的next指null，
     * 否则就有环了,整个链表状态将是 n1<=>n2<-n3<-n4
     * <p>
     * 实现参考：https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode-solution-d1k2/
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)，空间复杂度主要取决于递归调用的栈空间，最多为 n 层。
     */
    public static class ReverseLinkedList5 extends ReverseLinkedList {
        @Override
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode newHead = reverseList(head.next);
            // head.next is the tail of newHead's linked list，记为nTail
            // 操作的是nTail的next指向（nTail.next=head），而不是head的指向，此时head还是指向为尾节点的
            head.next.next = head;
            // 避免成环
            head.next = null;
            return newHead;
        }

    }

}
