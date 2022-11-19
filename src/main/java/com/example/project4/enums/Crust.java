package com.example.project4.enums;

public enum Crust {
    DEEP_DISH("Deep Dish"),
    PAN("Pan"),
    STUFFED("Stuffed"),
    BROOKLYN("Brookyln"),
    THIN("Thin"),
    HAND_TOSSED("Hand Tossed");

    private final String crustName;

    Crust(String crust) {
        this.crustName = crust;
    }

    @Override
    public String toString() {
        return this.crustName;
    }
}