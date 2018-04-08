package com.org.multithread.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {

	private BlockingQueue<Runnable> queue;
	
	private boolean isStoped = false;
	
	private List<PoolThread> listOfThread = new ArrayList<>();
	
	public ThreadPool(int noOfThreads, int noOfMaxTask) {
		queue = new LinkedBlockingQueue<>(noOfMaxTask);
		for(int i = 0 ;i< noOfThreads;i++) {
			listOfThread.add(new PoolThread(queue));
		}
		for(Thread thread : listOfThread) {
			thread.start();
		}
	}
	
	public synchronized void execute(Runnable run) throws InterruptedException {
		if(isStoped) {
		   throw new IllegalStateException("Thread Pool is not running");
		}
		queue.put(run);
	}
	
	public synchronized void stop() {
		isStoped = true;
		for(PoolThread t : listOfThread) {
			t.doStop();
		}
	}
	
}
