package com.example.project4.flavors;

import com.example.project4.Pizza;
import com.example.project4.enums.Crust;
import com.example.project4.enums.PizzaStyle;
import com.example.project4.enums.Size;
import com.example.project4.enums.Topping;

import java.util.ArrayList;

public class Deluxe extends Pizza {
    private static final double SMALL_PRICE = 14.99;
    private static final double MEDIUM_PRICE = 16.99;
    private static final double LARGE_PRICE = 18.99;
    private PizzaStyle pizzaStyle;

    public Deluxe(PizzaStyle pizzaStyle) {
        ArrayList<Topping> toppings = new ArrayList<>() {
            {
                add(Topping.SAUSAGE);
                add(Topping.PEPPERONI);
                add(Topping.GREEN_PEPPER);
                add(Topping.ONION);
                add(Topping.MUSHROOM);
            }
        };
        setToppings(toppings);
        setPizzaStyle(pizzaStyle);
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

    public PizzaStyle getPizzaStyle() {
        return pizzaStyle;
    }

    public void setPizzaStyle(PizzaStyle pizzaStyle) {
        this.pizzaStyle = pizzaStyle;
    }

    @Override
    public String toString() {
        return "Deluxe (" + getPizzaStyle() + "- " + getCrust() + ") " + getSize() +
                ", $" + String.format("%,.2f", price());
    }
}
