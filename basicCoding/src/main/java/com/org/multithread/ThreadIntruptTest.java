package com.org.multithread;

import java.util.Random;

import net.jcip.annotations.GuardedBy;


public class ThreadIntruptTest {

	@GuardedBy("this") int local;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

	 Random random = new Random(); 
		
		
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<1E8;i++){
					if(Thread.currentThread().isInterrupted()){
						break;
					}
					Math.sin(random.nextDouble());
				}
			}
		});
		
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<1E8;i++){
					if(Thread.currentThread().isInterrupted()){
						break;
					}
					
					if(i==1E4){
						System.out.println("Yield method is called");
						Thread.yield();
						System.out.println("Yield method is Got the control");
					}
					Math.sin(random.nextDouble());
				}
			}
		});
		
		long starttime = System.currentTimeMillis();
		System.out.println("Started ");
		t.start();
		t2.start();
		
		Thread.sleep(1000);
		
		//t.interrupt();
		
		t.join();
		
		
		System.out.println("finish ");
		
		System.out.println(System.currentTimeMillis()-starttime);
	}

}
