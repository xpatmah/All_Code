package com.org.designpatterns.second.chain.of.responsibility;

public class LastListner implements ICorrespondingListner<String>{
	
	public LastListner() {
	}
	
	@Override
	public void listen(String obj) {
		// TODO Auto-generated method stub
		System.out.println("Hello I will be handling all the charge as my name is LastListner s i will be taking care of"+obj);
	}

}
