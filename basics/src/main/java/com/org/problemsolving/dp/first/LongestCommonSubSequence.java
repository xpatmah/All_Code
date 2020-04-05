package com.org.problemsolving.dp.first;

public class LongestCommonSubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "AGGTAB";
	    String s2 = "GXTXAYB";
	    
	    char[] source = s1.toCharArray();
	    char[] destination = s2.toCharArray();
		
	    System.out.println(longestCommonSubsequence(source, destination, s1.length(),s2.length()));
	    System.out.println(longestCommonSubSequenceDynamic(source, destination, s1.length(),s2.length()));
	}

	public static int longestCommonSubsequence(char[] source , char[] destination, int m , int n){
		
		if(m==0 || n==0){
			return 0;
		}
		
		if(source[m-1] == destination[n-1]){
			return 1 + longestCommonSubsequence(source, destination, m-1, n-1);
		}else{
			return Math.max(longestCommonSubsequence(source, destination, m, n-1), longestCommonSubsequence(source, destination, m-1, n));
		}
	}
	
	public static int longestCommonSubSequenceDynamic(char[] source , char[] destination , int m , int n){
		
		int[][] array = new int[m+1][n+1];
		
		for(int i = 0 ; i <=m ;i++){
		   for(int j=0 ; j<=n ;j++){
			   if(i==0 || j==0){
				   array[i][j] = 0;
			   }else if(source[i-1] == destination[j-1]){
				   array[i][j] = array[i-1][j-1] + 1;
			   }else{
				   array[i][j] = Math.max(array[i][j-1], array[i-1][j]);
			   }
		   }
		}
		return array[m][n];
	}
	
}
