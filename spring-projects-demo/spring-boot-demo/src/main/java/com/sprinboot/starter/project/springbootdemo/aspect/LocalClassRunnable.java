package com.sprinboot.starter.project.springbootdemo.aspect;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier(value="localRunnabl")
public class LocalClassRunnable implements Runnable{

	
	@Override
	@Loggable(value="XYZ")
	public void run() {
		System.out.println("HELLO");
		
	}

}
