package com.org.java.design.strategy;

public class AllVehical extends Vehical{

	 public AllVehical() {
          setGoByAlgo(new GoByAir());
	 }
	
}
