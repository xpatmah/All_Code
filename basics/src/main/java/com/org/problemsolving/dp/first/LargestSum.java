package com.org.problemsolving.dp.first;

public class LargestSum {

	public static void main(String[] args) {
		 int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
         System.out.println(new LargestSum().getLargestSum(a));
	}

	public int getLargestSum(int[] array) {

		int maxsum = Integer.MIN_VALUE;

		int sumAsofNow =0;

		for(int i = 0 ; i < array.length;i++) {

			sumAsofNow +=array[i];

			if(sumAsofNow < 0) {
				sumAsofNow= 0;
			}
			if(maxsum < sumAsofNow) {
				maxsum = sumAsofNow;
			}
		}
		return maxsum;
	}
}
