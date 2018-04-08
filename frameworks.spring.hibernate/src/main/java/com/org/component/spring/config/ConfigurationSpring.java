package com.org.component.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.org.spring.faces.Coach;
import com.org.spring.faces.FortuneService;

import spring.java.testpring.component.SadFortuneService;
import spring.java.testpring.component.SwimCoach;

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
		return new SwimCoach(getSadFortuneService() );
	}
	
	
	// define the swim bean and inject the dependency
	
}
