package com.melchizedek.leet.code.grind.easy;

import com.melchizedek.leet.code.grind.domain.MyHashSet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyHashSetTest {
    @Test
    void test_case_1() {

        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(2);

        assertTrue(myHashSet.contains(1));
        assertFalse(myHashSet.contains(3));

        myHashSet.add(2);
        assertTrue(myHashSet.contains(2));

        myHashSet.remove(2);
        assertFalse(myHashSet.contains(2));

    }
}
