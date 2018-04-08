package com.org.noobjective;

public class CoinChangeProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 	int arr[] = {1, 2, 3};
	        int m = arr.length;
	        System.out.println( count(arr, m, 4));
	        
	}

	private static int count(int[] arr, int m, int n) {
		// TODO Auto-generated method stub
		if(n==0){
			return 1;
		}
		if(n<0){
			return 0;
		}
		if(m<=0 && n >=1){
			return 0;
		}
		return count(arr , m-1 , n) + count(arr , m , n-arr[m-1]);
	}

}
