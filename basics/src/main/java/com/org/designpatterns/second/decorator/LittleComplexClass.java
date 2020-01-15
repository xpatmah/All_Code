package com.org.designpatterns.second.decorator;

public class LittleComplexClass extends SimpleDecorator {

	public LittleComplexClass(ISimple isimple) {
		super(isimple);
	}

	@Override
	public String go() {
		return super.go() + " Little complex go";
	}

	@Override
	public String come() {
		return super.come() + " Little complex go";
	}

	
	
}
