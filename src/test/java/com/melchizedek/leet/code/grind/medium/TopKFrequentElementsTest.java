package com.melchizedek.leet.code.grind.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TopKFrequentElementsTest {

    @Test
    void test_case_1() {
        int[] nums = { 1, 1, 1, 2, 2, 3 };

        int k = 2;

        int[] result = topKFrequent(nums, k);

        assertArrayEquals(new int[] { 1, 2 }, result);
    }

    @Test
    void test_case_2() {
        int[] nums = { 1 };

        int k = 1;

        int[] result = topKFrequent(nums, k);

        assertArrayEquals(new int[] { 1 }, result);
    }

    private int[] topKFrequent(int[] nums, int k) {
        if (nums.length == k) {
            return nums;
        }

        int[] result = new int[k];

        Map<Integer, Integer> holder = new HashMap<>();

        for (int num : nums) {
            holder.put(num, holder.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> holder.get(b) - holder.get(a));
        for (int num : holder.keySet()) {
            heap.offer(num);
        }

        for (int i = 0; i < k; i++) {
            result[i] = Optional.ofNullable(heap.poll())
                                .orElse(0);
        }

        return result;
    }
}
