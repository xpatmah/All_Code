package com.tricky;

public class Ex2 {

	int variable = 10;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2 ex2 = new Ex2();
		ex2.startThread();
	}

	public void startThread(){
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
			System.out.println("started Thread 1");
			   variable++;
			   System.out.println(variable);
			   System.out.println("Completed Thread 1");
			}
		});
		
/*		C(n,k) = C(n-1,k-1) + C(n-1 , k)
		
		C(n,0) = C(n,n) = 1;*/
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Started Thread 2");	
			   variable++;
			   System.out.println(variable);
			   System.out.println("Completed Thread 2");
			}
		});
		
		t1.start();
		t2.start();
		
	}
	
}
