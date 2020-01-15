package com.org.problemsolving.ds.first.programming.practice;

public class SubSetSumDynamic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] set = {3, 34, 4, 12, 5, 2};
		int sum = 9;
		
		SubSetSumDynamic prob = new SubSetSumDynamic();
		
		System.out.println(prob.subSetExist(set, set.length ,sum));
		
	}

	public boolean subSetExist(int[] set, int n, int sum) {
		// TODO Auto-generated method stub
		boolean[][] sumExist = new boolean[sum+1][n+1]; 
		
		for(int i = 0 ; i <= n ; i++) {
			sumExist[0][i] = true;
		}
		
		for(int i=1 ; i <= sum ; i++) {
			sumExist[i][0] = false;
		}
		
		for(int i = 1 ; i <= sum ; i ++) {
			for(int j = 1; j <= n ; j++) {
				sumExist[i][j] = sumExist[i][j-1];
				if(i >= set[j-1]) {
					sumExist[i][j] = sumExist[i][j] || sumExist[i-set[j-1]][j-1];
				}
			}
		}
		return sumExist[sum][n];
	}
	
	

}
