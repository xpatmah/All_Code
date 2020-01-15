package com.org.designpatterns.second.observerSecond;

public interface Observer<T> {
	  
	public void addListner(T listner);
	
	public void removeListner(T listner);
	
	public void notiffy();
	
}
