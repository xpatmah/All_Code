package com.org.problemsolving.dp.first;


public class SolutionWithLong {

	public static void main(String[] args) {
	/*	Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for(int arr_i=0; arr_i < n; arr_i++){
			arr[arr_i] = in.nextInt();
		}*/
		int[] arr = {1000000001, 1000000002, 1000000003, 1000000004, 1000000005,1000000006,1000000007,1000000008,1000000009};
		
		long value = bigIntSum(arr);
		System.out.println(value);


	}

	private static long  bigIntSum(int[] arr){
		long sum=0;
		for(int ele : arr){
			sum+=(long)ele;
		}
		return sum;
	}
}

