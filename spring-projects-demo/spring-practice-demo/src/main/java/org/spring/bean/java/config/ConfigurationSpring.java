package org.spring.bean.java.config;

import org.spring.bean.component.SadFortuneService;
import org.spring.bean.component.SwimCoach;
import org.spring.interfaces.Coach;
import org.spring.interfaces.FortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("spring.java.testpring.component")
public class ConfigurationSpring {

    // define the fortune Service
    @Bean
    public FortuneService getSadFortuneService() {
        return new SadFortuneService();
    }

    @Bean
    public Coach getCoach() {
        return new SwimCoach(getSadFortuneService());
    }


    // define the swim bean and inject the dependency

}
