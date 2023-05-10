package com.melchizedek.leet.code.grind.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpiralMatrixTwoTest {

    @Test
    void test_case_1() {
        int n = 3;

        int[][] result = generateMatrix(n);

        int[][] expected = {
                { 1, 2, 3 },
                { 8, 9, 4 },
                { 7, 6, 5 }
        };

        assertTrue(Arrays.deepEquals(expected, result));
    }

    @Test
    void test_case_2() {
        int n = 1;

        int[][] result = generateMatrix(n);

        int[][] expected = { { 1 } };

        assertTrue(Arrays.deepEquals(expected, result));
    }

    private int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[0][0];
        }

        int[][] matrix = new int[n][n];
        int count = 1;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;

        while (left <= right && top <= bottom) {

            // to right
            for (int col = left; col <= right; col++) {
                matrix[top][col] = count++;
            }

            // To down
            for (int row = top + 1; row <= bottom - 1; row++) {
                matrix[row][right] = count++;
            }

            //To left
            if (top < bottom) {
                for (int col = right; col >= left; col--) {
                    matrix[bottom][col] = count++;
                }
            }

            //To up
            if (left < right) {
                for (int row = bottom - 1; row >= top + 1; row--) {
                    matrix[row][left] = count++;
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }

        return matrix;

    }
}
