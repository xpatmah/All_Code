package com.org.multithread;

public class RunnableClass implements Runnable {

	int id;
	
	public RunnableClass(int id) {
              this.id = id;
	}
	
	@Override
	public void run() {
		System.out.println(id+" started");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(id+" finished");
	}

}
