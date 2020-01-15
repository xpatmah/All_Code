package com.org.problemsolving.ds.first.programming.practice.dynamic;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LRUCache<K,V> {

	private final int SIZE;
	
	private final Map<K , V> conmap;
	
	private final Queue<K> queue;
	
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	
	private final Lock readLock = lock.readLock();
	
	private final Lock writeLock = lock.writeLock();
	
	LRUCache(int size){
		this.SIZE = size;
		queue = new ConcurrentLinkedQueue<>();
		conmap = new ConcurrentHashMap<>();
	}
	
	public V getElement(K key){
		readLock.lock();
		try{
			V v = null;
			if(conmap.containsKey(key)){
				queue.remove(key);
				v  = conmap.get(key);
				queue.add(key);
			}
			return v;
		}finally{
			readLock.unlock();
		}
		
	}
	
	public V removeElement(K key){
		writeLock.lock();
		try{
			V v =null; 
			if(conmap.containsKey(key)){
				conmap.remove(key);
				queue.remove(key);
			}
			return v;
		}finally{
			writeLock.unlock();
		}
	} 
	
	public V addElement(K key , V value){
		writeLock.lock();
		try{
			if(conmap.containsKey(key)){
				queue.remove(key);
			}
			while(queue.size() >= SIZE){
				K k = queue.poll();
				conmap.remove(k);
			}
			
			queue.add(key);
			conmap.put(key,value);
			return value;
		}finally{
			writeLock.unlock();
		}
	}
	
}
