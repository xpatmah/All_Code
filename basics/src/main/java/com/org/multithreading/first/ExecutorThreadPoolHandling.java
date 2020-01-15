package com.org.multithreading.first;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorThreadPoolHandling {

	class Producer implements Callable<Integer>{
		
		int i ;
		
		public Producer(int i) {
			this.i = i;
		}

		@Override
		public Integer call() throws Exception {
			// TODO Auto-generated method stub
			return 10 /i;
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ExecutorService ex = Executors.newFixedThreadPool(5);
		
		ExecutorThreadPoolHandling h1 = new ExecutorThreadPoolHandling();
		
		List<Future<?>> funtureObject = new ArrayList<>();
		
		for(int i = -1 ;i < 10;i++) {
			Producer p = h1.new Producer(i);
			funtureObject.add(ex.submit(p));
		}		
		
		ex.shutdown();
		
		ex.awaitTermination(10, TimeUnit.SECONDS);

	}

}
