package com.melchizedek.leet.code.grind.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumOfSubSatisfyGivenSumCondiTest {
    @Test
    void test_case_1() {
        int nums [] = { 3, 5, 6, 7 };

        int target = 9;

        int result = numSubseq(nums, target);
        
        assertEquals(4, result);
    }

    @Test
    void test_case_2() {
        int nums [] = { 3,3,6,8 };

        int target = 10;

        int result = numSubseq(nums, target);

        assertEquals(6, result);
    }

    @Test
    void test_case_3() {
        int nums [] = { 2,3,3,4,6,7 };

        int target = 12;

        int result = numSubseq(nums, target);

        assertEquals(61, result);
    }

    private int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        final int MOD = 1000_000_007;
        int n = nums.length;
        int result = 0;
        int left = 0, right = n - 1;

        int[] pows = new int[n];
        pows[0] = 1;
        for (int i = 1; i < n; ++i) {
            pows[i] = pows[i - 1] * 2 % MOD;
        }

        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                result += pows[right - left] % MOD;
                result %= MOD;
                left++;
            }
        }

        return result;

    }


}
