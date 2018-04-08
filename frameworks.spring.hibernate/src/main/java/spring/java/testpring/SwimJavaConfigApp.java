package spring.java.testpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.org.component.spring.config.ConfigurationSpring;

import spring.java.testpring.component.SwimCoach;

public class SwimJavaConfigApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationSpring.class);
		
		SwimCoach coach = context.getBean("getCoach", SwimCoach.class);
		
		System.out.println(coach.getDailyWorkOut());
		
		System.out.println(coach.getTodayFortune());
		
		
		context.close();
		
	}

}
