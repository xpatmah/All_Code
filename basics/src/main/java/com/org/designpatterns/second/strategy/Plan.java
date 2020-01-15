package com.org.designpatterns.second.strategy;

public class Plan extends Vehical{

	public Plan() {
       setGoByAlgo(new GoByAir());
	}
}
