package com.org.java.interfaces.eight;

public interface Vechicle extends Engine{

	public default String make() {
		return "Default Make";
	} 
	

	public default void go() {
		System.out.println("Hello");
		return;
	}
	
}
