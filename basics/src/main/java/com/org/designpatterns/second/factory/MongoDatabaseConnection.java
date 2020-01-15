package com.org.designpatterns.second.factory;

public class MongoDatabaseConnection implements IConnection{

	@Override
	public void discription() {
		System.out.println("This is mongo data base connection");	
	}

}
