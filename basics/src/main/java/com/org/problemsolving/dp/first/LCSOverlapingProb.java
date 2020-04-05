package com.org.problemsolving.dp.first;

public class LCSOverlapingProb {

	public static void main(String[] args) {
		
		char X[] = "AGGTAB".toCharArray();
		char Y[] = "GXTXAYB".toCharArray();
		
		LCSOverlapingProb pro = new LCSOverlapingProb();
		System.out.println(pro.LCS(X, Y, X.length, Y.length));
		
	}
	
	private int LCS(char[] c , char[] s , int m , int n) {
		int[][] lcsCommon = new int[m+1][n+1];
		
		for(int i = 0 ; i <= m ; i++) {
			for(int j = 0 ; j <= n ; j++) {
				if(i==0 || j ==0) {
					lcsCommon[i][j] = 0;
				}else if(c[i-1]==s[j-1]) {
					lcsCommon[i][j] = 1 + lcsCommon[i-1][j-1];
				}else {
					lcsCommon[i][j] = Math.max(lcsCommon[i-1][j], lcsCommon[i][j-1]);
				}
			}
		}
		return lcsCommon[m][n];
	}

}
