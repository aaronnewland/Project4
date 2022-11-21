package com.example.project4.tests;

import com.example.project4.Pizza;
import com.example.project4.enums.Size;
import com.example.project4.enums.Topping;
import com.example.project4.interfaces.PizzaFactory;
import com.example.project4.pizzastyles.ChicagoPizza;
import com.example.project4.pizzastyles.NYPizza;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuildYourOwnTest {
    private static final double smallBuildYourOwnPrice = 8.99;
    private static final double mediumBuildYourOwnPrice = 10.99;
    private static final double largeBuildYourOwnPrice = 12.99;
    private static final double toppingPrice = 1.59;
    private PizzaFactory chicagoPizzaFactory = new ChicagoPizza();
    private PizzaFactory nyPizzaFactory = new NYPizza();

    /**
     * Test small chicago build your own pizza with no toppings
     */
    @Test
    void smallChicagoByoNoTopping() {
        Pizza smallChicagoByoNoTopping = chicagoPizzaFactory.createBuildYourOwn();
        smallChicagoByoNoTopping.setSize(Size.SMALL);
        assertEquals(smallChicagoByoNoTopping.price(), smallBuildYourOwnPrice);
    }

    /**
     * Test small chicago build your own pizza with one topping
     */
    @Test
    void smallChicagoByoOneTopping() {
        Pizza smallChicagoByoOneTopping = chicagoPizzaFactory.createBuildYourOwn();
        smallChicagoByoOneTopping.setSize(Size.SMALL);
        assertTrue(smallChicagoByoOneTopping.add(Topping.SAUSAGE));
        assertEquals(smallChicagoByoOneTopping.price(), smallBuildYourOwnPrice + toppingPrice);
    }

    /**
     * Test small chicago build your own pizza with two toppings
     */
    @Test
    void smallChicagoByoTwoTopping() {
        Pizza smallChicagoByoTwoTopping = chicagoPizzaFactory.createBuildYourOwn();
        smallChicagoByoTwoTopping.setSize(Size.SMALL);
        assertTrue(smallChicagoByoTwoTopping.add(Topping.SAUSAGE));
        assertTrue(smallChicagoByoTwoTopping.add(Topping.BEEF));
        assertEquals(smallChicagoByoTwoTopping.price(), smallBuildYourOwnPrice + (toppingPrice * 2));
    }

    /**
     * Test small chicago build your own pizza with three toppings
     */
    @Test
    void smallChicagoByoThreeTopping() {
        Pizza smallChicagoByoThreeTopping = chicagoPizzaFactory.createBuildYourOwn();
        smallChicagoByoThreeTopping.setSize(Size.SMALL);
        assertTrue(smallChicagoByoThreeTopping.add(Topping.SAUSAGE));
        assertTrue(smallChicagoByoThreeTopping.add(Topping.BEEF));
        assertTrue(smallChicagoByoThreeTopping.add(Topping.HAM));
        assertEquals(smallChicagoByoThreeTopping.price(), smallBuildYourOwnPrice + (toppingPrice * 3));
    }

    /**
     * Test small chicago build your own pizza with four toppings
     */
    @Test
    void smallChicagoByoFourTopping() {
        Pizza smallChicagoByoFourTopping = chicagoPizzaFactory.createBuildYourOwn();
        smallChicagoByoFourTopping.setSize(Size.SMALL);
        assertTrue(smallChicagoByoFourTopping.add(Topping.SAUSAGE));
        assertTrue(smallChicagoByoFourTopping.add(Topping.BEEF));
        assertTrue(smallChicagoByoFourTopping.add(Topping.HAM));
        assertTrue(smallChicagoByoFourTopping.add(Topping.PEPPERONI));
        assertEquals(smallChicagoByoFourTopping.price(), smallBuildYourOwnPrice + (toppingPrice * 4));
    }

    /**
     * Test small chicago build your own pizza with five toppings
     */
    @Test
    void smallChicagoByoFiveTopping() {
        Pizza smallChicagoByoFiveTopping = chicagoPizzaFactory.createBuildYourOwn();
        smallChicagoByoFiveTopping.setSize(Size.SMALL);
        assertTrue(smallChicagoByoFiveTopping.add(Topping.SAUSAGE));
        assertTrue(smallChicagoByoFiveTopping.add(Topping.BEEF));
        assertTrue(smallChicagoByoFiveTopping.add(Topping.HAM));
        assertTrue(smallChicagoByoFiveTopping.add(Topping.PEPPERONI));
        assertTrue(smallChicagoByoFiveTopping.add(Topping.GREEN_PEPPER));
        assertEquals(smallChicagoByoFiveTopping.price(), smallBuildYourOwnPrice + (toppingPrice * 5));
    }

    /**
     * Test small chicago build your own pizza with six toppings
     */
    @Test
    void smallChicagoByoSixTopping() {
        Pizza smallChicagoByoSixTopping = chicagoPizzaFactory.createBuildYourOwn();
        smallChicagoByoSixTopping.setSize(Size.SMALL);
        assertTrue(smallChicagoByoSixTopping.add(Topping.SAUSAGE));
        assertTrue(smallChicagoByoSixTopping.add(Topping.BEEF));
        assertTrue(smallChicagoByoSixTopping.add(Topping.HAM));
        assertTrue(smallChicagoByoSixTopping.add(Topping.PEPPERONI));
        assertTrue(smallChicagoByoSixTopping.add(Topping.GREEN_PEPPER));
        assertTrue(smallChicagoByoSixTopping.add(Topping.ONION));
        assertEquals(smallChicagoByoSixTopping.price(), smallBuildYourOwnPrice + (toppingPrice * 6));
    }

    /**
     * Test small chicago build your own pizza with seven toppings
     */
    @Test
    void smallChicagoByoSevenTopping() {
        Pizza smallChicagoByoSevenTopping = chicagoPizzaFactory.createBuildYourOwn();
        smallChicagoByoSevenTopping.setSize(Size.SMALL);
        assertTrue(smallChicagoByoSevenTopping.add(Topping.SAUSAGE));
        assertTrue(smallChicagoByoSevenTopping.add(Topping.BEEF));
        assertTrue(smallChicagoByoSevenTopping.add(Topping.HAM));
        assertTrue(smallChicagoByoSevenTopping.add(Topping.PEPPERONI));
        assertTrue(smallChicagoByoSevenTopping.add(Topping.GREEN_PEPPER));
        assertTrue(smallChicagoByoSevenTopping.add(Topping.ONION));
        assertTrue(smallChicagoByoSevenTopping.add(Topping.MUSHROOM));
        assertEquals(smallChicagoByoSevenTopping.price(), smallBuildYourOwnPrice + (toppingPrice * 7));
    }

    /**
     * Test small chicago build your own pizza with eight toppings and expect to
     * return false when we try to add the eighth topping
     */

    @Test
    void smallChicagoByoEightTopping() {
        Pizza smallChicagoByoEightTopping = chicagoPizzaFactory.createBuildYourOwn();
        smallChicagoByoEightTopping.setSize(Size.SMALL);
        assertTrue(smallChicagoByoEightTopping.add(Topping.SAUSAGE));
        assertTrue(smallChicagoByoEightTopping.add(Topping.BEEF));
        assertTrue(smallChicagoByoEightTopping.add(Topping.HAM));
        assertTrue(smallChicagoByoEightTopping.add(Topping.PEPPERONI));
        assertTrue(smallChicagoByoEightTopping.add(Topping.GREEN_PEPPER));
        assertTrue(smallChicagoByoEightTopping.add(Topping.ONION));
        assertTrue(smallChicagoByoEightTopping.add(Topping.MUSHROOM));
        assertFalse(smallChicagoByoEightTopping.add(Topping.PINEAPPLE));
    }

    /**
     * Test medium chicago build your own pizza with no toppings
     */
    @Test
    void mediumChicagoByoNoTopping() {
        Pizza mediumChicagoByoNoTopping = chicagoPizzaFactory.createBuildYourOwn();
        mediumChicagoByoNoTopping.setSize(Size.MEDIUM);
        assertEquals(mediumChicagoByoNoTopping.price(), mediumBuildYourOwnPrice);
    }

    /**
     * Test medium chicago build your own pizza with one topping
     */
    @Test
    void mediumChicagoByoOneTopping() {
        Pizza mediumChicagoByoOneTopping = chicagoPizzaFactory.createBuildYourOwn();
        mediumChicagoByoOneTopping.setSize(Size.MEDIUM);
        assertTrue(mediumChicagoByoOneTopping.add(Topping.SAUSAGE));
        assertEquals(mediumChicagoByoOneTopping.price(), mediumBuildYourOwnPrice + toppingPrice);
    }

    /**
     * Test medium chicago build your own pizza with two toppings
     */
    @Test
    void mediumChicagoByoTwoTopping() {
        Pizza mediumChicagoByoTwoTopping = chicagoPizzaFactory.createBuildYourOwn();
        mediumChicagoByoTwoTopping.setSize(Size.MEDIUM);
        assertTrue(mediumChicagoByoTwoTopping.add(Topping.SAUSAGE));
        assertTrue(mediumChicagoByoTwoTopping.add(Topping.BEEF));
        assertEquals(mediumChicagoByoTwoTopping.price(), mediumBuildYourOwnPrice + (toppingPrice * 2));
    }

    /**
     * Test medium chicago build your own pizza with three toppings
     */
    @Test
    void mediumChicagoByoThreeTopping() {
        Pizza mediumChicagoByoThreeTopping = chicagoPizzaFactory.createBuildYourOwn();
        mediumChicagoByoThreeTopping.setSize(Size.MEDIUM);
        assertTrue(mediumChicagoByoThreeTopping.add(Topping.SAUSAGE));
        assertTrue(mediumChicagoByoThreeTopping.add(Topping.BEEF));
        assertTrue(mediumChicagoByoThreeTopping.add(Topping.HAM));
        assertEquals(mediumChicagoByoThreeTopping.price(), mediumBuildYourOwnPrice + (toppingPrice * 3));
    }

    /**
     * Test medium chicago build your own pizza with four toppings
     */
    @Test
    void mediumChicagoByoFourTopping() {
        Pizza mediumChicagoByoFourTopping = chicagoPizzaFactory.createBuildYourOwn();
        mediumChicagoByoFourTopping.setSize(Size.MEDIUM);
        assertTrue(mediumChicagoByoFourTopping.add(Topping.SAUSAGE));
        assertTrue(mediumChicagoByoFourTopping.add(Topping.BEEF));
        assertTrue(mediumChicagoByoFourTopping.add(Topping.HAM));
        assertTrue(mediumChicagoByoFourTopping.add(Topping.PEPPERONI));
        assertEquals(mediumChicagoByoFourTopping.price(), mediumBuildYourOwnPrice + (toppingPrice * 4));
    }

    /**
     * Test medium chicago build your own pizza with five toppings
     */
    @Test
    void mediumChicagoByoFiveTopping() {
        Pizza mediumChicagoByoFiveTopping = chicagoPizzaFactory.createBuildYourOwn();
        mediumChicagoByoFiveTopping.setSize(Size.MEDIUM);
        assertTrue(mediumChicagoByoFiveTopping.add(Topping.SAUSAGE));
        assertTrue(mediumChicagoByoFiveTopping.add(Topping.BEEF));
        assertTrue(mediumChicagoByoFiveTopping.add(Topping.HAM));
        assertTrue(mediumChicagoByoFiveTopping.add(Topping.PEPPERONI));
        assertTrue(mediumChicagoByoFiveTopping.add(Topping.GREEN_PEPPER));
        assertEquals(mediumChicagoByoFiveTopping.price(), mediumBuildYourOwnPrice + (toppingPrice * 5));
    }

    /**
     * Test medium chicago build your own pizza with six toppings
     */
    @Test
    void mediumChicagoByoSixTopping() {
        Pizza mediumChicagoByoSixTopping = chicagoPizzaFactory.createBuildYourOwn();
        mediumChicagoByoSixTopping.setSize(Size.MEDIUM);
        assertTrue(mediumChicagoByoSixTopping.add(Topping.SAUSAGE));
        assertTrue(mediumChicagoByoSixTopping.add(Topping.BEEF));
        assertTrue(mediumChicagoByoSixTopping.add(Topping.HAM));
        assertTrue(mediumChicagoByoSixTopping.add(Topping.PEPPERONI));
        assertTrue(mediumChicagoByoSixTopping.add(Topping.GREEN_PEPPER));
        assertTrue(mediumChicagoByoSixTopping.add(Topping.ONION));
        assertEquals(mediumChicagoByoSixTopping.price(), mediumBuildYourOwnPrice + (toppingPrice * 6));
    }

    /**
     * Test medium chicago build your own pizza with seven toppings
     */
    @Test
    void mediumChicagoByoSevenTopping() {
        Pizza mediumChicagoByoSevenTopping = chicagoPizzaFactory.createBuildYourOwn();
        mediumChicagoByoSevenTopping.setSize(Size.MEDIUM);
        assertTrue(mediumChicagoByoSevenTopping.add(Topping.SAUSAGE));
        assertTrue(mediumChicagoByoSevenTopping.add(Topping.BEEF));
        assertTrue(mediumChicagoByoSevenTopping.add(Topping.HAM));
        assertTrue(mediumChicagoByoSevenTopping.add(Topping.PEPPERONI));
        assertTrue(mediumChicagoByoSevenTopping.add(Topping.GREEN_PEPPER));
        assertTrue(mediumChicagoByoSevenTopping.add(Topping.ONION));
        assertTrue(mediumChicagoByoSevenTopping.add(Topping.MUSHROOM));
        assertEquals(mediumChicagoByoSevenTopping.price(), mediumBuildYourOwnPrice + (toppingPrice * 7));
    }

    /**
     * Test medium chicago build your own pizza with eight toppings and expect to
     * return false when we try to add the eighth topping
     */
    @Test
    void mediumChicagoByoEightTopping() {
        Pizza mediumChicagoEightTopping = chicagoPizzaFactory.createBuildYourOwn();
        mediumChicagoEightTopping.setSize(Size.MEDIUM);
        assertTrue(mediumChicagoEightTopping.add(Topping.SAUSAGE));
        assertTrue(mediumChicagoEightTopping.add(Topping.BEEF));
        assertTrue(mediumChicagoEightTopping.add(Topping.HAM));
        assertTrue(mediumChicagoEightTopping.add(Topping.PEPPERONI));
        assertTrue(mediumChicagoEightTopping.add(Topping.GREEN_PEPPER));
        assertTrue(mediumChicagoEightTopping.add(Topping.ONION));
        assertTrue(mediumChicagoEightTopping.add(Topping.MUSHROOM));
        assertFalse(mediumChicagoEightTopping.add(Topping.PINEAPPLE));
    }

    /**
     * Test large chicago build your own pizza with no toppings
     */
    @Test
    void largeChicagoByoNoTopping() {
        Pizza largeChicagoByoNoTopping = chicagoPizzaFactory.createBuildYourOwn();
        largeChicagoByoNoTopping.setSize(Size.LARGE);
        assertEquals(largeChicagoByoNoTopping.price(), largeBuildYourOwnPrice);
    }

    /**
     * Test large chicago build your own pizza with one topping
     */
    @Test
    void largeChicagoByoOneTopping() {
        Pizza largeChicagoByoOneTopping = chicagoPizzaFactory.createBuildYourOwn();
        largeChicagoByoOneTopping.setSize(Size.LARGE);
        assertTrue(largeChicagoByoOneTopping.add(Topping.SAUSAGE));
        assertEquals(largeChicagoByoOneTopping.price(), largeBuildYourOwnPrice + toppingPrice);
    }

    /**
     * Test large chicago build your own pizza with two toppings
     */
    @Test
    void largeChicagoByoTwoTopping() {
        Pizza largeChicagoByoTwoTopping = chicagoPizzaFactory.createBuildYourOwn();
        largeChicagoByoTwoTopping.setSize(Size.LARGE);
        assertTrue(largeChicagoByoTwoTopping.add(Topping.SAUSAGE));
        assertTrue(largeChicagoByoTwoTopping.add(Topping.BEEF));
        assertEquals(largeChicagoByoTwoTopping.price(), largeBuildYourOwnPrice + (toppingPrice * 2));
    }

    /**
     * Test large chicago build your own pizza with three toppings
     */
    @Test
    void largeChicagoByoThreeTopping() {
        Pizza largeChicagoByoThreeTopping = chicagoPizzaFactory.createBuildYourOwn();
        largeChicagoByoThreeTopping.setSize(Size.LARGE);
        assertTrue(largeChicagoByoThreeTopping.add(Topping.SAUSAGE));
        assertTrue(largeChicagoByoThreeTopping.add(Topping.BEEF));
        assertTrue(largeChicagoByoThreeTopping.add(Topping.HAM));
        assertEquals(largeChicagoByoThreeTopping.price(), largeBuildYourOwnPrice + (toppingPrice * 3));
    }

    /**
     * Test large chicago build your own pizza with four toppings
     */
    @Test
    void largeChicagoByoFourTopping() {
        Pizza largeChicagoByoFourTopping = chicagoPizzaFactory.createBuildYourOwn();
        largeChicagoByoFourTopping.setSize(Size.LARGE);
        assertTrue(largeChicagoByoFourTopping.add(Topping.SAUSAGE));
        assertTrue(largeChicagoByoFourTopping.add(Topping.BEEF));
        assertTrue(largeChicagoByoFourTopping.add(Topping.HAM));
        assertTrue(largeChicagoByoFourTopping.add(Topping.PEPPERONI));
        assertEquals(largeChicagoByoFourTopping.price(), largeBuildYourOwnPrice + (toppingPrice * 4));
    }

    /**
     * Test large chicago build your own pizza with five toppings
     */
    @Test
    void largeChicagoByoFiveTopping() {
        Pizza largeChicagoByoFiveTopping = chicagoPizzaFactory.createBuildYourOwn();
        largeChicagoByoFiveTopping.setSize(Size.LARGE);
        assertTrue(largeChicagoByoFiveTopping.add(Topping.SAUSAGE));
        assertTrue(largeChicagoByoFiveTopping.add(Topping.BEEF));
        assertTrue(largeChicagoByoFiveTopping.add(Topping.HAM));
        assertTrue(largeChicagoByoFiveTopping.add(Topping.PEPPERONI));
        assertTrue(largeChicagoByoFiveTopping.add(Topping.GREEN_PEPPER));
        assertEquals(largeChicagoByoFiveTopping.price(), largeBuildYourOwnPrice + (toppingPrice * 5));
    }

    /**
     * Test large chicago build your own pizza with six toppings
     */
    @Test
    void largeChicagoByoSixTopping() {
        Pizza largeChicagoByoSixTopping = chicagoPizzaFactory.createBuildYourOwn();
        largeChicagoByoSixTopping.setSize(Size.LARGE);
        assertTrue(largeChicagoByoSixTopping.add(Topping.SAUSAGE));
        assertTrue(largeChicagoByoSixTopping.add(Topping.BEEF));
        assertTrue(largeChicagoByoSixTopping.add(Topping.HAM));
        assertTrue(largeChicagoByoSixTopping.add(Topping.PEPPERONI));
        assertTrue(largeChicagoByoSixTopping.add(Topping.GREEN_PEPPER));
        assertTrue(largeChicagoByoSixTopping.add(Topping.ONION));
        assertEquals(largeChicagoByoSixTopping.price(), largeBuildYourOwnPrice + (toppingPrice * 6));
    }

    /**
     * Test large chicago build your own pizza with seven toppings
     */
    @Test
    void largeChicagoByoSevenTopping() {
        Pizza largeChicagoByoSevenTopping = chicagoPizzaFactory.createBuildYourOwn();
        largeChicagoByoSevenTopping.setSize(Size.LARGE);
        assertTrue(largeChicagoByoSevenTopping.add(Topping.SAUSAGE));
        assertTrue(largeChicagoByoSevenTopping.add(Topping.BEEF));
        assertTrue(largeChicagoByoSevenTopping.add(Topping.HAM));
        assertTrue(largeChicagoByoSevenTopping.add(Topping.PEPPERONI));
        assertTrue(largeChicagoByoSevenTopping.add(Topping.GREEN_PEPPER));
        assertTrue(largeChicagoByoSevenTopping.add(Topping.ONION));
        assertTrue(largeChicagoByoSevenTopping.add(Topping.MUSHROOM));
        assertEquals(largeChicagoByoSevenTopping.price(), largeBuildYourOwnPrice + (toppingPrice * 7));
    }

    /**
     * Test large chicago build your own pizza with eight toppings and expect to
     * return false when we try to add the eighth topping
     */
    @Test
    void largeChicagoByoEightTopping() {
        Pizza largeChicagoByoSevenTopping = chicagoPizzaFactory.createBuildYourOwn();
        largeChicagoByoSevenTopping.setSize(Size.LARGE);
        assertTrue(largeChicagoByoSevenTopping.add(Topping.SAUSAGE));
        assertTrue(largeChicagoByoSevenTopping.add(Topping.BEEF));
        assertTrue(largeChicagoByoSevenTopping.add(Topping.HAM));
        assertTrue(largeChicagoByoSevenTopping.add(Topping.PEPPERONI));
        assertTrue(largeChicagoByoSevenTopping.add(Topping.GREEN_PEPPER));
        assertTrue(largeChicagoByoSevenTopping.add(Topping.ONION));
        assertTrue(largeChicagoByoSevenTopping.add(Topping.MUSHROOM));
        assertFalse(largeChicagoByoSevenTopping.add(Topping.PINEAPPLE));
    }

    /**
     * Test small NewYork build your own pizza with no toppings
     */
    @Test
    void smallNewYorkByoNoTopping() {
        Pizza smallNewYorkByoNoTopping = nyPizzaFactory.createBuildYourOwn();
        smallNewYorkByoNoTopping.setSize(Size.SMALL);
        assertEquals(smallNewYorkByoNoTopping.price(), smallBuildYourOwnPrice);
    }

    /**
     * Test small NewYork build your own pizza with one topping
     */
    @Test
    void smallNewYorkByoOneTopping() {
        Pizza smallNewYorkByoOneTopping = nyPizzaFactory.createBuildYourOwn();
        smallNewYorkByoOneTopping.setSize(Size.SMALL);
        assertTrue(smallNewYorkByoOneTopping.add(Topping.SAUSAGE));
        assertEquals(smallNewYorkByoOneTopping.price(), smallBuildYourOwnPrice + toppingPrice);
    }

    /**
     * Test small NewYork build your own pizza with two toppings
     */
    @Test
    void smallNewYorkByoTwoTopping() {
        Pizza smallNewYorkByoTwoTopping = nyPizzaFactory.createBuildYourOwn();
        smallNewYorkByoTwoTopping.setSize(Size.SMALL);
        assertTrue(smallNewYorkByoTwoTopping.add(Topping.SAUSAGE));
        assertTrue(smallNewYorkByoTwoTopping.add(Topping.BEEF));
        assertEquals(smallNewYorkByoTwoTopping.price(), smallBuildYourOwnPrice + (toppingPrice * 2));
    }

    /**
     * Test small NewYork build your own pizza with three toppings
     */
    @Test
    void smallNewYorkByoThreeTopping() {
        Pizza smallNewYorkByoThreeTopping = nyPizzaFactory.createBuildYourOwn();
        smallNewYorkByoThreeTopping.setSize(Size.SMALL);
        assertTrue(smallNewYorkByoThreeTopping.add(Topping.SAUSAGE));
        assertTrue(smallNewYorkByoThreeTopping.add(Topping.BEEF));
        assertTrue(smallNewYorkByoThreeTopping.add(Topping.HAM));
        assertEquals(smallNewYorkByoThreeTopping.price(), smallBuildYourOwnPrice + (toppingPrice * 3));
    }

    /**
     * Test small NewYork build your own pizza with four toppings
     */
    @Test
    void smallNewYorkByoFourTopping() {
        Pizza smallNewYorkByoFourTopping = nyPizzaFactory.createBuildYourOwn();
        smallNewYorkByoFourTopping.setSize(Size.SMALL);
        assertTrue(smallNewYorkByoFourTopping.add(Topping.SAUSAGE));
        assertTrue(smallNewYorkByoFourTopping.add(Topping.BEEF));
        assertTrue(smallNewYorkByoFourTopping.add(Topping.HAM));
        assertTrue(smallNewYorkByoFourTopping.add(Topping.PEPPERONI));
        assertEquals(smallNewYorkByoFourTopping.price(), smallBuildYourOwnPrice + (toppingPrice * 4));
    }

    /**
     * Test small NewYork build your own pizza with five toppings
     */
    @Test
    void smallNewYorkByoFiveTopping() {
        Pizza smallNewYorkByoFiveTopping = nyPizzaFactory.createBuildYourOwn();
        smallNewYorkByoFiveTopping.setSize(Size.SMALL);
        assertTrue(smallNewYorkByoFiveTopping.add(Topping.SAUSAGE));
        assertTrue(smallNewYorkByoFiveTopping.add(Topping.BEEF));
        assertTrue(smallNewYorkByoFiveTopping.add(Topping.HAM));
        assertTrue(smallNewYorkByoFiveTopping.add(Topping.PEPPERONI));
        assertTrue(smallNewYorkByoFiveTopping.add(Topping.GREEN_PEPPER));
        assertEquals(smallNewYorkByoFiveTopping.price(), smallBuildYourOwnPrice + (toppingPrice * 5));
    }

    /**
     * Test small NewYork build your own pizza with six toppings
     */
    @Test
    void smallNewYorkByoSixTopping() {
        Pizza smallNewYorkByoSixTopping = nyPizzaFactory.createBuildYourOwn();
        smallNewYorkByoSixTopping.setSize(Size.SMALL);
        assertTrue(smallNewYorkByoSixTopping.add(Topping.SAUSAGE));
        assertTrue(smallNewYorkByoSixTopping.add(Topping.BEEF));
        assertTrue(smallNewYorkByoSixTopping.add(Topping.HAM));
        assertTrue(smallNewYorkByoSixTopping.add(Topping.PEPPERONI));
        assertTrue(smallNewYorkByoSixTopping.add(Topping.GREEN_PEPPER));
        assertTrue(smallNewYorkByoSixTopping.add(Topping.ONION));
        assertEquals(smallNewYorkByoSixTopping.price(), smallBuildYourOwnPrice + (toppingPrice * 6));
    }

    /**
     * Test small NewYork build your own pizza with seven toppings
     */
    @Test
    void smallNewYorkByoSevenTopping() {
        Pizza smallNewYorkByoSevenTopping = nyPizzaFactory.createBuildYourOwn();
        smallNewYorkByoSevenTopping.setSize(Size.SMALL);
        assertTrue(smallNewYorkByoSevenTopping.add(Topping.SAUSAGE));
        assertTrue(smallNewYorkByoSevenTopping.add(Topping.BEEF));
        assertTrue(smallNewYorkByoSevenTopping.add(Topping.HAM));
        assertTrue(smallNewYorkByoSevenTopping.add(Topping.PEPPERONI));
        assertTrue(smallNewYorkByoSevenTopping.add(Topping.GREEN_PEPPER));
        assertTrue(smallNewYorkByoSevenTopping.add(Topping.ONION));
        assertTrue(smallNewYorkByoSevenTopping.add(Topping.MUSHROOM));
        assertEquals(smallNewYorkByoSevenTopping.price(), smallBuildYourOwnPrice + (toppingPrice * 7));
    }

    /**
     * Test small New York build your own pizza with eight toppings and expect to
     * return false when we try to add the eighth topping
     */
    @Test
    void smallNewYorkByoEightTopping() {
        Pizza smallNewYorkByoEightTopping = nyPizzaFactory.createBuildYourOwn();
        smallNewYorkByoEightTopping.setSize(Size.SMALL);
        assertTrue(smallNewYorkByoEightTopping.add(Topping.SAUSAGE));
        assertTrue(smallNewYorkByoEightTopping.add(Topping.BEEF));
        assertTrue(smallNewYorkByoEightTopping.add(Topping.HAM));
        assertTrue(smallNewYorkByoEightTopping.add(Topping.PEPPERONI));
        assertTrue(smallNewYorkByoEightTopping.add(Topping.GREEN_PEPPER));
        assertTrue(smallNewYorkByoEightTopping.add(Topping.ONION));
        assertTrue(smallNewYorkByoEightTopping.add(Topping.MUSHROOM));
        assertFalse(smallNewYorkByoEightTopping.add(Topping.PINEAPPLE));
    }

    /**
     * Test medium NewYork build your own pizza with no toppings
     */
    @Test
    void mediumNewYorkByoNoTopping() {
        Pizza mediumNewYorkByoNoTopping = nyPizzaFactory.createBuildYourOwn();
        mediumNewYorkByoNoTopping.setSize(Size.MEDIUM);
        assertEquals(mediumNewYorkByoNoTopping.price(), mediumBuildYourOwnPrice);
    }

    /**
     * Test medium NewYork build your own pizza with one topping
     */
    @Test
    void mediumNewYorkByoOneTopping() {
        Pizza mediumNewYorkByoOneTopping = nyPizzaFactory.createBuildYourOwn();
        mediumNewYorkByoOneTopping.setSize(Size.MEDIUM);
        assertTrue(mediumNewYorkByoOneTopping.add(Topping.SAUSAGE));
        assertEquals(mediumNewYorkByoOneTopping.price(), mediumBuildYourOwnPrice + toppingPrice);
    }

    /**
     * Test medium NewYork build your own pizza with two toppings
     */
    @Test
    void mediumNewYorkByoTwoTopping() {
        Pizza mediumNewYorkByoTwoTopping = nyPizzaFactory.createBuildYourOwn();
        mediumNewYorkByoTwoTopping.setSize(Size.MEDIUM);
        assertTrue(mediumNewYorkByoTwoTopping.add(Topping.SAUSAGE));
        assertTrue(mediumNewYorkByoTwoTopping.add(Topping.BEEF));
        assertEquals(mediumNewYorkByoTwoTopping.price(), mediumBuildYourOwnPrice + (toppingPrice * 2));
    }

    /**
     * Test medium NewYork build your own pizza with three toppings
     */
    @Test
    void mediumNewYorkByoThreeTopping() {
        Pizza mediumNewYorkByoThreeTopping = nyPizzaFactory.createBuildYourOwn();
        mediumNewYorkByoThreeTopping.setSize(Size.MEDIUM);
        assertTrue(mediumNewYorkByoThreeTopping.add(Topping.SAUSAGE));
        assertTrue(mediumNewYorkByoThreeTopping.add(Topping.BEEF));
        assertTrue(mediumNewYorkByoThreeTopping.add(Topping.HAM));
        assertEquals(mediumNewYorkByoThreeTopping.price(), mediumBuildYourOwnPrice + (toppingPrice * 3));
    }

    /**
     * Test medium NewYork build your own pizza with four toppings
     */
    @Test
    void mediumNewYorkByoFourTopping() {
        Pizza mediumNewYorkByoFourTopping = nyPizzaFactory.createBuildYourOwn();
        mediumNewYorkByoFourTopping.setSize(Size.MEDIUM);
        assertTrue(mediumNewYorkByoFourTopping.add(Topping.SAUSAGE));
        assertTrue(mediumNewYorkByoFourTopping.add(Topping.BEEF));
        assertTrue(mediumNewYorkByoFourTopping.add(Topping.HAM));
        assertTrue(mediumNewYorkByoFourTopping.add(Topping.PEPPERONI));
        assertEquals(mediumNewYorkByoFourTopping.price(), mediumBuildYourOwnPrice + (toppingPrice * 4));
    }

    /**
     * Test medium NewYork build your own pizza with five toppings
     */
    @Test
    void mediumNewYorkByoFiveTopping() {
        Pizza mediumNewYorkByoFiveTopping = nyPizzaFactory.createBuildYourOwn();
        mediumNewYorkByoFiveTopping.setSize(Size.MEDIUM);
        assertTrue(mediumNewYorkByoFiveTopping.add(Topping.SAUSAGE));
        assertTrue(mediumNewYorkByoFiveTopping.add(Topping.BEEF));
        assertTrue(mediumNewYorkByoFiveTopping.add(Topping.HAM));
        assertTrue(mediumNewYorkByoFiveTopping.add(Topping.PEPPERONI));
        assertTrue(mediumNewYorkByoFiveTopping.add(Topping.GREEN_PEPPER));
        assertEquals(mediumNewYorkByoFiveTopping.price(), mediumBuildYourOwnPrice + (toppingPrice * 5));
    }

    /**
     * Test medium NewYork build your own pizza with six toppings
     */
    @Test
    void mediumNewYorkByoSixTopping() {
        Pizza mediumNewYorkByoSixTopping = nyPizzaFactory.createBuildYourOwn();
        mediumNewYorkByoSixTopping.setSize(Size.MEDIUM);
        assertTrue(mediumNewYorkByoSixTopping.add(Topping.SAUSAGE));
        assertTrue(mediumNewYorkByoSixTopping.add(Topping.BEEF));
        assertTrue(mediumNewYorkByoSixTopping.add(Topping.HAM));
        assertTrue(mediumNewYorkByoSixTopping.add(Topping.PEPPERONI));
        assertTrue(mediumNewYorkByoSixTopping.add(Topping.GREEN_PEPPER));
        assertTrue(mediumNewYorkByoSixTopping.add(Topping.ONION));
        assertEquals(mediumNewYorkByoSixTopping.price(), mediumBuildYourOwnPrice + (toppingPrice * 6));
    }

    /**
     * Test medium NewYork build your own pizza with seven toppings
     */
    @Test
    void mediumNewYorkByoSevenTopping() {
        Pizza mediumNewYorkByoSevenTopping = nyPizzaFactory.createBuildYourOwn();
        mediumNewYorkByoSevenTopping.setSize(Size.MEDIUM);
        assertTrue(mediumNewYorkByoSevenTopping.add(Topping.SAUSAGE));
        assertTrue(mediumNewYorkByoSevenTopping.add(Topping.BEEF));
        assertTrue(mediumNewYorkByoSevenTopping.add(Topping.HAM));
        assertTrue(mediumNewYorkByoSevenTopping.add(Topping.PEPPERONI));
        assertTrue(mediumNewYorkByoSevenTopping.add(Topping.GREEN_PEPPER));
        assertTrue(mediumNewYorkByoSevenTopping.add(Topping.ONION));
        assertTrue(mediumNewYorkByoSevenTopping.add(Topping.MUSHROOM));
        assertEquals(mediumNewYorkByoSevenTopping.price(), mediumBuildYourOwnPrice + (toppingPrice * 7));
    }

    /**
     * Test medium New York build your own pizza with eight toppings and expect to
     * return false when we try to add the eighth topping
     */
    @Test
    void mediumNewYorkByoEightTopping() {
        Pizza mediumNewYorkEightTopping = nyPizzaFactory.createBuildYourOwn();
        mediumNewYorkEightTopping.setSize(Size.MEDIUM);
        assertTrue(mediumNewYorkEightTopping.add(Topping.SAUSAGE));
        assertTrue(mediumNewYorkEightTopping.add(Topping.BEEF));
        assertTrue(mediumNewYorkEightTopping.add(Topping.HAM));
        assertTrue(mediumNewYorkEightTopping.add(Topping.PEPPERONI));
        assertTrue(mediumNewYorkEightTopping.add(Topping.GREEN_PEPPER));
        assertTrue(mediumNewYorkEightTopping.add(Topping.ONION));
        assertTrue(mediumNewYorkEightTopping.add(Topping.MUSHROOM));
        assertFalse(mediumNewYorkEightTopping.add(Topping.PINEAPPLE));
    }

    /**
     * Test large NewYork build your own pizza with no toppings
     */
    @Test
    void largeNewYorkByoNoTopping() {
        Pizza largeNewYorkByoNoTopping = nyPizzaFactory.createBuildYourOwn();
        largeNewYorkByoNoTopping.setSize(Size.LARGE);
        assertEquals(largeNewYorkByoNoTopping.price(), largeBuildYourOwnPrice);
    }

    /**
     * Test large NewYork build your own pizza with one topping
     */
    @Test
    void largeNewYorkByoOneTopping() {
        Pizza largeNewYorkByoOneTopping = nyPizzaFactory.createBuildYourOwn();
        largeNewYorkByoOneTopping.setSize(Size.LARGE);
        assertTrue(largeNewYorkByoOneTopping.add(Topping.SAUSAGE));
        assertEquals(largeNewYorkByoOneTopping.price(), largeBuildYourOwnPrice + toppingPrice);
    }

    /**
     * Test large NewYork build your own pizza with two toppings
     */
    @Test
    void largeNewYorkByoTwoTopping() {
        Pizza largeNewYorkByoTwoTopping = nyPizzaFactory.createBuildYourOwn();
        largeNewYorkByoTwoTopping.setSize(Size.LARGE);
        assertTrue(largeNewYorkByoTwoTopping.add(Topping.SAUSAGE));
        assertTrue(largeNewYorkByoTwoTopping.add(Topping.BEEF));
        assertEquals(largeNewYorkByoTwoTopping.price(), largeBuildYourOwnPrice + (toppingPrice * 2));
    }

    /**
     * Test large NewYork build your own pizza with three toppings
     */
    @Test
    void largeNewYorkByoThreeTopping() {
        Pizza largeNewYorkByoThreeTopping = nyPizzaFactory.createBuildYourOwn();
        largeNewYorkByoThreeTopping.setSize(Size.LARGE);
        assertTrue(largeNewYorkByoThreeTopping.add(Topping.SAUSAGE));
        assertTrue(largeNewYorkByoThreeTopping.add(Topping.BEEF));
        assertTrue(largeNewYorkByoThreeTopping.add(Topping.HAM));
        assertEquals(largeNewYorkByoThreeTopping.price(), largeBuildYourOwnPrice + (toppingPrice * 3));
    }

    /**
     * Test large NewYork build your own pizza with four toppings
     */
    @Test
    void largeNewYorkByoFourTopping() {
        Pizza largeNewYorkByoFourTopping = nyPizzaFactory.createBuildYourOwn();
        largeNewYorkByoFourTopping.setSize(Size.LARGE);
        assertTrue(largeNewYorkByoFourTopping.add(Topping.SAUSAGE));
        assertTrue(largeNewYorkByoFourTopping.add(Topping.BEEF));
        assertTrue(largeNewYorkByoFourTopping.add(Topping.HAM));
        assertTrue(largeNewYorkByoFourTopping.add(Topping.PEPPERONI));
        assertEquals(largeNewYorkByoFourTopping.price(), largeBuildYourOwnPrice + (toppingPrice * 4));
    }

    /**
     * Test large NewYork build your own pizza with five toppings
     */
    @Test
    void largeNewYorkByoFiveTopping() {
        Pizza largeNewYorkByoFiveTopping = nyPizzaFactory.createBuildYourOwn();
        largeNewYorkByoFiveTopping.setSize(Size.LARGE);
        assertTrue(largeNewYorkByoFiveTopping.add(Topping.SAUSAGE));
        assertTrue(largeNewYorkByoFiveTopping.add(Topping.BEEF));
        assertTrue(largeNewYorkByoFiveTopping.add(Topping.HAM));
        assertTrue(largeNewYorkByoFiveTopping.add(Topping.PEPPERONI));
        assertTrue(largeNewYorkByoFiveTopping.add(Topping.GREEN_PEPPER));
        assertEquals(largeNewYorkByoFiveTopping.price(), largeBuildYourOwnPrice + (toppingPrice * 5));
    }

    /**
     * Test large NewYork build your own pizza with six toppings
     */
    @Test
    void largeNewYorkByoSixTopping() {
        Pizza largeNewYorkByoSixTopping = nyPizzaFactory.createBuildYourOwn();
        largeNewYorkByoSixTopping.setSize(Size.LARGE);
        assertTrue(largeNewYorkByoSixTopping.add(Topping.SAUSAGE));
        assertTrue(largeNewYorkByoSixTopping.add(Topping.BEEF));
        assertTrue(largeNewYorkByoSixTopping.add(Topping.HAM));
        assertTrue(largeNewYorkByoSixTopping.add(Topping.PEPPERONI));
        assertTrue(largeNewYorkByoSixTopping.add(Topping.GREEN_PEPPER));
        assertTrue(largeNewYorkByoSixTopping.add(Topping.ONION));
        assertEquals(largeNewYorkByoSixTopping.price(), largeBuildYourOwnPrice + (toppingPrice * 6));
    }

    /**
     * Test large NewYork build your own pizza with seven toppings
     */
    @Test
    void largeNewYorkByoSevenTopping() {
        Pizza largeNewYorkByoSevenTopping = nyPizzaFactory.createBuildYourOwn();
        largeNewYorkByoSevenTopping.setSize(Size.LARGE);
        assertTrue(largeNewYorkByoSevenTopping.add(Topping.SAUSAGE));
        assertTrue(largeNewYorkByoSevenTopping.add(Topping.BEEF));
        assertTrue(largeNewYorkByoSevenTopping.add(Topping.HAM));
        assertTrue(largeNewYorkByoSevenTopping.add(Topping.PEPPERONI));
        assertTrue(largeNewYorkByoSevenTopping.add(Topping.GREEN_PEPPER));
        assertTrue(largeNewYorkByoSevenTopping.add(Topping.ONION));
        assertTrue(largeNewYorkByoSevenTopping.add(Topping.MUSHROOM));
        assertEquals(largeNewYorkByoSevenTopping.price(), largeBuildYourOwnPrice + (toppingPrice * 7));
    }

    /**
     * Test large New York build your own pizza with eight toppings and expect to
     * return false when we try to add the eighth topping
     */
    @Test
    void largeNewYorkByoEightTopping() {
        Pizza largeNewYorkByoEightTopping = nyPizzaFactory.createBuildYourOwn();
        largeNewYorkByoEightTopping.setSize(Size.LARGE);
        assertTrue(largeNewYorkByoEightTopping.add(Topping.SAUSAGE));
        assertTrue(largeNewYorkByoEightTopping.add(Topping.BEEF));
        assertTrue(largeNewYorkByoEightTopping.add(Topping.HAM));
        assertTrue(largeNewYorkByoEightTopping.add(Topping.PEPPERONI));
        assertTrue(largeNewYorkByoEightTopping.add(Topping.GREEN_PEPPER));
        assertTrue(largeNewYorkByoEightTopping.add(Topping.ONION));
        assertTrue(largeNewYorkByoEightTopping.add(Topping.MUSHROOM));
        assertFalse(largeNewYorkByoEightTopping.add(Topping.PINEAPPLE));
    }
}