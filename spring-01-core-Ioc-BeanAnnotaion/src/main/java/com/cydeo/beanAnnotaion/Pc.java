package com.cydeo.beanAnnotaion;


import com.cydeo.beanAnnotaion.casefactory.Case;
import com.cydeo.beanAnnotaion.monitorfactory.Monitor;
import com.cydeo.beanAnnotaion.motherboardfactory.MotherBoard;
import lombok.Data;

@Data
public class Pc {

    private Case aCase;
    private Monitor monitor;
    private MotherBoard motherBoard;

    public Pc(Case aCase, Monitor monitor, MotherBoard motherBoard) {
        this.aCase = aCase;
        this.monitor = monitor;
        this.motherBoard = motherBoard;
    }

    public void powerUp() {
        aCase.pressPowerButton();
        drawLogo();
    }

    private void drawLogo() {
        monitor.drawPixelAt(1200, 50, "yellow");
    }

}
