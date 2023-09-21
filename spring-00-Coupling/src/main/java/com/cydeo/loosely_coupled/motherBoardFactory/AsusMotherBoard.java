package com.cydeo.loosely_coupled.motherBoardFactory;

public class AsusMotherBoard extends MotherBoard{

    public AsusMotherBoard(String model, String manufacturer, int ramSlots, int cardSlots, String bios) {
        super(model, manufacturer, ramSlots, cardSlots, bios);
    }

    @Override
    public void loadProgram(String programName) {
        System.out.println("the program " + programName + " is loading.... with AsusMotherBoard");
    }
}
