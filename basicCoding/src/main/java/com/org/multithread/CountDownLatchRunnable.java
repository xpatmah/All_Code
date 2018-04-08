package com.org.multithread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchRunnable implements Runnable{
	
	CountDownLatch latch;
	
	public CountDownLatchRunnable(CountDownLatch latch) {
			this.latch=latch;
	}

	@Override
	public void run() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(this.getClass().getName()+" My Work completed");
		latch.countDown();

	}
	
    
	
	
}
