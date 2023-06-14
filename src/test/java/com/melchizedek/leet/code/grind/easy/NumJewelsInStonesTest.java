package com.melchizedek.leet.code.grind.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumJewelsInStonesTest {
    @Test
    void test_case_1() {
        String jewels = "aA", stones = "aAAbbbb";

        int results = numJewelsInStones(jewels,stones);

        assertEquals(3, results);
    }

    @Test
    void test_case_2() {
        String jewels = "z", stones = "ZZ";

        int results = numJewelsInStones(jewels,stones);

        assertEquals(0, results);
    }

    private int numJewelsInStones(String jewels, String stones) {
        int result = 0;
        for (char jewel : jewels.toCharArray()) {
            for (char stone : stones.toCharArray()) {
                if (jewel == stone) {
                    result++;
                }
            }
        }

        return result;
    }
}
