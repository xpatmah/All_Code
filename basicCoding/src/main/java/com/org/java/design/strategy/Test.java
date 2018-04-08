package com.org.java.design.strategy;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   
		Audi audi = new Audi();
		
		audi.go();
		
		Train train = new Train();
		
		train.go();
		
		train.setGoByAlgo(new GoByCar());
		
		train.go();
		
		
	}

}
