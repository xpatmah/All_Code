package spring.java.testpring;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.org.component.spring.config.ConfigurationSpring;

import spring.java.testpring.component.DefaultBeanComponent;
import spring.java.testpring.component.Rectangle;
import spring.java.testpring.component.TenisCoach;


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
