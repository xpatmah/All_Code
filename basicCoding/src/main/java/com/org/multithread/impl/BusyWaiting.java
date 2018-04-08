package com.org.multithread.impl;

public class BusyWaiting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MySignal sig = new MySignal();
				
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				
				while(!sig.hasDatatoProcess()) {
				}
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				
				try {
					Thread.sleep(10000);
					sig.setDataToProcess(true);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
