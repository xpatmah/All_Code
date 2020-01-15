package com.org.problemsolving.ds.first.programming.practice.dynamic;

public class BinomialCoefficient {

	public static void main(String[] args) {
		
		System.out.println(binomialCoefficient(4, 2));
		
		System.out.println(binomialCoefficient(5, 2));
		
		System.out.println(binomialCoefficientDy(5, 2));
		
		System.out.println(binomialWithSpace(5, 2));
	}
	
	public static int binomialCoefficient(int n , int k) {
		if(k==0 || k==n) {
			return 1;
		}
		else {
			return binomialCoefficient(n-1, k-1) + binomialCoefficient(n-1, k);
		}
	}
	
	public static int binomialCoefficientDy(int n , int k) {
		
		int[][] c = new int[n+1][k+1];
		for(int i=0 ; i <=n ; i++) {
			for(int j =0 ; j <= Math.min(i, k) ;j++) {
				if(j==i || j ==0) {
					c[i][j] = 1;
				}else {
					c[i][j] = c[i-1][j-1] + c[i-1][j];
				}
			}
		}
		return c[n][k];
	}
	
	public static int binomialWithSpace(int n , int k) {
		
		int[] c = new int[k+1];
		c[0] = 1;
		for(int i = 1 ; i <=n;i++) {
			for(int j = Math.min(i,k); j>0 ;j--) {
				c[j] = c[j]+ c[j-1]; 
			}
		}
		return c[k];
	}
	
	
}
