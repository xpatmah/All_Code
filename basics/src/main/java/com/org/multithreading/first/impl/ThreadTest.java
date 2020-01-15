package com.org.multithreading.first.impl;

public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Signal sig = new Signal();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("First Thread");
				sig.doWait();
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Second Thread");
				sig.doWait();
				
			}
		});
		
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Third Thread");
				sig.donotify();
			}
		});
		
		/*Thread t4 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(20000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Third Thread");
				sig.donotify();
			}
		});*/
		
		t1.start();
		t2.start();
		t3.start();
		//t4.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		//	t4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
