package com.org.java.design.prototype;

public class PrototypeTest {

	public static void main(String[] args) {

		Record record = new Record("ABC");
		
		House house = new House("A", "XYZ", record);
		
		System.out.println(house.toString());
		
		House houseClone = house.clone();
		
		record.setRecordName("XBBXB");
		
		System.out.println(houseClone.toString());
		
		
	}

}
