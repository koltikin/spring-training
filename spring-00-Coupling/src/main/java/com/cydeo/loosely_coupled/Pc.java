package com.cydeo.loosely_coupled;

import com.cydeo.loosely_coupled.caseFactory.Case;
import com.cydeo.loosely_coupled.monitorFactory.Monitor;
import com.cydeo.loosely_coupled.motherBoardFactory.MotherBoard;

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
