import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SignOfTheProductOfAnArrayTest {

    @Test
    void test_case_1() {
        int[] input = { -1, -2, -3, -4, 3, 2, 1 };

        int result = arraySign(input);

        assertEquals(1, result);
    }

    @Test
    void test_case_2() {
        int[] input = { 1, 5, 0, 2, -3 };

        int result = arraySign(input);

        assertEquals(0, result);
    }

    @Test
    void test_case_3() {
        int[] input = { -1, 1, -1, 1, -1 };

        int result = arraySign(input);

        assertEquals(-1, result);
    }

    private int arraySign(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                return 0;
            }
            result += nums[i] < 0 ? 1 : 0;
        }
        return result % 2 == 0 ? 1 : -1;
    }

}
