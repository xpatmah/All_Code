package com.org.java.ds.gen;

public class Mercedes extends Car implements Comparable<Car>{

	protected Mercedes(int price, int version) {
		super(price, version);

	}

	@Override
	public int compareTo(Car o) {
		// TODO Auto-generated method stub
		return super.compareTo(o);
	}

}
