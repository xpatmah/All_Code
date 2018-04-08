package com.org.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorPoolChecker {

	
	//Threads inside the Executor pool does not run sequentially 
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ExecutorService executors = Executors.newFixedThreadPool(2);
		
		for(int i = 0 ; i <10;i++) {
			executors.execute(new Producer(i));
		}
		
		executors.shutdown();
		
		executors.awaitTermination(10, TimeUnit.SECONDS);
		
	}
	
	

}
