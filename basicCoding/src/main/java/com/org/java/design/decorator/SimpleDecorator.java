package com.org.java.design.decorator;

public abstract class SimpleDecorator implements ISimple {

	ISimple isimple;
	
	public SimpleDecorator(ISimple isimple) {
		// TODO Auto-generated constructor stub
		this.isimple=isimple;
	}
	
	@Override
	public String go() {
		// TODO Auto-generated method stub
		return isimple.go() ;
		
	}

	@Override
	public String come() {
		// TODO Auto-generated method stub
		return isimple.come() + " Little complex come";
	}
}
