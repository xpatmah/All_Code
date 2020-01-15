package com.org.multithreading.first;

public class Lock {

	private boolean islock = false;
	
	private MyObject obj = new MyObject();

	private int counter =0;
	
	Runnable thisThread = null;
	
	public void lock() {
		synchronized (obj) {
			while(islock && thisThread != Thread.currentThread()) {
				try {
					obj.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			islock = true;
			counter++;
			thisThread = Thread.currentThread();
		}
	}
	
	public void unlock() {
		synchronized (obj) {
			if(thisThread != Thread.currentThread()) {
				throw new IllegalStateException("Illegal Thread State Exception");
			}
			if(thisThread == Thread.currentThread()) {
				counter--;
			}
			if(counter ==0) {
				islock = false;
				thisThread = null;
				obj.notify();
			}
		}
	}
}
