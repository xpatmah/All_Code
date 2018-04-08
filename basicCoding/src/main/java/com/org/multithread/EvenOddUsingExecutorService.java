package com.org.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EvenOddUsingExecutorService {

	private Object obj =  new Object();
	
	private boolean isEven = false;
	
	class EvenRunnable implements Runnable{

		int i = 2;
		@Override
		public void run() {
			while(true) {
				synchronized (obj) {
					if(!isEven) {
						try {
							obj.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println(i);
					i = i+2;
					isEven = false;
					obj.notify();
					if(i > 100) {
						break;
					}
				}
			}
		}
	}
	
	class OddRunnable implements Runnable{

		int i = 1;
		@Override
		public void run() {
			while(true){
				synchronized (obj) {
					if(isEven) {
						try {
							obj.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println(i);
					i = i+2;
					isEven = true;
					obj.notify();
					if(i>100) {
						break;
					}
				}
				
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExecutorService executors = Executors.newFixedThreadPool(2);
		
		EvenOddUsingExecutorService ex = new EvenOddUsingExecutorService();
		
		EvenRunnable eve = ex.new EvenRunnable();
		
		OddRunnable odd = ex.new OddRunnable();
		
		executors.submit(eve);
		executors.submit(odd);
		
		try {
			executors.awaitTermination(1, TimeUnit.HOURS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executors.shutdown();
		
	}
	
	
	

}
