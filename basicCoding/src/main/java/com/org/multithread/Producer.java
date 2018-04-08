package com.org.multithread;

public class Producer implements Runnable{

	int s;
	
	public Producer(int s){
		this.s = s;
	}
	
	@Override
	public void run() {
		System.out.println(s);
	}
	
}
