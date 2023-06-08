package com.melchizedek.leet.code.grind.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountNegativeNumInASortedMatTest {

    @Test
    void test_case_1() {
        int[][] grid =  { 
                { 4, 3, 2, -1 }, 
                { 3, 2, 1, -1 }, 
                { 1, 1, -1, -2 }, 
                { -1, -1, -2, -3 } 
        } ;

        int result = countNegatives(grid);

        assertEquals(8, result);
    }

@Test
    void test_case_2() {
        int[][] grid =  {
                { 3, 2},
                { 1, 0 }
        } ;

        int result = countNegatives(grid);

        assertEquals(0, result);
    }

    private int countNegatives(int[][] grid) {
        Arrays.sort(grid, Comparator.comparingInt(o -> o[0]));
        int count = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] < 0) {
                    count++;
                }
            }
        }

        return count;

    }
}
