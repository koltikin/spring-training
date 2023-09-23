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

        Case appleCaseWithBeanFactory = container.getBean("DellCase",Case.class);

//        appleCaseWithBeanFactory.pressPowerButton();

        /** custom bean name */

        Monitor sonyMonitor = container.getBean("sony",Monitor.class); // use custom bean name @Bean(name = "sony")

        System.out.println(sonyMonitor.getManufacturer());

    }




}
