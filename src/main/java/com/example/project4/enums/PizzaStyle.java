package com.example.project4.enums;

public enum PizzaStyle {
    NY("New York Style"),
    CHICAGO("New York Style");

    private final String styleName;

    PizzaStyle(String styleName) {
        this.styleName = styleName;
    }

    @Override
    public String toString() {
        return this.styleName;
    }
}
