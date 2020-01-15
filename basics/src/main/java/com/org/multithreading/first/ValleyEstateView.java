package com.org.multithreading.first;

public class ValleyEstateView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FlatThread thread = new FlatThread();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				thread.showFlat();
			}
		},"Bhagwan");

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				thread.showFlat();
			}
		},"Suresh");

		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				thread.showFlat();
			}
		},"Tiwari");
		
	
		
		long startTime = System.currentTimeMillis();
		
		t1.start();
		t2.start();
		t3.start();

		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread.printTotalVisite();
        
		System.out.println(System.currentTimeMillis()-startTime);
		
		
	}

}
