package com.org.java.api.demo;

import java.util.ArrayList;
import java.util.List;

public class FairLock {

	private boolean isLocked = false;
	
	private Runnable thisThread;
	
	private List<Object> queuedObject = new ArrayList<>();
	
	private Object obj = new Object();
	
	public void lock() throws InterruptedException {
		Object object = new Object();
		boolean isLockedForthisThread = true;
		synchronized (obj) {
			queuedObject.add(object);
		}
		
		while(isLockedForthisThread) {
			synchronized (object) {
				isLockedForthisThread = isLocked || queuedObject.get(0) != object;
				if(!isLockedForthisThread) {
					thisThread = Thread.currentThread();
					isLocked = true;
					queuedObject.remove(object);
					return;
				}
				try {
					obj.wait();
				} catch (InterruptedException e) {
					synchronized (obj) {
						queuedObject.remove(object);
					}
					throw e;
				}
			}
			
		}

	}
	
	public void unlock() {
		synchronized (obj) {
		  if(thisThread != Thread.currentThread()) {
			  throw new IllegalMonitorStateException("Tried to notify the unlocked object");
		  }
		  isLocked = false;
		  thisThread = null;
		  if(queuedObject.size() > 0) {
			  queuedObject.get(0).notify();
		  }
		}
	}
	
}
