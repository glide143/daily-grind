package com.melchizedek.leet.code.grind.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindSmallLetterGreaterThanTargetTest {

    @Test
    void test_case_1() {
        char[] letters = { 'c', 'f', 'j' };

        char target = 'a';

        char result = nextGreatestLetter(letters, target);

        assertEquals('c', result);
    }

    @Test
    void test_case_2() {
        char[] letters = { 'c', 'f', 'j' };

        char target = 'c';

        char result = nextGreatestLetter(letters, target);

        assertEquals('f', result);
    }

    @Test
    void test_case_3() {
        char[] letters = { 'x', 'x', 'y', 'y' };

        char target = 'z';

        char result = nextGreatestLetter(letters, target);

        assertEquals('x', result);
    }

    private char nextGreatestLetter(char[] letters, char target) {
        for (char letter : letters) {
            if (letter > target) {
                return letter;
            }
        }
        return letters[0];

    }
}
