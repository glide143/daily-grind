package com.melchizedek.leet.code.grind.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AveSalaryExcludeMinMaxSalaryTest {


    @Test
    void test_case_1() {
        int[] input = { 4_000,3_000,1_000,2_000 };

        double result = average(input);

        assertEquals(2500.0000, result);
    }

    @Test
    void test_case_2() {
        int[] input = { 1_000,2_000,3_000};

        double result = average(input);

        assertEquals(2000.00000, result);
    }


    private double average(int[] salary) {
        int length = salary.length;
        if (length == 0) {
            return 0;
        }

        int minSalary = salary[0];
        int maxSalary = salary[0];

        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += salary[i];
            minSalary = Math.min(minSalary, salary[i]);
            maxSalary = Math.max(maxSalary, salary[i]);
        }
        sum -= maxSalary + minSalary;
        return ((double) sum) / (length - 2);
    }

}
