package com.melchizedek.leet.code.grind.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UncrossedLinesTest {
    @Test
    void test_case_1() {
        int[] nums1 = { 1, 4, 2 };

        int[] nums2 = { 1, 2, 4 };

        int result = maxUncrossedLines(nums1, nums2);

        assertEquals(2, result);
    }

    @Test
    void test_case_2() {
        int[] nums1 = { 2, 5, 1, 2, 5 };

        int[] nums2 = { 10, 5, 2, 1, 5, 2 };

        int result = maxUncrossedLines(nums1, nums2);

        assertEquals(3, result);
    }

    @Test
    void test_case_3() {
        int[] nums1 = { 1, 3, 7, 1, 7, 5 };

        int[] nums2 = { 1, 9, 2, 5, 1 };

        int result = maxUncrossedLines(nums1, nums2);

        assertEquals(2, result);
    }

    private int maxUncrossedLines(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return 0;
        }

        if (nums1.length < nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int nums2Length = nums2.length;

        int[] holder = new int[nums2Length + 1];

        for (int num1 : nums1) {
            int prev = 0;

            for (int j = 1; j <= nums2Length; j++) {
                int curr = holder[j];

                if (num1 == nums2[j - 1]) {
                    holder[j] = prev + 1;
                } else {
                    holder[j] = Math.max(holder[j - 1], curr);
                }
                prev = curr;
            }
        }

        return holder[nums2Length];
    }
}
