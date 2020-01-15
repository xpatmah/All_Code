package com.org.multithreading.first;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableImplementation {

	List<Integer> intList = new ArrayList<Integer>();
	
	class callableImpl implements Callable<Integer>{

		int no;
		public callableImpl(int no){
			this.no = no;
		}
		
		@Override
		public Integer call() throws Exception {
			
			return 10/no;
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub

		List<Future<Integer>> resultList = new ArrayList<>();

		ExecutorService ex = Executors.newFixedThreadPool(10);
		CallableImplementation impl = new CallableImplementation();
		for(int i = -10 ; i< 10;i++) {
			Future<Integer> f = ex.submit(impl.new callableImpl(i));
			resultList.add(f);
		}
		
		for(Future<Integer> future : resultList)
		{
			try
			{
				System.out.println("Future result is  " + " " + future.get() + "; And Task done is " + future.isDone());
			}
			catch (InterruptedException | ExecutionException e)
			{
				// e.printStackTrace();
			}
		}
		
		ex.shutdown();
		ex.awaitTermination(10, TimeUnit.SECONDS);
		
	}

}
