package com.org.designpatterns.first.decorator;

public class WindowWithVerticalBar extends AbstractWindow{

	protected WindowWithVerticalBar(IWindow window) {
		super(window);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw() {
		window.draw();
		System.out.println("Vertical Bar");
	}

}
