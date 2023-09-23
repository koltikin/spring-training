package com.cydeo.beanAnnotaion.monitorfactory;

public abstract class Monitor {
    private String model;
    private String manufacturer;
    private int size;

    public Monitor(String model, String manufacturer, int size) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.size = size;
    }

    public void drawPixelAt(int x, int y, String color){
        System.out.println("Drawing pixel with " + getClass().getSimpleName() + " at " + x + "," + y + " in colour " + color);
    };
}
