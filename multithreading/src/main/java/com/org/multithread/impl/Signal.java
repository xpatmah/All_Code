package com.org.multithread.impl;

public class Signal {
	
	private boolean isSignaled = false;
	
	private MyMonitorObject obj = new MyMonitorObject();
	
	public  void doWait() {
		synchronized(obj){
			if(!isSignaled) {
				try {
					//System.out.println("goes into wait state");
					obj.wait();
					//System.out.println("out of wait state");
				} catch (InterruptedException e) {
				}
			}
			isSignaled = false;
		}
	}
	
	public void donotify() {
		synchronized(obj) {
			isSignaled = true;
            obj.notify();
		}
	}
}
