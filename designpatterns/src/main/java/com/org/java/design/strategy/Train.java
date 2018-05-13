package com.org.java.design.strategy;

public class Train extends Vehical{

	public Train() {
		setGoByAlgo(new GoByTrain());
	}
	
}
