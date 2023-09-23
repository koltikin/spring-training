package com.cydeo.beanAnnotaion;

import com.cydeo.beanAnnotaion.config.ComputerConfig;
import com.cydeo.beanAnnotaion.monitorfactory.Monitor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ComputerConfig.class);

        Monitor monitor = context.getBean("LgMonitor",Monitor.class); // get the monitor with default bean name
        // (default bean name is the name of the method inside the config class)
        System.out.println(monitor.getManufacturer());

    }




}
