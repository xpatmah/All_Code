package com.org.designpatterns.second.factory;

public class Test {

	public static void main(String[] args) {

		DatabaseFactory factory = new DatabaseFactory("mongo");

		IConnection connection = factory.createDatabaseConnection();
		if(null!=connection){
			connection.discription();
		}

		factory = new DatabaseFactory("cassendra");

		connection = factory.createDatabaseConnection();


		if(null!=connection){
			connection.discription();
		}

		factory = new DatabaseFactory("sql");

		connection = factory.createDatabaseConnection();


		if(null!=connection){
			connection.discription();
		}

		connection = factory.createDatabaseConnection("mongo");
		
		if(null!=connection){
			connection.discription();
		}
		
		
	}

}

