package com.org.multithread.impl;

public class MySignalWakeUp {
	
	private boolean isSignaled = false;
	
	MyMonitorObject myMonitor = new MyMonitorObject();
	
	public void doWait() {
		synchronized(myMonitor) {
			while(!isSignaled) {
				try {
					myMonitor.wait(); // this call will wiat here 
				} catch (InterruptedException e) {}
			}
			isSignaled = true;
		}
	}
	
	public void doNotify() {
		synchronized (myMonitor) {
			isSignaled = true;
			myMonitor.notifyAll();
		}
	}
	
}
