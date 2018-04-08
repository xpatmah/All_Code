package com.org.java.utilities;

public class RecursionTable {

	public static void main(String[] args) {
         
	int a=2;
	
	  table(2*10); 
		
	}

	private static void table(int i){
		if(i==0){
			return;
		} 
		table(i-2);
		System.out.println(i);
	}
	
	
	

}
