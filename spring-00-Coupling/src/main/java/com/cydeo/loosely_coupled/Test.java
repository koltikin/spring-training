package com.cydeo.loosely_coupled;

import com.cydeo.loosely_coupled.caseFactory.Case;
import com.cydeo.loosely_coupled.caseFactory.DellCase;
import com.cydeo.loosely_coupled.monitorFactory.AcerMonitor;
import com.cydeo.loosely_coupled.monitorFactory.LgMonitor;
import com.cydeo.loosely_coupled.monitorFactory.Monitor;
import com.cydeo.loosely_coupled.motherBoardFactory.AsusMotherBoard;
import com.cydeo.loosely_coupled.motherBoardFactory.MotherBoard;


public class Test {
    public static void main(String[] args) {
        Monitor theMonitor = new AcerMonitor("27inch Beast", "Acer", 27);
        Case theCase = new DellCase("220B", "Dell", "240");
        MotherBoard theMotherboard = new AsusMotherBoard("BJ-200", "Asus", 4, 6, "v2.44");

        Pc myPc = new Pc(theCase,theMonitor,theMotherboard);

        myPc.powerUp();


    }
}

