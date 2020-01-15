package com.org.multithreading.first;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class LowLevelSynchronizationClass {
	
	LinkedList<Integer> list = new LinkedList<Integer>();
	
	Random random = new Random();
	
	Object lock = new Object();
	
	
	public void producer() throws InterruptedException{
		while(true){
			synchronized (lock) {
                if(list.size()==10){
                	System.out.println("Inside lock of 1 thread");
                	lock.wait();
                }
                Thread.sleep(1000);
                list.add(random.nextInt(23));
                lock.notify();
			}
		}				

	}
	
	
	public void consumer() throws InterruptedException{
		Thread.sleep(1000);
               while(true){
            	   synchronized (lock) {
            		   if(list.isEmpty()){
            			   System.out.println("Where am i");
            			   lock.wait();
            		   }
            		  int removedelee = list.removeFirst();
            		   System.out.println("The removed element is"+ removedelee);
            		   lock.notify();
				}
               }
		      
				
	}
	
	
	

}
