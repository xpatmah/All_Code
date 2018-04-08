package acco.design.pattern.observer;

public interface ISubject<T> {

	public void addObsever(T observer);
	
	public void removeObserver(T obserer);
	
	public void notifyObserver();
	
	
}

