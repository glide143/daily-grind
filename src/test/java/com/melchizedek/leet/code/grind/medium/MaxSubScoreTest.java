package com.melchizedek.leet.code.grind.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxSubScoreTest {
    @Test
    void test_case_1() {
        int[] nums1 = { 1, 3, 3, 2 };

        int[] nums2 = { 2, 1, 3, 4 };

        int k = 3;

        long result = maxScore(nums1, nums2, k);

        assertEquals(12L, result);
    }

    @Test
    void test_case_2() {
        int[] nums1 = { 4, 2, 3, 1, 1 };

        int[] nums2 = { 7, 5, 10, 9, 6 };

        int k = 1;

        long result = maxScore(nums1, nums2, k);

        assertEquals(30L, result);
    }

    private long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];

        for (int i = 0; i < n; ++i) {
            pairs[i] = new int[] { nums1[i], nums2[i] };
        }

        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);
        long ans = 0, sum = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < n; ++i) {
            sum += pairs[i][0];
            q.offer(pairs[i][0]);
            if (q.size() == k) {
                ans = Math.max(ans, sum * pairs[i][1]);
                sum -= q.poll();
            }
        }
        return ans;

    }
}
