package com.cydeo.beanAnnotaion.config;

import com.cydeo.beanAnnotaion.casefactory.Case;
import com.cydeo.beanAnnotaion.casefactory.DellCase;
import com.cydeo.beanAnnotaion.monitorfactory.AcerMonitor;
import com.cydeo.beanAnnotaion.monitorfactory.LgMonitor;
import com.cydeo.beanAnnotaion.monitorfactory.Monitor;
import com.cydeo.beanAnnotaion.monitorfactory.SonyMonitor;
import com.cydeo.beanAnnotaion.motherboardfactory.AsusMotherBoard;
import com.cydeo.beanAnnotaion.motherboardfactory.MotherBoard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComputerConfig {
    @Bean
    public Case DellCase(){
        return new DellCase("220B", "Dell", "240");
    }
    @Bean
    public Case HpCase(){
        Case hpCase = new Case("220B", "Dell", "240") {
            @Override
            public void pressPowerButton() {
                System.out.println("Hp case's Power button pressed");
            }
        };
        return hpCase;
    }
    @Bean
    public Monitor LgMonitor(){
        return new LgMonitor("31 inch Beast", "Lg", 31);
    }

    @Bean
    public Monitor AcerMonitor(){
        return new AcerMonitor("27inch Beast", "Acer", 27);
    }

    @Bean(name = "sony")
    public Monitor SonyMonitor(){
        return new SonyMonitor("27inch Beast", "Sony", 27);
    }

    @Bean
    public MotherBoard AsusMotherBoard(){
        return new AsusMotherBoard("BJ-200", "Asus", 4, 6, "v2.44");
    }



}
