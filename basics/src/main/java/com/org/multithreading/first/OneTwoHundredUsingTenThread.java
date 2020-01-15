package com.org.multithreading.first;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class OneTwoHundredUsingTenThread {

	private Object obj = new Object();
	
	private AtomicInteger atomicA = new AtomicInteger(1);
	
	class ExecutorRunnable implements Runnable {

		int i;
		
		public ExecutorRunnable(int i){
			this.i = i;
		}
		
		@Override
		public void run() {
			while(true) {
				synchronized (obj) {
					while(atomicA.get() != i) {
						try {
							if(i > Math.pow(2, 10)) {
								 break;
							 }
							//System.out.println("Thread goes to wait "+i);
							obj.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				// System.out.print(i+" ");
				 i = i+10;
				 atomicA.incrementAndGet();
				 obj.notifyAll(); 
				 if(i > Math.pow(2, 10)) {
					 break;
				 }
				}
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
   
		ExecutorService executor = Executors.newFixedThreadPool(10);
		
		OneTwoHundredUsingTenThread hi = new OneTwoHundredUsingTenThread();
	    long starttime = System.currentTimeMillis();
		
		for(int i =1 ; i<= 10;i++) {
			executor.execute(hi.new ExecutorRunnable(i));
		}
		
		executor.shutdown();
		
		executor.awaitTermination(1000, TimeUnit.MINUTES);
		
		System.out.println(System.currentTimeMillis() - starttime);
		
		starttime = System.currentTimeMillis();
		
		for(int i = 0 ; i < Math.pow(2, 10);i++) {
		   int j = i+10;
		}
		System.out.println(System.currentTimeMillis() - starttime);

	}

}
