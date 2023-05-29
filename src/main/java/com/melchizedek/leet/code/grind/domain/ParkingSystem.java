package com.melchizedek.leet.code.grind.domain;

public class ParkingSystem {
    private final int[] availableSpaces;

    public ParkingSystem(int big, int medium, int small) {
        this.availableSpaces = new int[] { big, medium, small };
    }

    public boolean addCar(int carType) {
        return this.availableSpaces[carType - 1]-- > 0;
    }

}
