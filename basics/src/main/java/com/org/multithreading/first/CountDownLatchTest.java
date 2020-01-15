package com.org.multithreading.first;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CountDownLatch latch = new CountDownLatch(2);
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		
	   	
		service.submit(new CountDownLatchRunnable(latch));
		service.submit(new CountDownLatchRunnableSecond(latch));
		service.submit(new CountDownLatchRunnableSecond(latch));
		System.out.println("All Task has been submitted");
		
		service.shutdown();
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("All Task has been completed");
	}

}
