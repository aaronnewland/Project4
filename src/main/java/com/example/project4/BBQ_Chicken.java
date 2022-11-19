package com.example.project4;

import java.util.ArrayList;

public class BBQ_Chicken extends Pizza {
    private static final double SMALL_PRICE = 13.99;
    private static final double MEDIUM_PRICE = 15.99;
    private static final double LARGE_PRICE = 17.99;

    public BBQ_Chicken() {
        ArrayList<Topping> toppings = new ArrayList<>() {
            {
                add(Topping.BBQ_CHICKEN);
                add(Topping.GREEN_PEPPER);
                add(Topping.PROVOLONE);
                add(Topping.CHEDDAR);
            }
        };
        setToppings(toppings);
        setCrust(Crust.PAN);
    }

    @Override
    public boolean add(Object obj) {
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        return false;
    }

    @Override
    public double price() {
        switch(getSize()) {
            case SMALL:
                return SMALL_PRICE;
            case MEDIUM:
                return MEDIUM_PRICE;
            case LARGE:
                return LARGE_PRICE;
            default:
                return 0;
        }
    }
}
