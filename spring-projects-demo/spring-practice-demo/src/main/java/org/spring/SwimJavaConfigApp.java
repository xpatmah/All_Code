package org.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.spring.bean.component.SwimCoach;
import org.spring.bean.java.config.ConfigurationSpring;

public class SwimJavaConfigApp {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ConfigurationSpring.class);
        context.refresh();
        SwimCoach coach = context.getBean("getCoach", SwimCoach.class);

        System.out.println(coach.getDailyWorkOut());

        System.out.println(coach.getTodayFortune());

        context.close();
    }

}
