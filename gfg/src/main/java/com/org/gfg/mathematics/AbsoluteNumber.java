package com.org.gfg.mathematics;

public class AbsoluteNumber {

	public static void main(String[] args) {
		  
		AbsoluteNumber abs = new AbsoluteNumber();
		System.out.println(abs.getAbsoluteNo(-34));
	}
	
	private int getAbsoluteNo(int no){
	    if(no > 0 ) {
	    	return no;
	    }else {
	    	return -no;
	    }  	
	}
	
}
