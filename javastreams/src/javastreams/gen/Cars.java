package com.org.java.gen;

public abstract class Cars implements Comparable<Cars> {

	int price;
	String color;
	
	public Cars(int price, String color) {
          this.price = price;
          this.color= color;
	}
	
	@Override
	public int compareTo(Cars o) {
		// TODO Auto-generated method stub
		if(this.price > o.price){
			return 1;
		}else if(this.price < o.price){
			return -1;
		}
		return 0;
	}
	
}
