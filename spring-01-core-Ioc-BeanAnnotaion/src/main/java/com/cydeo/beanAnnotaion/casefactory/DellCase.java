package com.cydeo.beanAnnotaion.casefactory;

public class DellCase extends Case{
    public DellCase(String model, String manufacturer, String powerSupply) {
        super(model, manufacturer, powerSupply);
    }

    @Override
    public void pressPowerButton() {
        System.out.println("Dell case's Power button pressed");
    }
}
