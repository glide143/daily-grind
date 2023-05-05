package com.melchizedek.leet.code.grind.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxNumOfVowelsInASubStringTest {

    @Test
    void test_case_1() {
        String s = "abciiidef";

        int k = 3;

        int result = maxVowels(s, k);

        assertEquals(3, result);
    }

    @Test
    void test_case_2() {
        String s = "aeiou";

        int k = 2;

        int result = maxVowels(s, k);

        assertEquals(2, result);
    }

    @Test
    void test_case_3() {
        String s = "leetcode";

        int k = 3;

        int result = maxVowels(s, k);

        assertEquals(2, result);
    }

    private int maxVowels(String s, int k) {
        int currentCount = 0;
        int maxVowel = 0;

        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                currentCount++;
            }

            if (i >= k) {
                if (isVowel(s.charAt(i - k))) {
                    currentCount--;
                }
            }
            maxVowel = Math.max(maxVowel, currentCount);

            if (maxVowel == k) {
                return maxVowel;
            }
        }

        return maxVowel;

    }

    private boolean isVowel(char c) {
        switch (c) {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
            return true;
        default:
            return false;
        }
    }

}
