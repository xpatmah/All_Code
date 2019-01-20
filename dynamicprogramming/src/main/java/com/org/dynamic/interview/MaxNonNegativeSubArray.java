package com.org.dynamic.interview;

public class MaxNonNegativeSubArray {

	public static void main(String[] args) {
	
		
		
	}
	
	private String getMaxIndex(int[] array) {
	
		int maxSum = Integer.MIN_VALUE;
		
		int indexStarting = -1;
	
		int lengthOfSubpart = 0;
		
		int endIndex = -1;
		
		int current_sum = 0;
		
		int previousSum = 0;
		
		for(int i = 0 ;i < array.length ; i++) {
			
			current_sum += array[i];
			
			if(current_sum < 0 || current_sum < previousSum) {
				current_sum = 0;
				lengthOfSubpart = 0;
				indexStarting++;
			}
			
			if(maxSum < current_sum) {
				maxSum = current_sum;
				endIndex++;
			}
			
			previousSum = current_sum;
		}
		
		
		return "";
	}
	
	

}
