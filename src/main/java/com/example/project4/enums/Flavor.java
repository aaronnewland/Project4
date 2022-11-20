package com.example.project4.enums;

public enum Flavor {
    BUILD_YOUR_OWN("Build your own"),
    DELUXE("Deluxe"),
    BBQ_CHICKEN("BBQ Chicken"),
    MEATZZA("Meatzza");

    private final String flavorName;

    Flavor(String flavorName) {
        this.flavorName = flavorName;
    }

    @Override
    public String toString() {
        return this.flavorName;
    }
}
