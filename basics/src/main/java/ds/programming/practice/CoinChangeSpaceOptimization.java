package ds.programming.practice;

public class CoinChangeSpaceOptimization {

	public static void main(String[] args) {
		
		int[] coins = {1,2,3};
		
		CoinChangeSpaceOptimization coin = new CoinChangeSpaceOptimization();
		int totalCombinations = coin.coinChange(coins, 3, 4);
		System.out.println(totalCombinations);
		
	}

	public int coinChange(int[] coins, int m, int n) {

		int[] table = new int[n+1];
		
		table[0] = 1;
		
		for(int i = 0 ; i < m ; i++) {
			for(int j = coins[i] ; j <= n ; j++) {
				table[j] += table[j-coins[i]];
			}
		}
		return table[n];
	}
	
	
	
}
