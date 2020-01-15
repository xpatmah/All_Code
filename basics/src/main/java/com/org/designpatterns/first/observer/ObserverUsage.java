package com.org.designpatterns.first.observer;

public class ObserverUsage {

	
	public static void main(String[] args) throws InterruptedException {
		
		Chennal chann = new Chennal();
		User use = new User();
		User user2 = new User();
		chann.addObsever(use);
		chann.addObsever(user2);
		
		Thread.sleep(1000);
		
		
		chann.addVideo();
		
		
	}
    
	
}
