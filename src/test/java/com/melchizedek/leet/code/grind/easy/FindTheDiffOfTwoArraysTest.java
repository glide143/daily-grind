package com.melchizedek.leet.code.grind.easy;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindTheDiffOfTwoArraysTest {

    @Test
    void test_case_1() {
        int[] num1 = { 1, 2, 3 };
        int[] num2 = { 2, 4, 6 };

        List<List<Integer>> results = findDifference(num1, num2);

        List<List<Integer>> expected = Arrays.asList(Arrays.asList(1, 3), Arrays.asList(4, 6));

        assertEquals(expected, results);
    }

    @Test
    void test_case_2() {
        int[] num1 = { 1, 2, 3, 3 };
        int[] num2 = { 1, 1, 2, 2 };

        List<List<Integer>> results = findDifference(num1, num2);

        List<List<Integer>> expected = Arrays.asList(List.of(3), Collections.emptyList());

        assertEquals(expected, results);
    }

    private List<List<Integer>> findDifference(int[] num1, int[] num2) {
        Objects.requireNonNull(num1);
        Objects.requireNonNull(num2);

        List<List<Integer>> results = new ArrayList<>();
        if (num1.length == 0) {
            results.add(arraysToList(num2));
            results.add(Collections.emptyList());
            return results;
        }

        if (num2.length == 0) {
            results.add(arraysToList(num1));
            results.add(Collections.emptyList());
            return results;
        }

        Set<Integer> numSet1 = new HashSet<>(arraysToList(num1));
        Set<Integer> numSet2 = new HashSet<>(arraysToList(num2));

        results.add(findDiff(numSet1, numSet2));
        results.add(findDiff(numSet2, numSet1));

        return results;
    }

    private List<Integer> arraysToList(int[] numbers) {
        List<Integer> output = new ArrayList<>();
        for (int number : numbers) {
            output.add(number);
        }
        return output;
    }

    private List<Integer> findDiff(Set<Integer> setOfNumbers1, Set<Integer> setOfNumbers2) {
        List<Integer> result = new ArrayList<>();
        for (Integer e : setOfNumbers1) {
            if (!setOfNumbers2.contains(e)) {
                result.add(e);
            }
        }

        return result;
    }

}
