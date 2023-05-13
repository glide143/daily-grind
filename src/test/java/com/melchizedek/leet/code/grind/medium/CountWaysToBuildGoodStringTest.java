package com.melchizedek.leet.code.grind.medium;

import org.junit.jupiter.api.Test;

import static com.melchizedek.leet.code.grind.util.LeetCodeUtils.MOD;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountWaysToBuildGoodStringTest {
    @Test
    void test_case_1() {
        int low = 3, high = 3, zero = 1, one = 1;

        int result = countGoodStrings(low, high, zero, one);
        assertEquals(8, result);
    }

    @Test
    void test_case_2() {
        int low = 2, high = 3, zero = 1, one = 2;

        int result = countGoodStrings(low, high, zero, one);
        assertEquals(5, result);
    }

    private int countGoodStrings(int low, int high, int zero, int one) {
        long[] holder = new long[high + 1];
        holder[0] = 1;
        long ans = 0;
        final int MOD = 1000_000_007;
        for (int i = 1; i <= high; i++) {

            if (i - zero >= 0) {
                holder[i] = (holder[i] + holder[i - zero]) % MOD;
            }

            if (i - one >= 0) {
                holder[i] = (holder[i] + holder[i - one]) % MOD;
            }

            if (i >= low && i <= high) {
                ans = (ans + holder[i]) % MOD;
            }
        }

        return (int) ans;

    }
}
