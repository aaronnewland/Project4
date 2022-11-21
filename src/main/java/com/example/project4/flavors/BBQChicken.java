package com.example.project4.flavors;

import com.example.project4.Pizza;
import com.example.project4.enums.PizzaStyle;
import com.example.project4.enums.Topping;

import java.util.ArrayList;

/**
 * Holds data and methods for BBQ Chicken pizza flavor.
 * @author Aaron Newland, Dylan Pina
 */
public class BBQChicken extends Pizza {
    private static final double SMALL_PRICE = 13.99;
    private static final double MEDIUM_PRICE = 15.99;
    private static final double LARGE_PRICE = 17.99;
    private PizzaStyle pizzaStyle;

    /**
     * Constructor for BBQ Chicken pizza using given pizza style. Sets toppings given to BBQ Chicken pizza.
     * @param pizzaStyle pizzaStyle for BBQ Chicken pizza to be created with.
     */
    public BBQChicken(PizzaStyle pizzaStyle) {
        ArrayList<Topping> toppings = new ArrayList<>() {
            {
                add(Topping.BBQ_CHICKEN);
                add(Topping.GREEN_PEPPER);
                add(Topping.PROVOLONE);
                add(Topping.CHEDDAR);
            }
        };
        setToppings(toppings);
        setPizzaStyle(pizzaStyle);
    }

    /**
     * Adds topping to pizza. Pre-made pizzas do not accept custom toppings.
     * @param obj topping to be added to pizza.
     * @return false.
     */
    @Override
    public boolean add(Object obj) {
        return false;
    }

    /**
     * Removes topping to pizza. Pre-made pizzas do not accept custom toppings.
     * @param obj topping to be removed from pizza.
     * @return false.
     */
    @Override
    public boolean remove(Object obj) {
        return false;
    }

    /**
     * Retrieves price for pizza depending on selected size.
     * @return price for selected pizza size.
     */
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

    /**
     * Retrieves pizza style. Chicago or NY.
     * @return pizza style for pizza.
     */
    public PizzaStyle getPizzaStyle() {
        return pizzaStyle;
    }

    /**
     * Sets pizza style. Chicago or NY.
     * @param pizzaStyle pizzaStyle to be set to.
     */
    public void setPizzaStyle(PizzaStyle pizzaStyle) {
        this.pizzaStyle = pizzaStyle;
    }

    /**
     * Provides a string representation of a BBQChicken object.
     * @return String of BBQChicken object.
     */
    @Override
    public String toString() {
        return "BBQ Chicken (" + getPizzaStyle() + " - " + getCrust() + "), " + getSize() +
                ", $" + String.format("%,.2f", price());
    }
}
