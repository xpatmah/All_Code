package com.org.java.prog.core.java;

import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
                  Class<?> fruit =  Fruit.class;
                  
                  for(Method m : fruit.getDeclaredMethods()){
                	  System.out.println(m.toString());
                  }
		
                Class<?> car =  Audi.class;
                  
                  for(Method m : car.getDeclaredMethods()){
                	  System.out.println(m.toString());
                  }
		
                  
	}

}
