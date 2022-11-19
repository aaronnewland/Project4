package com.example.project4.enums;

public enum Topping {
    SAUSAGE("Sausage"),
    BBQ_CHICKEN("BBQ Chicken"),
    BEEF("Beef"),
    HAM("Ham"),
    PEPPERONI("Pepperoni"),
    GREEN_PEPPER("Green Pepper"),
    ONION("Onion"),
    MUSHROOM("Mushroom"),
    PINEAPPLE("Pineapple"),
    BLACK_OLIVES("Black Olives"),
    PROVOLONE("Provolone"),
    SPINACH("Spinach"),
    CHEDDAR("Cheddar");

    private final String toppingName;

    Topping(String topping) {
        this.toppingName = topping;
    }

    @Override
    public String toString() {
        return this.toppingName;
    }
}
