package com.example.project4.flavors;

import com.example.project4.Pizza;
import com.example.project4.enums.PizzaStyle;
import com.example.project4.enums.Topping;

public class BuildYourOwn extends Pizza {
    private static final double SMALL_PRICE = 8.99;
    private static final double MEDIUM_PRICE = 10.99;
    private static final double LARGE_PRICE = 12.99;
    private static final double TOPPING_PRICE = 1.59;
    private PizzaStyle pizzaStyle;

    public BuildYourOwn(PizzaStyle pizzaStyle) {
        setPizzaStyle(pizzaStyle);
    }

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
        double toppingsPrice = getToppings().size() * TOPPING_PRICE;
        switch (getSize()) {
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

    public PizzaStyle getPizzaStyle() {
        return this.pizzaStyle;
    }

    public void setPizzaStyle(PizzaStyle pizzaStyle) {
        this.pizzaStyle = pizzaStyle;
    }

    @Override
    public String toString() {
        StringBuilder toppings = new StringBuilder();
        getToppings().forEach(topping -> toppings.append(topping + ", "));
        return "Build your own (" + getPizzaStyle() + "- " + getCrust() + ") " +
                toppings + getSize() + ", $" + String.format("%,.2f", price());
    }
}
