package com.melchizedek.leet.code.grind.medium;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Dota2SenateTest {

    @Test
    void test_case_1() {
        String input = "RD";

        String result = predictPartyVictory(input);

        assertEquals("Radiant", result);
    }

    @Test
    void test_case_2() {
        String input = "RDD";

        String result = predictPartyVictory(input);

        assertEquals("Dire", result);
    }

    @Test
    void test_case_3() {
        String input = "RDRDRDRDR";

        String result = predictPartyVictory(input);

        assertEquals("Radiant", result);
    }

    private String predictPartyVictory(String senate) {
        if (senate.isBlank()) {
            return "";
        }

        int length = senate.length();
        Deque<Integer> radiantSenate = new LinkedList<>();
        Deque<Integer> direSenate = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            if (senate.charAt(i) == 'R') {
                radiantSenate.add(i);
            } else {
                direSenate.add(i);
            }
        }

        while (!radiantSenate.isEmpty() && !direSenate.isEmpty()) {
            int radiantElement = radiantSenate.pollFirst();
            int direElement = direSenate.pollFirst();

            if (radiantElement < direElement) {
                radiantSenate.add(radiantElement + length);
            } else {
                direSenate.add(direElement + length);
            }
        }

        return radiantSenate.size() > direSenate.size() ? "Radiant" : "Dire";

    }
}
