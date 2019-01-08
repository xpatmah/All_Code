package com.java.basic.interview.coding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Worker {

    private Lock lock = new ReentrantLock();
	
    private Condition cond = lock.newCondition();
    
    private List<Integer> intList = new ArrayList<>();
    
	public void produce() throws InterruptedException {
		Random random = new Random();
		while (true) {
			lock.lock();
			try {
               if(intList.size()==10) {
            	   cond.await();
               }
               Integer item =random.nextInt(100);
               intList.add(item);
               System.out.println("Inserted Item is"+ item);
               cond.signal();
			} finally {
				lock.unlock();
			}
		}
	}
    
    public void consume() throws InterruptedException{
    	while (true) {
			lock.lock();
			try {
               if(intList.size()==0) {
            	   cond.await();
               }
              System.out.println("Removed Item is"+ intList.remove(0));
              cond.signal();
			} finally {
				lock.unlock();
			}
		}
    }
    
}
