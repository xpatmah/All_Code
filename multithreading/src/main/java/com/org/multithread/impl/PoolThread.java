package com.org.multithread.impl;

import java.util.concurrent.BlockingQueue;

public class PoolThread extends Thread{

	private BlockingQueue<Runnable> queue;
	
	private boolean isStoped = false;
	
	Object obj = new Object();
	
	public PoolThread(BlockingQueue<Runnable> queue){
		this.queue = queue;
	}
	
	public void run() {
		while(!isStoped()) {
			try {
				Runnable run = (Runnable)queue.take();
				run.run();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public synchronized boolean isStoped() {
			return isStoped;
	}
	
	public synchronized void doStop() {
		isStoped = true;
		this.interrupt();
	}
	
}
