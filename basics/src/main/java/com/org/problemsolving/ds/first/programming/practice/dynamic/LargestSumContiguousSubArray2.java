package com.org.problemsolving.ds.first.programming.practice.dynamic;

public class LargestSumContiguousSubArray2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(largestSum(a));
		
	}
	
	public static int largestSum(int[] array){
		
		int maxSum = 0;
		int maxSumUpto = 0;
		for(int i = 0 ;i < array.length ; i++){
			
			maxSumUpto = maxSumUpto + array[i];
			
			if(maxSumUpto < 0){
				maxSumUpto = 0;
			}
			if(maxSum < maxSumUpto){
				maxSum = maxSumUpto;
			}
		}
		return maxSum;
		
	}

}
