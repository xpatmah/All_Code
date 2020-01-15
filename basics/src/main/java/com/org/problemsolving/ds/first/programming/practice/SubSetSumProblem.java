package com.org.problemsolving.ds.first.programming.practice;

public class SubSetSumProblem {
	
	public static void main(String[] args) {
		
		int[] set = {3, 34, 4, 12, 5, 2};
		int sum = 9;
		
		SubSetSumProblem prob = new SubSetSumProblem();
		
		System.out.println(prob.subSetExist(set, set.length ,sum));
	
	}
	
	
	public boolean subSetExist(int[] set , int n , int sum) {
		if(sum==0) {
			return true;
		}
		
		if(n==0 && sum!=0) {
			return false;
		}
		
		if(n > 0 && set[n-1] > sum) {
			return subSetExist(set, n-1, sum);
		}else {
			return subSetExist(set, n-1, sum - set[n-1]) || subSetExist(set, n-1, sum);
		}
		
		
	}
	
}
