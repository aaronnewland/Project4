package com.example.project4.interfaces;

import com.example.project4.Pizza;

public interface PizzaFactory {
    Pizza createDeluxe();
    Pizza createMeatzza();
    Pizza createBBQChicken();
    Pizza createBuildYourOwn();
}
