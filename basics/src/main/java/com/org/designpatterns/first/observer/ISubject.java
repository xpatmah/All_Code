package com.org.designpatterns.first.observer;

public interface ISubject<T> {

	public void addObsever(T observer);
	
	public void removeObserver(T obserer);
	
	public void notifyObserver();
	
	
}

