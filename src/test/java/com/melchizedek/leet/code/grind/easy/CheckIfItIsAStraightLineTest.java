package com.melchizedek.leet.code.grind.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CheckIfItIsAStraightLineTest {
    @Test
    void test_case_1() {
        int[][] coordinates = {
                { 1, 2 },
                { 2, 3 },
                { 3, 4 },
                { 4, 5 },
                { 5, 6 },
                { 6, 7 },
        };

        boolean result = checkStraightLine(coordinates);

        assertTrue(result);
    }

    @Test
    void test_case_2() {
        int[][] coordinates = {
                { 1, 1 },
                { 2, 2 },
                { 3, 4 },
                { 4, 5 },
                { 5, 6 },
                { 6, 7 },
        };

        boolean result = checkStraightLine(coordinates);

        assertFalse(result);
    }

    private boolean checkStraightLine(int[][] coordinates) {

        // Get the slope of the first two points.
        int firstRise = coordinates[1][1] - coordinates[0][1];
        int firstRun = coordinates[1][0] - coordinates[0][0];

        for (int row = 1; row < coordinates.length; row++) {
            int currentRun = coordinates[row][0] - coordinates[row-1][0];
            int currentRise = coordinates[row][1] - coordinates[row-1][1];

            // For each pair of consecutive points, check if their slopes are not equal.
            if (currentRise * firstRun != currentRun * firstRise) {
                return false;
            }
        }

        return true;
    }
}
