package com.org.designpatterns.second.strategy;

public class Train extends Vehical{

	public Train() {
		setGoByAlgo(new GoByTrain());
	}
	
}
