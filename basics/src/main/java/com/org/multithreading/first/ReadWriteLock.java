package com.org.multithreading.first;

import java.util.HashMap;
import java.util.Map;

public class ReadWriteLock {

	private int readers;
	
	private int writers;
	
	private int write_request;
	
	Map<Thread , Integer> readersThread = new HashMap<>();
	
	
	public synchronized void readLock() throws InterruptedException {
		
		Thread thread = Thread.currentThread();
		
		if(!canGrantTheAccess(thread)) {
			wait();
		}
		readers ++;
		readersThread.put(thread, getReaderCount(thread)+1);
		
	}
	
	private int getReaderCount(Thread thread) {
		if(null!= readersThread.get(thread)) {
			return readersThread.get(thread);
		}else {
			return 1;
		}
	}
	
	public synchronized void readUnlock() {
		readers--;
		notifyAll();
	}
	
	
	public synchronized void writeLock() throws InterruptedException {
		write_request++;
		if(readers > 0 || writers > 0) {
			wait();
		}
		write_request--;
		writers++;
	}

	public synchronized void writeUnlock() {
		writers--;
		notifyAll();
	}
	
	private boolean canGrantTheAccess(Thread thread) {
		if(writers>0) {
			return false;
		}else if(isAlreadyReader(thread)) {
			return true;
		}else if (write_request > 0) {
			return false;
		}
		return true;
	}
	
	private boolean isAlreadyReader(Thread thread) {
		return readersThread.get(thread) !=null;
	}
	
	private boolean isOnlyReadersThread(Thread thread) {
		return readersThread.size() ==1 && readersThread.get(thread)!=null;
	}
}
