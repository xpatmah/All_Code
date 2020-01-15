package com.org.problemsolving.dp.first;

public class CoinChangeProblem {
	
	public static void main(String[] args) {
		
		int n = 4;
		int[] coins = {1,2,3};
		System.out.println(coinChangeWays(coins, 4, 3));
	}
	
	public static int coinChangeWays(int[] coins , int n , int m){
		
		if(n==0) {
			return 1;
		}
		
		if(n<0) {
			return 0;
		}
		
		if(m <= 0 && n>0) {
			return 0;
		}
		
		return coinChangeWays(coins, n-coins[m-1], m) + coinChangeWays(coins, n, m-1);
		
	}
	
	
	
}
