package com.example.project4;

public class ChicagoPizza implements PizzaFactory {
    @Override
    public Pizza createDeluxe() {
        Pizza ChicagoStyleDeluxe = new Deluxe();
        ChicagoStyleDeluxe.setCrust(Crust.DEEP_DISH);
        return ChicagoStyleDeluxe;
    }

    @Override
    public Pizza createMeatzza() {
        Pizza ChicagoStyleMeatzza = new Meatzza();
        ChicagoStyleMeatzza.setCrust(Crust.STUFFED);
        return ChicagoStyleMeatzza;
    }

    @Override
    public Pizza createBBQChicken() {
        Pizza ChicagoStyleBBQChicken = new BBQ_Chicken();
        ChicagoStyleBBQChicken.setCrust(Crust.PAN);
        return ChicagoStyleBBQChicken;
    }

    @Override
    public Pizza createBuildYourOwn() {
        Pizza ChicagoStyleBuildYourOwn = new BuildYourOwn();
        ChicagoStyleBuildYourOwn.setCrust(Crust.PAN);
        return ChicagoStyleBuildYourOwn;
    }
}
