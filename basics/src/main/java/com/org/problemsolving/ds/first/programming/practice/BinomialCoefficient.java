package com.org.problemsolving.ds.first.programming.practice;

import java.util.Arrays;

public class BinomialCoefficient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int k = 2;
		System.out.println(new BinomialCoefficient().binomialCoefficient(n, k));
		System.out.println(new BinomialCoefficient().getBinomialCoefficient(n, k));
		System.out.println(new BinomialCoefficient().getBinomialCoefficientInOn(n, k));
	}

	public int binomialCoefficient(int n , int k) {
		if(k==0 || k==n)
		    return 1;
		else {
			return binomialCoefficient(n-1, k-1) + binomialCoefficient(n-1, k);
		}
	}
	
	public int getBinomialCoefficient(int n , int k) {
		int[][] c = new int[n+1][k+1];
		
		for(int i = 0 ; i <= n ;i++) {
			for(int j = 0 ; j <= Math.min(i , k); j++){
				if( j==0 || j== i ) {
					c[i][j] = 1; 
				}else {
					c[i][j] = c[i-1][j-1] + c[i-1][j];
				}
			}
		}
		return c[n][k];
	}
	
	public int getBinomialCoefficientInOn(int n , int k) {
		int[] c = new int[n+1];
		Arrays.fill(c, 0);
		c[0] = 1;
		for(int i  = 1 ;  i <= n ; i++) {
			for(int j = Math.min(i, k) ; j >0 ;j--) {
				c[j] += c[j-1];
			}
		}
		return c[k];
	}
	
}
