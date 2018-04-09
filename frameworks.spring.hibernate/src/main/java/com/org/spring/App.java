package com.org.spring;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.org.spring.bean.component.DefaultBeanComponent;
import com.org.spring.bean.component.Rectangle;
import com.org.spring.bean.component.TenisCoach;
import com.org.spring.bean.java.config.ConfigurationSpring;


public class App 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
    	
    	//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationSpring.class);
    	
    	TenisCoach coach = context.getBean("tenissCoach" , TenisCoach.class);
    	
    	System.out.println(coach.getDailyWorkOut());
    	System.out.println(coach.getTodayFortune());
    	
    	context.close();
    	
    }
}
