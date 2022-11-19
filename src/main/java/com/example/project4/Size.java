package com.example.project4;

public enum Size {
    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large");

    private final String sizeName;

    Size(String size) {
        this.sizeName = size;
    }

    @Override
    public String toString() {
        return this.sizeName;
    }
}
