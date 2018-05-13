package acco.design.pattern.decorator;

public class WindowWithHorizontalScrollBar extends AbstractWindow{

	protected WindowWithHorizontalScrollBar(IWindow window) {
		super(window);
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		super.draw();
		System.out.println("window With HorizontalScrollBar");
	}
}
