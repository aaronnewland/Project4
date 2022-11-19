package com.example.project4;

public class NYPizza implements PizzaFactory {
    @Override
    public Pizza createDeluxe() {
        Pizza NYStyleDeluxe = new Deluxe();
        NYStyleDeluxe.setCrust(Crust.BROOKLYN);
        return NYStyleDeluxe;
    }

    @Override
    public Pizza createMeatzza() {
       Pizza NYStyleMeatzza = new Meatzza();
       NYStyleMeatzza.setCrust(Crust.STUFFED);
       return NYStyleMeatzza;
    }

    @Override
    public Pizza createBBQChicken() {
        Pizza NYStyleBBQChicken = new BBQ_Chicken();
        NYStyleBBQChicken.setCrust(Crust.HAND_TOSSED);
        return NYStyleBBQChicken;
    }

    @Override
    public Pizza createBuildYourOwn() {
        Pizza NYStyleBuildYourOwn = new BuildYourOwn();
        NYStyleBuildYourOwn.setCrust(Crust.HAND_TOSSED);
        return NYStyleBuildYourOwn;
    }
}
