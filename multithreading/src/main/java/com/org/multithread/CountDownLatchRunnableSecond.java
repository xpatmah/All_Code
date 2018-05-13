package com.org.multithread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchRunnableSecond implements Runnable{

	CountDownLatch latch ;
	
	public CountDownLatchRunnableSecond(CountDownLatch latch) {
			this.latch =latch;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  System.out.println(this.getClass().getName()+" My Work completed");
		latch.countDown();
	}

}
