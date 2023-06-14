package com.melchizedek.leet.code.grind.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefangingAnIpAddressTest {

    @Test
    void test_case_1() {
        String address = "1.1.1.1";

        String results = defangIPaddr(address);

        assertEquals("1[.]1[.]1[.]1", results);
    }

    @Test
    void test_case_2() {
        String address = "255.100.50.0";

        String results = defangIPaddr(address);

        assertEquals("255[.]100[.]50[.]0", results);
    }

    private String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }
}
