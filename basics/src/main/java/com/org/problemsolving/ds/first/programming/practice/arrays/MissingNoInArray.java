package com.org.problemsolving.ds.first.programming.practice.arrays;

public class MissingNoInArray {

	
	public static void main(String[] args) {
		
		int[] array = {1,3,4,5,6,7,8};
		
		System.out.println(findMissingNo(array));
		
	}
	
	private static int findMissingNo(int[] array) {
		
		int xorSum = array[0];
	    for(int i=1 ; i< array.length;i++) {
		  xorSum ^= array[i];
	    }
		
		for(int i = 1 ; i <= array.length+1 ; i++) {
			xorSum ^=i;
		}
		
		return xorSum;
	}
}
