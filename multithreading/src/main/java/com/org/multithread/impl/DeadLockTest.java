package com.org.multithread.impl;

public class DeadLockTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		AccountRunnable acc = new AccountRunnable();
		
		Thread t1 =new Thread(new Runnable() {
			@Override
			public void run() {
				acc.firstThread();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				acc.secodThread();
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
        acc.totalAmount();
		
	}

}
