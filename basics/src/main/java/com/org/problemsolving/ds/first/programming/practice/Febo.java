package com.org.problemsolving.ds.first.programming.practice;

public class Febo {

    static int[] arr ;	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int number = 34;
		
		Febo f1 = new Febo();
		arr = new int[10];
		System.out.println(f1.febo(10));
	}
	
	
	public int febo(int number){
	    
		if(number ==0){
			return 0;
		}else if(number ==1){
			return 1;
		}else{
			return febo(number-2) + febo(number-1);
		}
	}

}
