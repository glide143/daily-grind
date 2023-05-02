package com.melchizedek.leet.code.grind.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddDigitsTest {

    @Test
    void test_case_1() {
        int result = addDigits(38);
        assertEquals(2, result);
    }
    @Test
    void test_case_2() {
        int result = addDigits(0);
        assertEquals(0, result);
    }

    private int addDigits(int num) {
        if (num / 10 == 0) {
            return num;
        }
        int digitSum = 0;
        while (num > 0) {
            digitSum += num % 10;
            num /= 10;
        }
        return addDigits(digitSum);
    }
}
