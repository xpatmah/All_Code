package com.org.multithreading.first.again;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class LowLevelSynchrnozation {

	private Object obj =  new Object();
	
	private final Integer SIZE = 10;
	
	private Random random = new Random();
			
	private Queue<Integer> randomList = new LinkedList<>();

	public static void main(String[] args) throws InterruptedException{
		LowLevelSynchrnozation synch = new LowLevelSynchrnozation();
		synch.startProcessing();
	}
	
	public void startProcessing() throws InterruptedException {
		Thread t1 = new Thread(new Producer(SIZE, random, randomList, obj));
		Thread t2 = new Thread(new Consumer(randomList, obj));
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}
	
}
