package com.org.java.design.flyweight;

public class TestFlyWeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     CoffeShop shop = new CoffeShop();
     
     shop.takeOrder(2, "Black");
     shop.takeOrder(1, "Cream");
     shop.takeOrder(7, "Cappachino");
     shop.takeOrder(8, "Hot Coffee");
     shop.takeOrder(9, "Cold Coffee");
     shop.takeOrder(10, "Ice Coffee");
     shop.takeOrder(11, "Black");
     
     shop.service();	
     shop.report(); 
     
		
	}

}
