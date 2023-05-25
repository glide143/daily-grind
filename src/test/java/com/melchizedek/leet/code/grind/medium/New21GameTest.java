package com.melchizedek.leet.code.grind.medium;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class New21GameTest {

    @Test
    void test_case_1() {
        int n = 10, k = 1, maxPts = 10;

        double result = new21Game(n, k, maxPts);

        assertEquals(1.0, result);
    }

    @Test
    void test_case_2() {
        int n = 6, k = 1, maxPts = 10;

        double result = new21Game(n, k, maxPts);

        assertEquals(0.60000, result);
    }

    @Test
    void test_case_3() {
        int n = 21, k = 17, maxPts = 10;

        double result = new21Game(n, k, maxPts);

        assertEquals(0.73278, result);
    }

    private double new21Game(int n, int k, int maxPts) {
        // using BigDecimal
        if (k == 0 || k - 1 + maxPts <= n) {
            return 1;
        }

        if (n < k) {
            return 0;
        }
        BigDecimal[] holder = new BigDecimal[n + 1];
        holder[0] = BigDecimal.ONE;

        BigDecimal sum = BigDecimal.ONE;
        BigDecimal result = BigDecimal.ZERO;

        for (int i = 1; i <= n; i++) {

            holder[i] = sum.divide(BigDecimal.valueOf(maxPts),5, RoundingMode.HALF_UP);

            if (i < k) {
                sum = sum.add(holder[i]);
            } else {
                result = result.add(holder[i]);
            }

            if (i - maxPts >= 0) {
                sum = sum.subtract(holder[i - maxPts]);
            }
        }

        return result.doubleValue();

    // Using double
//        double[] holder = new double[n + 1];
//        holder[0] = 1.0;
//
//        double sum = 1.0;
//        double result = 0.0;
//
//        for (int i = 1; i <= n ; i++) {
//            holder[i] = sum / maxPts;
//
//            if (i < k) {
//                sum += holder[i];
//            } else {
//                result += holder[i];
//            }
//
//            if (i - maxPts >= 0) {
//                sum -= holder[i - maxPts];
//            }
//        }
//        return (double)Math.round(result * 100000d) / 100000d;

    }
}
