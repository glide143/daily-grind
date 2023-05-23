package com.melchizedek.leet.code.grind.medium;

import com.melchizedek.leet.code.grind.domain.KthLargest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthLargestTest {

    @Test
    void test_case_1() {
        KthLargest kthLargest = new KthLargest(3, new int[] { 4, 5, 8, 2 });

        assertEquals(4, kthLargest.add(3));
        assertEquals(5, kthLargest.add(5));
        assertEquals(5, kthLargest.add(10));
        assertEquals(8, kthLargest.add(9));
        assertEquals(8, kthLargest.add(4));
    }

}
