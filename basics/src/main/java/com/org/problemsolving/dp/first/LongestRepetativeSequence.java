package com.org.problemsolving.dp.first;

public class LongestRepetativeSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aabb";
		System.out.println(getPattern(LRS(str.toCharArray(),str.length()), str.length(),str.toCharArray())); 
	}
	
	
	public static  int[][] LRS(char[] s , int m) {
		
		int[][] result = new int[m+1][m+1];
		
		for(int i = 0 ; i <= m ; i++) {
			for(int j=0 ; j <=m;j++) {
				if(i==0 || j ==0) {
					result[i][j] = 0;
				}else if(s[i-1] == s[j-1] && i!=j) {
					result[i][j] = 1 + result[i-1][j-1];
				}else {
					result[i][j] = Math.max(result[i-1][j], result[i][j-1]);
				}
			}
		}
		return result;
		
	}
	
	public static String getPattern(int[][] result , int length , char[] c) {
		int i = length;
		StringBuffer buffer = new StringBuffer();
		
		int j = length;
		
		while(i> 0 && j >0) {
			if(result[i][j] == 1 + result[i-1][j-1]) {
				buffer.append(c[i-1]);
				i--;
				j--;
			}else {
			  if(result[i][j] == result[i-1][j]) {
				  i--;
			  }	
			  if(result[i][j] == result[i][j-1]) {
				  j--;
			  }
			}
		}
		
		return buffer.reverse().toString();
	}

}
