package com.org.domain.collection;

public interface Engine {

	public default String model() {
		return "Default model";
	}
	
	public default void go() {
		System.out.println("Hello");
		return;
	}
	
}
