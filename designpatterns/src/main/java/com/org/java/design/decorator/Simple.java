package com.org.java.design.decorator;

public class Simple implements ISimple{

	@Override
	public String go() {
		return "This is Simple functionality Go method";
	}

	@Override
	public String come() {
		return "This is simple functionality come method";
	}

}
