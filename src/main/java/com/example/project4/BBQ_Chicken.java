package com.example.project4;

import java.util.ArrayList;

public class BBQ_Chicken extends Pizza {

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
        return 0;
    }
}
