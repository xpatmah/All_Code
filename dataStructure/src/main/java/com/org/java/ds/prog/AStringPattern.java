package com.org.java.ds.prog;

import java.util.Arrays;

//Generate all the string of n bits.

public class AStringPattern {

	static int[] A;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		A =new int[5];
		
		AStringPattern patr = new AStringPattern();
		patr.binary(5);
	}
	
	public void binary(int n){
		if(n<1){
			System.out.println(Arrays.toString(A));
		}
		else{
			A[n-1]=0;
			binary(n-1);
			A[n-1]=1;
			binary(n-1);
		}
		
	}

}
