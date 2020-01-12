package com.example.demo.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleService  {

	@Autowired
	private HandlerClass handlerClass;
	
	/*
	 * @Autowired
	 * 
	 * @Qualifier(value="localRunnabl") private Runnable localRunnable;
	 */
	
	
	@RequestMapping("/home")
	String home() {
		ExecutorService service = Executors.newFixedThreadPool(10);
		for(int i = 0 ; i <10;i++) {
			
			  service.submit(new Runnable() {
			  
			  @Override public void run() { handlerClass.mainMethod(); } });
			 
			/* service.submit(localRunnable); */
			//localRunnable.run();
		}
		return "Hello World!";
	}
}