package com.org.designpatterns.second.observer;

public class Test {

	public static void main(String[] args) {
     
		DatabaseObserver observer = new DatabaseObserver();
		observer.addListner(new MongoDatanaseListner());
		
		observer.updateRecord("Mahesh", "9971047441");
	}

}
