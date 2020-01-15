package com.org.interfaces;

import java.util.List;

@FunctionalInterface
public interface IInterface<T> {

	
	public boolean findElement(List<T> list, T number );
	
	public default void printname() {
		System.out.println("This is Default creation");
	}
	
	public static void doIt() {
		System.out.println("This is static Method");
	}
	
}
