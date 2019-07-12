package com.example.demo.aspect;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Example {

	@Autowired
	private HandlerClass handlerClass;
	
	@RequestMapping("/home")
	String home() {
		ExecutorService service = Executors.newFixedThreadPool(10);
		for(int i = 0 ; i <10;i++) {
			service.submit(new Runnable() {
				@Override
				public void run() {
					handlerClass.mainMethod();	
				}
			});
		}
		return "Hello World!";
	}

}