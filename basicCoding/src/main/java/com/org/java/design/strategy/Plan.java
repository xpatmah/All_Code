package com.org.java.design.strategy;

public class Plan extends Vehical{

	public Plan() {
       setGoByAlgo(new GoByAir());
	}
}
