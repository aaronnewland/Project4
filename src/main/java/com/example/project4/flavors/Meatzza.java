package com.example.project4.flavors;

import com.example.project4.Pizza;
import com.example.project4.enums.Topping;

import java.util.ArrayList;

public class Meatzza extends Pizza {
    private static final double SMALL_PRICE = 15.99;
    private static final double MEDIUM_PRICE = 17.99;
    private static final double LARGE_PRICE = 19.99;

    public Meatzza() {
        ArrayList<Topping> toppings = new ArrayList<>() {
            {
                add(Topping.SAUSAGE);
                add(Topping.PEPPERONI);
                add(Topping.BEEF);
                add(Topping.HAM);
            }
        };
        setToppings(toppings);
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
