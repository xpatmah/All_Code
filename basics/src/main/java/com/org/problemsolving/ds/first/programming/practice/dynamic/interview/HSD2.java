package com.org.problemsolving.ds.first.programming.practice.dynamic.interview;

import java.util.Arrays;

public class HSD2 {

	// Program Name => 0 to kth string
	
	public static void main(String[] args) {
		
		int noRange = 5;
		
		int noOfDigit = 4;
		
		HSD2 hsd2 = new HSD2();
		hsd2.printAllnDigitNo(4, new int[4],6);
		
	}
	
	public void printAllnDigitNo(int n , int[] A , int k ) {

		if(n <=0) {
			System.out.println(Arrays.toString(A));
		}else {
			for(int i = 0 ; i < k  ; i++) {
				A[n-1] = i;
				printAllnDigitNo(n-1, A , k);
			}
		}
		
		
	}
	
	
	
}
