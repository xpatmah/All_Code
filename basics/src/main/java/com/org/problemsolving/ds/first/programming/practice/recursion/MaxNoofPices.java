package com.org.problemsolving.ds.first.programming.practice.recursion;

public class MaxNoofPices {
	
	public static void main(String[] args) {
		
		System.out.println(getMaxNoOfPices(new int[]{2,5,1}, 5));
		
	}
	
	private static int getMaxNoOfPices(int[] arr , int n) {
		if(n==0) {
			return 0;
		}
		if(n < 0) {
			return -1;
		}
				
		return 1+ Integer.max(getMaxNoOfPices(arr, n - arr[0]), Integer.max(getMaxNoOfPices(arr, n-arr[1]),getMaxNoOfPices(arr, n-arr[2])));
		
		
	}
	
	
}
