package com.org.multithread.again;

import java.util.Queue;
import java.util.Random;

class Producer implements Runnable {

		private final Integer SIZE;
		
		 private final Random random;
		 private final Queue<Integer> randomList;
		 
		 private final Object obj;
	
		public Producer(Integer size , Random random , Queue<Integer> randomList , Object obj) {
			// TODO Auto-generated constructor stub
			this.SIZE = size;
			this.random = random;
			this.randomList = randomList;
			this.obj = obj;
		}
	
		@Override
		public void run() {
			while(true) {
				synchronized (obj) {
					if(randomList.size()==SIZE) {
						try {
							obj.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					Integer number = random.nextInt(100);
					randomList.offer(number);
					System.out.println("Added " + number);
					obj.notifyAll();
				}
			}
		}
	}
	