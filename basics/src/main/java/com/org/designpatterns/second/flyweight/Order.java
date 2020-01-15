package com.org.designpatterns.second.flyweight;

public class Order {

	private int tableNo  ;
	private CoffeFlavor flavor;
	
	public Order(int tableNo , CoffeFlavor flavor){
		this.tableNo = tableNo;
		this.flavor = flavor;
	}
	
	public void serve(){
		System.out.println("Serving the table no "+tableNo+" with "+flavor.getCoffeFlavor()+" coffee");
	}
	
	
}
