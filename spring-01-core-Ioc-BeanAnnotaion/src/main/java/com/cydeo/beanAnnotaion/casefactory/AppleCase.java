package com.cydeo.beanAnnotaion.casefactory;

public class AppleCase extends Case{
    public AppleCase(String model, String manufacturer, String powerSupply) {
        super(model, manufacturer, powerSupply);
    }

    @Override
    public void pressPowerButton() {
        System.out.println("Apple Case's Power button pressed");
    }
}
