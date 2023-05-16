package com.melchizedek.leet.code.grind.medium;

import com.melchizedek.leet.code.grind.domain.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwapNodeInPairsTest {

    @Test
    void test_case_1() {

        ListNode listNode4 = new ListNode(4);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        ListNode result = swapPairs(listNode1);

        ListNode expected4 = new ListNode(3);
        ListNode expected3 = new ListNode(4, expected4);
        ListNode expected2 = new ListNode(1, expected3);
        ListNode expected1 = new ListNode(2, expected2);

        assertEquals(expected1, result);
    }

    @Test
    void test_case_2() {
        ListNode listNode1 = new ListNode();

        ListNode result = swapPairs(listNode1);

        ListNode expected1 = new ListNode();

        assertEquals(expected1, result);
    }

    @Test
    void test_case_3() {
        ListNode listNode1 = new ListNode(1);

        ListNode result = swapPairs(listNode1);

        ListNode expected1 = new ListNode(1);

        assertEquals(expected1, result);
    }

    private ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        ListNode next = swapPairs(head.next.next);

        newHead.next = head;
        head.next = next;

        return newHead;
    }

}
