package com.org.java.design.observer;

public interface Observer<T,U,V> {
    
	public void removeListner(T listner);
	
	public void addListner(T lintner);
	
	public void notfy(U obj, V Obj2);
	
}
