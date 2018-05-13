package com.org.multithread.impl;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalClass<T> {

	private Map<Thread, T> map = new HashMap<>();
	
	Object obj = new Object();
	
	public void initValue(T value) {
		synchronized(obj) {
			map.put(Thread.currentThread(), value);
		}
	}
	
	public void set(T object) {
		synchronized(obj) {
			map.put(Thread.currentThread(), object);
		}
	}
	
	public T get() {
		synchronized (obj) {
			if(map.containsKey(Thread.currentThread())) {
				return map.get(Thread.currentThread());
			}else {
				return null;
			}
		}
	}
}
