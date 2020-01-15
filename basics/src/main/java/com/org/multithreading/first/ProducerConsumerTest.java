package com.org.multithreading.first;

public class ProducerConsumerTest {

	public static void main(String[] args){
		
		ProducerConsumer prodC = new ProducerConsumer();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				prodC.producerThread();
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				prodC.consumerThread();
			}
		}).start();
		
		
	}
	
	
	
	
}
