package com.org.multithread.impl;

public class CountDownLatch {

	private int count=0;
	
	private Object obj = new Object();
	
	public CountDownLatch(int count) {
		this.count = count;
	}
	
	
	public void await() throws InterruptedException {
		while(true) {
			synchronized (obj) {
				  if(count==0) {
					  return;
				  }
		          obj.wait();   		
			}
		}
	}
	
	public void countDown() {
		synchronized (obj) {
			count--;
			obj.notify();
		}
	}
}
