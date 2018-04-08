package com.org.java.design.flyweight;

import java.util.ArrayList;
import java.util.List;

public class CoffeShop {

	private Menu menu = new Menu();
	private List<Order> orders = new ArrayList<>();
	
	
	public void takeOrder(int tableNo , String flavor){
		    CoffeFlavor coffeflavor = menu.lookup(flavor);
     		Order order = new Order(tableNo, coffeflavor); 
     	    orders.add(order);		
	}
	

	public void service(){
		for(Order order : orders){
			order.serve();
		}
	}
	
	public void report(){
		System.out.println("Total No item we have is"+menu.totalOrderWehave());
	}
	
}
