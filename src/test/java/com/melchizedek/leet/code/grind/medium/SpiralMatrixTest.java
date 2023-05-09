package com.melchizedek.leet.code.grind.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpiralMatrixTest {

    @Test
    void test_case_1() {
        int[][] mat = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        List<Integer> result = spiralOrder(mat);

        assertEquals(Arrays.asList(1,2,3,6,9,8,7,4,5), result);
    }

    @Test
    void test_case_2() {
        int[][] mat = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };

        List<Integer> result = spiralOrder(mat);

        assertEquals(Arrays.asList(1,2,3,4,8,12,11,10,9,5,6,7), result);
    }

    private List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> results = new ArrayList<>();

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {

            // To right
            for (int r = left; r <= right ; r++) {
                results.add(matrix[top][r]);
            }

            // To down
            for (int d = top + 1; d <= bottom - 1 ; d++) {
                results.add(matrix[d][right]);
            }

            //To left
            if (top < bottom) {
                for (int l = right; l >= left; l--) {
                    results.add(matrix[bottom][l]);
                }
            }

            //To up
            if (left < right) {
                for (int t = bottom - 1; t >= top + 1 ; t--) {
                    results.add(matrix[t][left]);
                }
            }

            left++;
            right--;
            top++;
            bottom--;

        }
        return results;
    }
}
