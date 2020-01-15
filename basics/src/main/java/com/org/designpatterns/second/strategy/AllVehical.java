package com.org.designpatterns.second.strategy;

public class AllVehical extends Vehical{

	 public AllVehical() {
          setGoByAlgo(new GoByAir());
	 }
	
}
