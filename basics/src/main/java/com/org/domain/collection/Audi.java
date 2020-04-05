package com.org.domain.collection;

public class Audi extends Cars implements Comparable<Cars>{

	public Audi(int price, int version) {
		super(price, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer getNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int compareTo(Cars o) {
		return super.compareTo(o);
	}

}
