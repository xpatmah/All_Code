package com.org.design.pattern.builder;

public class HouseBuilderTest {

	public static void main(String[] args) {
		
		House.HouseBuilder builder = new House.HouseBuilder();
		
		House house = builder.buildAppartment(true).buildBaseMent(true).buildRoom(false).buildVila(false).build();
	    
		System.out.println(house.toString());
	
	} 
	
}
