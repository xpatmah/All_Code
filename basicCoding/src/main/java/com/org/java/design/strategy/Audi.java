package com.org.java.design.strategy;

public class Audi  extends Vehical{

	Audi(){
		setGoByAlgo(new GoByCar());
	}
}
