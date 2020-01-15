package ds.programming.practice.dynamic;

public class LongestCommonSubSequence2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String c  = "AGGTAB";
		  String s = "GXTXAYB";
		
		LongestCommonSubSequence2 sq = new LongestCommonSubSequence2();
		System.out.println(sq.LCS(c.toCharArray(), s.toCharArray(), c.length(), s.length()));
		System.out.println(sq.LCSDynamic(c.toCharArray(), s.toCharArray(), c.length(), s.length()));
	}
	
	public int LCS(char[] c , char[] s , int m , int n) {
		if(m==0 || n==0) {
			return 0;
		}
		if(c[m-1]==s[n-1]) {
			return 1+ LCS(c,s,m-1,n-1);
		}else {
			return Math.max(LCS(c,s,m-1,n), LCS(c,s,m,n-1));
		}
	}
	
	public int LCSDynamic(char[] c , char[] s , int m , int n) {
		
		int[][] result = new int[m+1][n+1];
		
		for(int i = 0 ; i <= m ; i++) {
			for (int j=0 ; j <= n;j++) {
				if(i==0 || j==0) {
					result[i][j] = 0;
				}else if(c[i-1] == s[j-1]) {
					result[i][j] = 1+ result[i-1][j-1];
				}else {
					result[i][j] = Math.max(result[i-1][j],result[i][j-1]);
				}
			}
		}

		return result[m][n];
	}

}
