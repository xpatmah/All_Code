package com.org.problemsolving.dp.first;

public class CoinChangeRecursion {

	public static void main(String[] args) {
	
		int[] coins = {1,2,3};
		
		CoinChangeRecursion coin = new CoinChangeRecursion();
		int totalCombinations = coin.coinChange(coins, 3, 4);
		System.out.println(totalCombinations);
	}
	
	
	public int coinChange(int[] coins , int m , int n) {
		
		if(n==0) {
			return 1;
		}
		
		if(n< 0) {
			return 0;
		}
		
		if(m<=0 && n > 0) {
			return 0;
		}
		
		return coinChange(coins, m, n-coins[m-1]) + coinChange(coins, m-1, n);
		
	}
	
	
	
	
}
