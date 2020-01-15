package com.org.multithreading.first.impl;

public class Lock {
	
	private boolean isLocked = false;

	private Thread currentThread = null;
	
	
	public synchronized void lock() throws InterruptedException {
		while(isLocked) {
			wait();
		}
		isLocked = true;
		currentThread = Thread.currentThread();
	}
	
	public synchronized void unlock() {
		if(currentThread != Thread.currentThread()) {
			throw new IllegalMonitorStateException("Illegal Monitor state Exception");
		}
		isLocked = true;
		currentThread = null;
		notify();
	}
	
}
