package com.melchizedek.leet.code.grind.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FinalValueAfterOperationsTest {

    @Test
    void test_case_1() {
        String[] operations = {"--X","X++","X++"};

        int results = finalValueAfterOperations(operations);

        assertEquals(1, results);
    }

    private int finalValueAfterOperations(String[] operations) {
        int result = 0;

        for (String operation : operations) {
            result += operation.charAt(1) == '+' ? 1 : -1;
        }

        return result;
    }

}
