package com.org.java.design.observerSecond;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 DataBaseListner listner = new DataBaseListner();
		 
		 DataBaseObserver observer = new DataBaseObserver();
		 observer.addListner(listner);
		 
		 Thread observerThread = new Thread(observer,"Observer-Thread");
		 
		 observerThread.start();
		 
		 
		 new Thread(new Runnable() {
			@Override
			public void run() {
             for(int i=0;i<100;i++){
            	 try {
					Thread.sleep(1000);
					DataBaseObserver.queue.put(new ListnerEvent(i, "Mahesh"+i));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
             }				
			}
		},"Rnuunable-Thread").start();
		 
		 
		 
		
	}

}
