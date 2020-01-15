package com.org.problemsolving.ds.first.programming.practice.recursion;

public class SumOfDigitRecursivly {

	public static void main(String[] args) {
		
	   System.out.println(getSumOfDigit(9987));
	
	}
	
	private static int getSumOfDigit(int n) {
		if(n <= 0) {
			return 0;
		}
		
		return  n%10 + getSumOfDigit(n/10); 
	}
	
}
