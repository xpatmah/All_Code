package com.org.multithreading.first.impl;

import java.util.LinkedList;
import java.util.Queue;

public class FairLock {

	private boolean isLocked = false;
	
	private Object lock = new Object();
	
	private Runnable runnable = null;
	
	private Queue<Object> queuedObject = new LinkedList<>();
	
	public void lock() {
		Object obj = new Object();
		synchronized (lock) {
		   queuedObject.add(obj);
		}
		boolean isLockedForThisThread = true;
		
		while(isLockedForThisThread) {
			synchronized(lock) {
				isLockedForThisThread = isLocked || queuedObject.peek() == obj;
				if(!isLockedForThisThread) {
					runnable = Thread.currentThread();
					isLocked = true;
					queuedObject.remove();
				}
				try {
					obj.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void unlock() {
		synchronized (lock) {
			if(runnable != Thread.currentThread()) {
				throw new IllegalMonitorStateException("Can not awaken the non waiting thread");
			}
			isLocked = false;
			runnable = null;
			queuedObject.peek().notify();
		}
	}
	

}
