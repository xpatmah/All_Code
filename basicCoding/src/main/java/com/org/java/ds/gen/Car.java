package com.org.java.ds.gen;

public abstract class Car {
     
	int price;
	int version;
	
	protected Car(int price, int version){
		this.price=price;
		this.version=version;
	}
	
	public int compareTo(Car car){
		if(this.price > car.price){
			return 1;
		}else if(this.price<car.price){
			return -1;
		}else{
			return 0;
		}
	}
}
