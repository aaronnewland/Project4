package com.example.project4.pizzastyles;

import com.example.project4.enums.Crust;
import com.example.project4.Pizza;
import com.example.project4.enums.PizzaStyle;
import com.example.project4.flavors.BBQChicken;
import com.example.project4.flavors.BuildYourOwn;
import com.example.project4.flavors.Deluxe;
import com.example.project4.flavors.Meatzza;
import com.example.project4.interfaces.PizzaFactory;

public class ChicagoPizza implements PizzaFactory {
    @Override
    public Pizza createDeluxe() {
        Pizza ChicagoStyleDeluxe = new Deluxe(PizzaStyle.CHICAGO);
        ChicagoStyleDeluxe.setCrust(Crust.DEEP_DISH);
        return ChicagoStyleDeluxe;
    }

    @Override
    public Pizza createMeatzza() {
        Pizza ChicagoStyleMeatzza = new Meatzza(PizzaStyle.CHICAGO);
        ChicagoStyleMeatzza.setCrust(Crust.STUFFED);
        return ChicagoStyleMeatzza;
    }

    @Override
    public Pizza createBBQChicken() {
        Pizza ChicagoStyleBBQChicken = new BBQChicken(PizzaStyle.CHICAGO);
        ChicagoStyleBBQChicken.setCrust(Crust.PAN);
        return ChicagoStyleBBQChicken;
    }

    @Override
    public Pizza createBuildYourOwn() {
        Pizza ChicagoStyleBuildYourOwn = new BuildYourOwn(PizzaStyle.CHICAGO);
        ChicagoStyleBuildYourOwn.setCrust(Crust.PAN);
        return ChicagoStyleBuildYourOwn;
    }
}
