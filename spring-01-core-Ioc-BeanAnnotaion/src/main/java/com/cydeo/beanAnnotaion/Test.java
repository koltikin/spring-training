package com.cydeo.beanAnnotaion;

import com.cydeo.beanAnnotaion.casefactory.Case;
import com.cydeo.beanAnnotaion.config.CaseConfig;
import com.cydeo.beanAnnotaion.config.ComputerConfig;
import com.cydeo.beanAnnotaion.monitorfactory.Monitor;
import com.cydeo.beanAnnotaion.motherboardfactory.MotherBoard;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        /** create container use ApplicationContext interface */
        ApplicationContext context = new AnnotationConfigApplicationContext(ComputerConfig.class);

//        if there is more than one config class we can use like this
        ApplicationContext context1 = new AnnotationConfigApplicationContext(ComputerConfig.class, CaseConfig.class);

        Monitor monitor = context.getBean("LgMonitor",Monitor.class); // get the monitor with default bean name
        // (default bean name is the name of the method inside the config class)
//        System.out.println(monitor.getManufacturer());

        Case appleCase = context1.getBean("appleCase", Case.class);
//        appleCase.pressPowerButton();


        /** create container use BeanFactory interface */

        BeanFactory container = new AnnotationConfigApplicationContext(ComputerConfig.class);

//        Case appleCaseWithBeanFactory = container.getBean("DellCase",Case.class);

//        appleCaseWithBeanFactory.pressPowerButton();

        /** custom bean name */

        Monitor sonyMonitor = container.getBean("sony",Monitor.class); // use custom bean name @Bean(name = "sony")

//        System.out.println(sonyMonitor.getManufacturer());

        /** primary bean @Primary */

        Case theCase = context1.getBean(Case.class);   // use primary Apple Case
        Monitor theMonitor = context1.getBean(Monitor.class);   // use primary LgMonitor
        MotherBoard theMotherBoard = container.getBean(MotherBoard.class); // user primary AsusMotherBoard

        Pc myPc1 = new Pc(theCase,theMonitor,theMotherBoard);

        System.out.println("**************** myPc1 ********************");

        myPc1.powerUp();
        myPc1.getMotherBoard().loadProgram("Spring IOC");

        /** name bean */
        Case myCase = context1.getBean("dell",Case.class);
        Monitor myMonitor = context1.getBean("sony",Monitor.class);
        MotherBoard myMotherBoard = container.getBean("asus",MotherBoard.class); // if the bean is only one it doesn't care the bean name

        Pc myPc2 = new Pc(myCase,myMonitor,myMotherBoard);

        System.out.println("**************** myPc2 ********************");

        myPc2.powerUp();
        myPc2.getMotherBoard().loadProgram("Spring IOC");

    }




}
