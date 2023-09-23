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
import org.springframework.context.annotation.Primary;

@Configuration
public class ComputerConfig {
    @Bean("dell")
    public Case DellCase(){
        return new DellCase("220B", "Dell", "240");
    }
    @Bean("hp")
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
    @Primary
    public Monitor LgMonitor(){
        return new LgMonitor("31 inch Beast", "Lg", 31);
    }

    @Bean("acer")
    public Monitor AcerMonitor(){
        return new AcerMonitor("27inch Beast", "Acer", 27);
    }

    @Bean(name = "sony")
    public Monitor SonyMonitor(){
        return new SonyMonitor("27inch Beast", "Sony", 27);
    }

    @Bean("asus")
    public MotherBoard AsusMotherBoard(){
        return new AsusMotherBoard("BJ-200", "Asus", 4, 6, "v2.44");
    }



}
