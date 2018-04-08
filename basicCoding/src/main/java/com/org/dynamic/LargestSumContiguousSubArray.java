package com.org.dynamic;

public class LargestSumContiguousSubArray {

	public static void main(String[] args) {
	   // TODO Auto-generated method stub
	   int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
	   LargestSumContiguousSubArray as = new LargestSumContiguousSubArray();
	   System.out.println(as.sum(a));
	}
	
	public int sum(int[] array) {
		int maxSum = 0; 
		int max_ending = 0;
		
		for(int i = 0 ; i < array.length ; i++) {
			max_ending = max_ending + array[i];
			if(max_ending > maxSum) {
				maxSum = max_ending;
			}
			
			if(max_ending < 0) {
				max_ending = 0;
			}
		}
		return maxSum;
		
	}

}
