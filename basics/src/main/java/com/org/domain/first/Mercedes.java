package com.org.domain.first;

public class Mercedes extends Cars implements Comparable<Cars>{

	public Mercedes(int price, int version) {
		super(price, version);

	}

	@Override
	public int compareTo(Cars o) {
		// TODO Auto-generated method stub
		return super.compareTo(o);
	}

}
