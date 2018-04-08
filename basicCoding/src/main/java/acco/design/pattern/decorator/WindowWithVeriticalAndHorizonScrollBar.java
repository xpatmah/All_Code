package acco.design.pattern.decorator;

public class WindowWithVeriticalAndHorizonScrollBar extends AbstractWindow {

	protected WindowWithVeriticalAndHorizonScrollBar(IWindow window) {
		super(window);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw() {
		window.draw();
		System.out.println("With Horizontal i have assigned the verttical");
	}
}

