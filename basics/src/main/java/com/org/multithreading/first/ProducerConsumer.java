package com.org.multithreading.first;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {

		LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(10);
		
		Random random = new Random();
		
		public void producerThread(){
			while(true){
				queue.offer(random.nextInt(25));
                try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				
			}
		}
		
		public void consumerThread(){
			while(true){
				 int queueEle;
				try {
					queueEle = queue.take();
					 System.out.println("the element which has been received is "+queueEle);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
			
		}
}
