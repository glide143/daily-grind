package com.melchizedek.leet.code.grind.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SummaryRangesTest {

    @Test
    void test_case_1() {
        int[] nums = { 0, 1, 2, 4, 5, 7 };

        List<String> results = summaryRanges(nums);

        assertEquals(Arrays.asList("0->2", "4->5", "7"), results);
    }

    @Test
    void test_case_2() {
        int[] nums = { 0, 2, 3, 4, 6, 8, 9 };

        List<String> results = summaryRanges(nums);

        assertEquals(Arrays.asList("0", "2->4", "6", "8->9"), results);
    }

    private List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < nums.length) {
            int start = nums[index++];
            int end = start;
            while (index < nums.length && (nums[index] - end) == 1) {
                end = nums[index++];
            }
            if (start == end) {
                result.add(Integer.toString(start));
            } else {
                result.add(start + "->" + end);
            }
        }

        return result;
    }

}
