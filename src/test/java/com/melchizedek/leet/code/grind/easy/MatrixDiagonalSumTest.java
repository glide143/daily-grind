package com.melchizedek.leet.code.grind.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatrixDiagonalSumTest {

    @Test
    void test_case_1() {
        int[][] mat = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int result = diagonalSum(mat);

        assertEquals(25, result);
    }

    @Test
    void test_case_2() {
        int[][] mat = { { 5 } };

        int result = diagonalSum(mat);
        assertEquals(5, result);
    }

    @Test
    void test_case_3() {
        int[][] mat = {
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 }
        };

        int result = diagonalSum(mat);

        assertEquals(8, result);
    }

    private int diagonalSum(int[][] mat) {
        int matLength = mat.length;

        if (matLength == 1) {
            return mat[0][0];
        }

        int sum = 0;
        for (int row = 0; row < matLength; row++) {
            sum += mat[row][row] + mat[row][matLength - row - 1];
        }

        return sum - (matLength % 2 == 0 ? 0 : mat[matLength / 2][matLength / 2]);
    }
}
