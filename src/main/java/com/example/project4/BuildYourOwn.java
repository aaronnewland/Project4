package com.example.project4;

public class BuildYourOwn extends Pizza {
    private static final double SMALL_PRICE = 8.99;
    private static final double MEDIUM_PRICE = 10.99;
    private static final double LARGE_PRICE = 12.99;
    private static final double TOPPING_PRICE = 1.59;

    public BuildYourOwn() { }

    @Override
    public boolean add(Object obj) {
        if (getToppings().size() >= 7) return false;
        else if (getToppings().add((Topping) obj)) return true;
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        if (getToppings().isEmpty() || !getToppings().contains((Topping) obj)) return false;
        else if (getToppings().remove((Topping) obj)) return true;
        return false;
    }

    @Override
    public double price() {
        double toppingsPrice = super.getToppings().size() * TOPPING_PRICE;
        switch(getSize()) {
            case SMALL:
                return SMALL_PRICE + toppingsPrice;
            case MEDIUM:
                return MEDIUM_PRICE + toppingsPrice;
            case LARGE:
                return LARGE_PRICE + toppingsPrice;
            default:
                return 0;
        }
    }
}
