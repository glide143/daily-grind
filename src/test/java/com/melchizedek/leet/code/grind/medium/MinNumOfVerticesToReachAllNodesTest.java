package com.melchizedek.leet.code.grind.medium;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinNumOfVerticesToReachAllNodesTest {

    @Test
    void test_case_1() {
        int n = 6;

        List<List<Integer>> edges = List.of(
                Arrays.asList(0, 1),
                Arrays.asList(0, 2),
                Arrays.asList(2, 5),
                Arrays.asList(3, 4),
                Arrays.asList(4, 2));

        List<Integer> result = findSmallestSetOfVertices(n, edges);

        assertEquals(Arrays.asList(0, 3), result);
    }

    @Test
    void test_case_2() {
        int n = 5;

        List<List<Integer>> edges = List.of(
                Arrays.asList(0, 1),
                Arrays.asList(2, 1),
                Arrays.asList(3, 1),
                Arrays.asList(1, 4),
                Arrays.asList(2, 4));

        List<Integer> result = findSmallestSetOfVertices(n, edges);

        assertEquals(Arrays.asList(0,2,3), result);
    }

    private List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] isDestination = new boolean[n];

        for (List<Integer> edge : edges) {
            int v = edge.get(1);
            isDestination[v] = true;
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!isDestination[i]) {
                result.add(i);
            }
        }

        return result;
    }
}
