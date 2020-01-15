package com.org.multithreading.first;

public class EvenOddPrint {

	private Object obj = new Object();
	
	boolean printEven = true;
	
	public static void main(String[] args) {
	  // TODO Auto-generated method stub

		EvenOddPrint evenOdd = new EvenOddPrint();
		evenOdd.startProcess();
	}
	
	
	
	public void startProcess() {
		
		Thread t1 = new Thread(new Runnable() {

			int i = 1;
			@Override
			public void run() {
				while(true) {
					synchronized (obj) {
						if(!printEven) {
							try {
								obj.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						System.out.println(i);
						i = i+2;
						printEven = false;
						obj.notify();
						if(i>100) {
							break;
						}
					}
				}
			}
		});
		

		Thread t2 = new Thread(new Runnable() {

			int i = 2;
			@Override
			public void run() {
				while(true) {
					synchronized (obj) {
						if(printEven) {
							try {
								obj.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						System.out.println(i);
						i = i+2;
						printEven = true;
						obj.notify();
						if(i>100) {
							break;
						}
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
		
	}

}
