package ds.programming.practice;

public class GoldMineProblem {

	public static void main(String[] args) {
		
		
	}
	
	private int maxMinProb(int[][] goldTable , int n , int m) {
		
	   int[][] goldMine = new int[n][m];
	   
	   for(int col = m-1 ; col >=0 ; col--) {
		   
		   for(int row = 0 ; row < n ;row++) {
			   
			   int right =  col == m-1 ? 0 : goldTable[row][col+1];
			
			   int right_up = row == 0 || col == m-1 ? 0 : goldTable[row-1][col+1];  
				
			   int right_down = row==n-1 || col == m-1 ? 0 : goldTable[row+1][col+1]; 
			   
			   goldMine[row][col] = goldTable[row][col] + Math.max(right, Math.max(right_up, right_down));
			   
		   }
	   }
	   	
	   int maxValue = goldMine[0][0];
	   
	   for(int i = 1 ; i < n ;i++) {
		   if(maxValue< goldMine[i][0]) {
			   maxValue = goldMine[i][0];
		   }
	   }
	   
	   return maxValue;
	   
	}
	
	
}
