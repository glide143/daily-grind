package com.melchizedek.leet.code.grind.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BulbSwitcherTest {

    @Test
    void test_case_1() {
        int result = bulbSwitch(3);
        assertEquals(1, result);
    }
    @Test
    void test_case_2() {
        int result = bulbSwitch(0);
        assertEquals(0, result);
    }
    @Test
    void test_case_3() {
        int result = bulbSwitch(1);
        assertEquals(1, result);
    }

    private int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
