package com.melchizedek.leet.code.grind.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IsGraphBipartiteTest {

    @Test
    void test_case_1() {
        int[][] graph = {
                { 1, 2, 3 },
                { 0, 2 },
                { 0, 1, 3 },
                { 0, 2 }
        };

        boolean result = isBipartite(graph);

        assertFalse(result);
    }

    @Test
    void test_case_2() {
        int[][] graph = {
                { 1, 3 },
                { 0, 2 },
                { 1, 3 },
                { 0, 2 }
        };

        boolean result = isBipartite(graph);

        assertTrue(result);
    }

    private boolean isBipartite(int[][] graph) {
        int length = graph.length;
        int[] colors = new int[length];

        for (int i = 0; i < length; i++) {
            if (colors[i] == 0 && !isValidColor(graph, colors, 1, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidColor(int[][] graph, int[] colors, int color, int node) {
        if (colors[node] != 0) {
            return colors[node] == color;
        }

        colors[node] = color;

        for (int next : graph[node]) {
            if (!isValidColor(graph, colors, -color, next)) {
                return false;
            }
        }
        return true;
    }
}
