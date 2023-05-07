package com.melchizedek.leet.code.grind.hard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FindLongestValidObsAtEachPosTest {
    @Test
    void test_case_1() {
        int[] obstacles = { 1, 2, 3, 2 };

        int[] result = longestObstacleCourseAtEachPosition(obstacles);

        int[] expected = { 1, 2, 3, 3 };

        assertArrayEquals(expected, result);
    }

    @Test
    void test_case_2() {
        int[] obstacles = { 3,1,5,6,4,2 };

        int[] result = longestObstacleCourseAtEachPosition(obstacles);

        int[] expected = { 1,1,2,3,2,2 };

        assertArrayEquals(expected, result);
    }

    private int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        List<Integer> result = new ArrayList<>();
        List<Integer> stk = new ArrayList<>();

        for (int x : obstacles) {
            int i = upperBound(stk, x);
            result.add(i + 1);
            if (i == stk.size()) {
                stk.add(x);
            } else {
                stk.set(i, x);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    private int upperBound(List<Integer> stk, int target) {
        int left = 0;
        int right = stk.size();

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (stk.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
