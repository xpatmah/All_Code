package com.org.problemsolving.dp.first;

public class CoinChangeDynamic {

	public static void main(String[] args) {

		int[] coins = {1,2,3};
		
		CoinChangeDynamic coin = new CoinChangeDynamic();
		
		int totalCombinations = coin.coinChange(coins, 3, 4);
		
		System.out.println(totalCombinations);
		
	}

	public int coinChange(int[] coins, int m, int n) {
		
		int[][] countArray = new int[n+1][m];
		
		for(int i = 0 ; i < m ; i++) {
			countArray[0][i] =1;
		}
		
		for(int i = 1 ; i<=n;i++) {
			
			for(int j = 0 ; j < m ;j++) {

				int a = i - coins[j] >=0 ? countArray[i-coins[j]][j]:0;

				int b = j >= 1 ? countArray[i][j-1]:0;
				
				countArray[i][j] = a+b;
			}
		}

		return countArray[n][m-1];
	}
	
	
	

}
