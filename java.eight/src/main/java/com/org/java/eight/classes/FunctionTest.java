package com.org.java.eight.classes;

import com.org.java.interfaces.eight.AdditionInterface;

public class FunctionTest {

	public static void main(String[] args) {
		
		FunctionTest t1 = new FunctionTest();
		t1.addTwoNos(3, 4, (a,b)-> a+b);  
	}
	
	private int addTwoNos(int a,int b, AdditionInterface interfaces) {
		
		return interfaces.add(a, b);
		
	}
	
}
