package com.melchizedek.leet.code.grind.medium;

import com.melchizedek.leet.code.grind.domain.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwappingNodesInALinkListTest {
    @Test
    void test_case_1() {

        ListNode listNode1 = new ListNode(5);
        ListNode listNode2 = new ListNode(4, listNode1);
        ListNode listNode3 = new ListNode(3,listNode2);
        ListNode listNode4 = new ListNode(2, listNode3);
        ListNode listNode5 = new ListNode(1,listNode4);


        int k = 2;
        ListNode result = swapNodes(listNode5, 2);

        ListNode expected = new ListNode(5);
        ListNode expected2 = new ListNode(2, expected);
        ListNode expected3 = new ListNode(3,expected2);
        ListNode expected4 = new ListNode(4, expected3);
        ListNode expected5 = new ListNode(1,expected4);

        assertEquals(expected5 , result);

    }

    private ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        while (--k > 0) {
            fast = fast.next;
        }
        ListNode p = fast;
        ListNode slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode q = slow;
        int t = p.val;
        p.val = q.val;
        q.val = t;
        return head;
    }


}
