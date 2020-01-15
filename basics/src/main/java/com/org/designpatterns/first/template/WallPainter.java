package com.org.designpatterns.first.template;

public class WallPainter extends AbstractPainter{

	@Override
	public void choosColor() {
		System.out.println("choosen the color");
		
	}

	@Override
	public void getColor() {
		// TODO Auto-generated method stub
		System.out.println("Got the color");
	}

	@Override
	public void mixColor() {
		// TODO Auto-generated method stub
		System.out.println("MixedColor");
	}

}
