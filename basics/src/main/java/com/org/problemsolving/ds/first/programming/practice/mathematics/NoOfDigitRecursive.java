package com.org.problemsolving.ds.first.programming.practice.mathematics;

public class NoOfDigitRecursive {

	public static void main(String[] args) {
		
		int noOFDigit = new NoOfDigitRecursive().noOfDegit(11);

		System.out.println(noOFDigit);
	}
	
	public int noOfDegit(int n) {		
		if(n==0) {
			return 0;
		}else {
			return 1 + noOfDegit(n/10);
		}
	}

}
