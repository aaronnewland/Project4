package com.example.project4.pizzastyles;

import com.example.project4.enums.Crust;
import com.example.project4.Pizza;
import com.example.project4.enums.PizzaStyle;
import com.example.project4.flavors.BBQ_Chicken;
import com.example.project4.flavors.BuildYourOwn;
import com.example.project4.flavors.Deluxe;
import com.example.project4.flavors.Meatzza;
import com.example.project4.interfaces.PizzaFactory;

public class NYPizza implements PizzaFactory {
    @Override
    public Pizza createDeluxe() {
        Pizza NYStyleDeluxe = new Deluxe(PizzaStyle.NY);
        NYStyleDeluxe.setCrust(Crust.BROOKLYN);
        return NYStyleDeluxe;
    }

    @Override
    public Pizza createMeatzza() {
       Pizza NYStyleMeatzza = new Meatzza(PizzaStyle.NY);
       NYStyleMeatzza.setCrust(Crust.STUFFED);
       return NYStyleMeatzza;
    }

    @Override
    public Pizza createBBQChicken() {
        Pizza NYStyleBBQChicken = new BBQ_Chicken(PizzaStyle.NY);
        NYStyleBBQChicken.setCrust(Crust.HAND_TOSSED);
        return NYStyleBBQChicken;
    }

    @Override
    public Pizza createBuildYourOwn() {
        Pizza NYStyleBuildYourOwn = new BuildYourOwn(PizzaStyle.NY);
        NYStyleBuildYourOwn.setCrust(Crust.HAND_TOSSED);
        return NYStyleBuildYourOwn;
    }
}
