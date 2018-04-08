package com.org.noobjective;

public class EmptyProgram {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("dfkdf");
			}
		});
		
		
		t1.start();
		
		t1.join();
	}

}
