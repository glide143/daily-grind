package com.melchizedek.leet.code.grind.easy;

import com.melchizedek.leet.code.grind.domain.ParkingSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingSystemTest {
    @Test
    void test_case_1() {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);

        assertTrue(parkingSystem.addCar(1));
        assertTrue(parkingSystem.addCar(2));
        assertFalse(parkingSystem.addCar(3));
        assertFalse(parkingSystem.addCar(1));

    }
}
