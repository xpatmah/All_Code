package com.org.designpatterns.second.strategy;

public class Audi  extends Vehical{

	Audi(){
		setGoByAlgo(new GoByCar());
	}
}
