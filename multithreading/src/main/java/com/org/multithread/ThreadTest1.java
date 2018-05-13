package com.org.multithread;

public class ThreadTest1 {

	// sleep will hold the lock until interrupt will happen 
	
	Object obj  = new Object();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ThreadTest1 test = new ThreadTest1();
		
		test.startThread();
	}

	public void startThread(){

		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized (obj) {

					try {
						Thread.sleep(20000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}


			}
		}).start();
		


		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized (obj) {

				   System.out.println("Mahesh");
					
				}


			}
		}).start();
	
	}
	
}
