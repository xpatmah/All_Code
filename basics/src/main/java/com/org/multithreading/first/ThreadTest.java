package com.org.multithreading.first;

public class ThreadTest {

	  private int count=0;
	  
	  private synchronized void increment(){
		  count++;
	  }
	  
	  public static void main(String[] args) {
		  ThreadTest t1 = new ThreadTest();
		  t1.doWork();
	  }
	  
	  private void doWork(){
		  Thread t1 = new Thread(new Runnable() {				
				@Override
				public void run() {
	                 for(int i=0;i<10;i++){
	                	 ThreadTest.this.increment();
	                	 try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                 }
				}
			});
		  
		  Thread t2 = new Thread(new Runnable() {
				
				@Override
				public void run() {
	                 for(int i=0;i<10;i++){
	                	 ThreadTest.this.increment();
	                	 try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	                 }
					
				}
		  });
		  
		  t1.start();
		  t2.start();
		  
		  try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  System.out.println(count);
	  }
	
	
	
	
	
}
