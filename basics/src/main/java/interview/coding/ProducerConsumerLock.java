package com.java.basic.interview.coding;



public class ProducerConsumerLock {

	
	public static void main(String[] args) {
		Worker worker = new Worker();
		
		Thread t1 = new Thread(()-> {
			try {
				worker.consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Thread t2 = new Thread(()-> {
			try {
				worker.produce();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
