package com.melchizedek.leet.code.grind.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumOfProvinceTest {

    @Test
    void test_case_1() {
        int[][] isConnected = {
                { 1, 1, 0 },
                { 1, 1, 0 },
                { 0, 0, 1 }
        };

        int result = findCircleNum(isConnected);

        assertEquals(2, result);
    }
    @Test
    void test_case_2() {
        int[][] isConnected = {
                { 1, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 1 }
        };

        int result = findCircleNum(isConnected);

        assertEquals(3, result);
    }

    private int findCircleNum(int[][] isConnected) {
        Map<Integer, Set<Integer>> pinPoints = new HashMap<>();

        for (int row = 0; row < isConnected.length; row++) {
            for (int col = 0; col < isConnected[row].length; col++) {
                if(isConnected[row][col] == 1 && row != col) {
                    pinPoints.computeIfAbsent(row, val -> new HashSet<>()).add(col);
                    pinPoints.computeIfAbsent(col, val -> new HashSet<>()).add(row);
                }
            }
        }

        Set<Integer> visited = new HashSet<>();
        int totalConnected = 0;

        for (int city = 0; city < isConnected.length; city++) {
            if (!visited.contains(city)) {
                traverse(pinPoints, city, visited);
                totalConnected++;
            }
        }
        return totalConnected;
    }

    private void traverse(Map<Integer, Set<Integer>> pinPoints, int city, Set<Integer> visited) {
        visited.add(city);

        for (int neighbor : pinPoints.getOrDefault(city, new HashSet<>())) {
            if (!visited.contains(neighbor)) {
                traverse(pinPoints, neighbor, visited);
            }
        }
    }
}
