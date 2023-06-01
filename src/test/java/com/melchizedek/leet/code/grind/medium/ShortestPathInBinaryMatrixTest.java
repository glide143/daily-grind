package com.melchizedek.leet.code.grind.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShortestPathInBinaryMatrixTest {

    @Test
    void test_case_1() {
        int[][] grid = {
                { 0, 1 },
                { 1, 0 }
        };

        int result = shortestPathBinaryMatrix(grid);

        assertEquals(2, result);
    }

    @Test
    void test_case_2() {
        int[][] grid = {
                { 0, 0, 0 },
                { 1, 1, 0 },
                { 1, 1, 0 }
        };

        int result = shortestPathBinaryMatrix(grid);

        assertEquals(4, result);
    }

    @Test
    void test_case_3() {
        int[][] grid = {
                { 1, 0, 0 },
                { 1, 1, 0 },
                { 1, 1, 0 }
        };

        int result = shortestPathBinaryMatrix(grid);

        assertEquals(-1, result);
    }

    private int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }

        int n = grid.length;
        grid[0][0] = 1;

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { 0, 0 });

        for (int distance = 1; !queue.isEmpty(); distance++) {
            int levelSize = queue.size();

            for (int count = 0; count < levelSize; count++) {
                int[] point = queue.poll();
                int row = point[0];
                int col = point[1];

                if (row == n - 1 && col == n - 1) {
                    return distance;
                }

                for (int x = row - 1; x <= row + 1; x++) {
                    for (int y = col - 1; y <= col + 1; y++) {
                        if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0) {
                            grid[x][y] = 1;
                            queue.offer(new int[] { x, y });
                        }
                    }
                }
            }
        }

        return -1;
    }

}
