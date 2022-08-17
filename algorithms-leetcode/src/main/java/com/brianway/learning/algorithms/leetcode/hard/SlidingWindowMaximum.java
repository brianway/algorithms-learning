package com.brianway.learning.algorithms.leetcode.hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * LeetCode 239. Sliding Window Maximum
 * Question: https://leetcode.com/problems/sliding-window-maximum/
 * 关键题设：  无
 *
 * @auther brian
 * @since 2022/8/17 22:52
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        return null;
    }

    /**
     * 单调队列，存元素值
     * <p>
     * 当窗口最后一个元素下标是i时，窗口第一个元素的下标是i-k+1
     * <p>
     * 例如：
     * 移动前，窗口范围 [i-k,i-1]
     * 移出第i-k个元素, 移进第i个元素，窗口范围 [i-k+1,i]
     */
    public class SlidingWindowMaximum0 extends SlidingWindowMaximum {
        @Override
        public int[] maxSlidingWindow(int[] nums, int k) {
            MonotonicQueue mq = new MonotonicQueue();
            int[] result = new int[nums.length - k + 1];
            // 初始化队列
            for (int i = 0; i < k; i++) {
                mq.push(nums[i]);
            }
            result[0] = mq.peek();

            for (int i = k; i < nums.length; i++) {
                mq.poll(nums[i - k]);
                mq.push(nums[i]);
                result[i - k + 1] = mq.peek();
            }

            return result;
        }

        /**
         * 单调队列
         * 队列存元素值
         * 队头->队尾，递减（允许相等）
         */
        public class MonotonicQueue {
            Deque<Integer> deque = new LinkedList<>();

            /**
             * 得到队头的值，的
             *
             * @return 队列中的最大值
             */
            public int peek() {
                return deque.peek();
            }

            /**
             * 将元素val出队，即从队头删除
             *
             * @param val 要出队的元素值
             */
            public void poll(int val) {
                if (!deque.isEmpty() && deque.peek() == val) {
                    deque.poll();
                }
            }

            /**
             * 将元素val入队，即加入队尾
             *
             * @param val 要出队的元素值
             */
            public void push(int val) {
                while (!deque.isEmpty() && deque.getLast() < val) {
                    deque.removeLast();
                }
                deque.addLast(val);
            }
        }
    }
}
