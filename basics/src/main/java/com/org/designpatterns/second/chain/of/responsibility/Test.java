package com.org.designpatterns.second.chain.of.responsibility;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ICorrespondingListner<String> listner = new MainListner(new IntermediateListner(new LastListner()));
		
		listner.listen("intermedifdateClass");
		
		
		
	}

}
