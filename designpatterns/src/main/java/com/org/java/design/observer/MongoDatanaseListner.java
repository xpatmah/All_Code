package com.org.java.design.observer;

public class MongoDatanaseListner implements IDatabaselistner<String,String>{

	@Override
	public void update(String obj, String obj2) {
		System.out.println("the item has been updated "+obj+" "+obj2);
		
	}

}
