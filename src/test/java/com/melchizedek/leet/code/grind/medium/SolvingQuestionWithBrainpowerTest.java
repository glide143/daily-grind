package com.melchizedek.leet.code.grind.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolvingQuestionWithBrainpowerTest {

    @Test
    void test_case_1() {
        int[][] questions = {
                { 3, 2 },
                { 4, 3 },
                { 4, 4 },
                { 2, 5 }
        };

        long result = mostPoints(questions);

        assertEquals(5L, result);
    }

    @Test
    void test_case_2() {
        int[][] questions = {
                { 1, 1 },
                { 2, 2 },
                { 3, 3 },
                { 4, 4 },
                { 5, 5 }
        };

        long result = mostPoints(questions);

        assertEquals(7L, result);
    }

    private long mostPoints(int[][] questions) {
        int length = questions.length;
        long[] dp = new long[length + 1];

        for (int i = length - 1; i >= 0; i--) {
            int jump = questions[i][1];
            int point = questions[i][0];

            int nextQuestion = Math.min(i + jump + 1, length);
            long skip = dp[i + 1];

            dp[i] = Math.max(skip, point + dp[nextQuestion]);
        }
        return dp[0];
    }
}
