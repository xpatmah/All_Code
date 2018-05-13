package com.org.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecuterPoolClassTest {

	
	public static void main(String[] args){
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		for(int i=0;i<10;i++){
			service.submit(new RunnableClass(i));
		}
		
		service.shutdown();
		
		System.out.println("All task has been submitted");
		
		
		try {
			service.awaitTermination(2, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("All task completed ");
		
		
	}
	
	
	
	
}
