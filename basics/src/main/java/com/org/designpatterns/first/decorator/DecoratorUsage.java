package com.org.designpatterns.first.decorator;

public class DecoratorUsage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IWindow win = new Window();
		
		IWindow windH = new WindowWithHorizontalScrollBar(win);
		
		IWindow windoV = new WindowWithVerticalBar(win);
		
		IWindow wind = new WindowWithVeriticalAndHorizonScrollBar(windH);
		
		wind.draw();
		
	}

}
