package com.org.multithreading.first.impl;

public class ReadWriteLock {

	private int readers;
	private int writers;
	private int writeRequest;
	private Object obj = new Object();
	
	
	public void readLock() throws InterruptedException {
		synchronized(obj) {
			if(writeRequest > 0 || writers > 0) {
				obj.wait();
			}
			readers++;
		}
	}
	
	public void readUnlock() {
		synchronized(obj) {
			readers--;
			obj.notifyAll();
		}
	}

	public void writeLock() throws InterruptedException {
		synchronized(obj) {
			writeRequest++;
			if(readers > 0 || writers > 0) {
				obj.wait();
			}
			writeRequest--;
			writers++;
		}
	}
	
	public void writeUnlock() {
		synchronized(obj) {
			writers--;
			obj.notifyAll();
		}

	}
	
}

