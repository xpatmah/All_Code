package com.example.demo.aspect;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class HandlerClass {

	@Loggable(value="LOGGER_TIME")
	public void mainMethod()  {
		try {
			Thread.sleep(new Random().nextInt(10)*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Print the class");	
	}
	
}
