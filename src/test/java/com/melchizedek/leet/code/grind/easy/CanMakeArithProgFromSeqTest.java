package com.melchizedek.leet.code.grind.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CanMakeArithProgFromSeqTest {
    @Test
    void test_case_1() {
        int[] arr = { 3, 5, 1 };

        boolean result = canMakeArithmeticProgression(arr);

        assertTrue(result);
    }

    @Test
    void test_case_2() {
        int[] arr = { 1, 2, 4 };

        boolean result = canMakeArithmeticProgression(arr);

        assertFalse(result);
    }

    private boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);

        int diffOfSecAndFirst = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {

            if (arr[i] - arr[i - 1] != diffOfSecAndFirst) {
                return false;
            }
        }

        return true;
    }
}
