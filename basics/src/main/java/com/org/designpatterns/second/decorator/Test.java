package com.org.designpatterns.second.decorator;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
		 Simple simple = new Simple();
		 
		 LittleComplexClass lcs = new LittleComplexClass(simple);
		 
		 MoreComplexClass mcs = new MoreComplexClass(lcs);
		 
		 System.out.println(mcs.go());
		 System.out.println(mcs.come());
		
		
	}

}
