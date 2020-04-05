package org.spring.bean.component;

import org.spring.interfaces.Coach;
import org.spring.interfaces.FortuneService;

public class SwimCoach implements Coach {

    FortuneService fortuneService;

    public SwimCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getDailyWorkOut() {
        // TODO Auto-generated method stub
        return "Do Daily WorkOut";
    }

    public String getTodayFortune() {
        // TODO Auto-generated method stub
        return fortuneService.getLuckyDay();
    }

}
