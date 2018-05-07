package com.org.multithread.again;

import java.util.Queue;

public class Consumer implements Runnable{
	
		private final Queue<Integer> randomList;
	 
		private final Object obj;
	
		public Consumer(Queue<Integer> randomList, Object obj) {
			// TODO Auto-generated constructor stub
			this.randomList = randomList;
			this.obj = obj;
		}
	
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				synchronized(obj) {
					if(randomList.size()==0) {
						try {
							obj.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("removed "+randomList.poll());
					obj.notifyAll();
				}
			}
		}
	}