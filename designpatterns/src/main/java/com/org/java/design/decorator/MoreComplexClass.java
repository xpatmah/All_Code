package com.org.java.design.decorator;

public class MoreComplexClass extends SimpleDecorator{

	@Override
	public String go() {
		// TODO Auto-generated method stub
		return super.go() + " This is more complex go";
	}

	@Override
	public String come() {
		// TODO Auto-generated method stub
		return super.come() + " This is more complex go";
	}

	public MoreComplexClass(ISimple isimple) {
		super(isimple);
	}

}
