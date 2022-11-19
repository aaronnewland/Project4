package com.example.project4;

import java.util.ArrayList;

public class Meatza extends Pizza {

    public Meatza() {
        ArrayList<Topping> toppings = new ArrayList<>() {
            {
                add(Topping.SAUSAGE);
                add(Topping.PEPPERONI);
                add(Topping.BEEF);
                add(Topping.HAM);
            }
        };
        setToppings(toppings);
        setCrust(Crust.STUFFED);
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
        return 0;
    }
}
