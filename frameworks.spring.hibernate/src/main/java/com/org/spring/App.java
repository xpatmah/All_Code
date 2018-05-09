package com.org.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.org.spring.interfaces.Coach;

public class App 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
    	
    	//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationSpring.class);
    	
    	String[] names = context.getBeanDefinitionNames();
    	for(String name : names) {
    		System.out.println(name);
    	}
    	
    	Coach coach = context.getBean("tenissCoach",Coach.class);
    	
    	System.out.println(coach.getDailyWorkOut());
    	System.out.println(coach.getTodayFortune());
    	
    	context.close();    	
    }
}
