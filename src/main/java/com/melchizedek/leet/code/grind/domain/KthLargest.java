package com.melchizedek.leet.code.grind.domain;

import java.util.PriorityQueue;

public class KthLargest {
    private final int k;
    private final PriorityQueue<Integer> queue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>(k);

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        queue.offer(val);

        if (queue.size() > k) {
            queue.poll();
        }

        return queue.peek();
    }
}
