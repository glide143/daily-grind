package com.melchizedek.leet.code.grind.medium;

import com.melchizedek.leet.code.grind.domain.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxTwinSumOfALinkedListTest {

    @Test
    void test_case_1() {
        ListNode listNode4 = new ListNode(1);
        ListNode listNode3 = new ListNode(2, listNode4);
        ListNode listNode2 = new ListNode(4, listNode3);
        ListNode listNode1 = new ListNode(5, listNode2);

        int result = pairSum(listNode1);

        assertEquals(6, result);
    }

    @Test
    void test_case_2() {
        ListNode listNode4 = new ListNode(3);
        ListNode listNode3 = new ListNode(2, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(4, listNode2);

        int result = pairSum(listNode1);

        assertEquals(7, result);
    }

    @Test
    void test_case_3() {
        ListNode listNode2 = new ListNode(100_000);
        ListNode listNode1 = new ListNode(1, listNode2);

        int result = pairSum(listNode1);

        assertEquals(100_001, result);
    }

    private int pairSum(ListNode head) {
        List<Integer> values = new ArrayList<>();

        for (ListNode node = head; node != null; node = node.next) {
            values.add(node.val);
        }

        int maxSum = 0;
        int size = values.size();

        for (int i = 0; i < size / 2; i++) {
            int currentSum = values.get(i) + values.get(size - 1 - i);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
