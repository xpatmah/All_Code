package com.org.java.design.factory;

public class MongoDatabaseConnection implements IConnection{

	@Override
	public void discription() {
		System.out.println("This is mongo data base connection");	
	}

}
