package com.org.designpatterns.second.strategy;

public abstract class Vehical {

	private IGoByAlgo gobyalog;
	
	public void setGoByAlgo(IGoByAlgo gobyalog){
		this.gobyalog=gobyalog;
		
	}
	
	public void go(){
		gobyalog.go();
	}
	
	
}
