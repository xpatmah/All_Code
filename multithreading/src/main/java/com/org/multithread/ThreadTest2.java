package com.org.multithread;

import java.util.Scanner;


class App extends Thread{

	private volatile boolean isRunning=true;

	public void stopWork(){
		isRunning=false;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isRunning){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Mahesh");    	
		}
	}
}

public class ThreadTest2 {

	public static void main(String[] args) {

		  App ap = new App();
		  ap.start();
		  
		  
		  System.out.println("Hit enter to  stop:-");
		  Scanner sc= new Scanner(System.in);
		  sc.nextLine();
		  
		  ap.stopWork();
		  
		


	}



}
