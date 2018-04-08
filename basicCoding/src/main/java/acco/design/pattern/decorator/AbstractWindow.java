package acco.design.pattern.decorator;

public abstract class AbstractWindow implements IWindow{
	
	IWindow window;
	
	protected AbstractWindow(IWindow window) {
		// TODO Auto-generated constructor stub
		this.window = window;
	}

	public void draw() {
		window.draw();
	}
	
}
