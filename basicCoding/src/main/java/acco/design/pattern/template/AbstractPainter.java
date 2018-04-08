package acco.design.pattern.template;

public abstract class AbstractPainter implements IPainter{

	@Override
	public abstract void choosColor() ;

	@Override
	public abstract void getColor();

	@Override
	public abstract void mixColor();

	
	// Template Method
	@Override
	public void paint() {
	    choosColor();
	    
	    getColor();
	    
	    mixColor();
		
		System.out.println("Painting is done");
	    
	}

	
	
}
