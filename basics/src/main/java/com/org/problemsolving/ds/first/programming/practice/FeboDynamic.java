package com.org.problemsolving.ds.first.programming.practice;

import java.math.BigInteger;
import java.util.Arrays;

public class FeboDynamic {

	public static void main(String[] args){
		
		FeboDynamic fibo = new FeboDynamic();
		System.out.println(fibo.fiboIterative(new BigInteger("3")));
		 
		int[] array = new int[3+1];
		Arrays.fill(array, 0);
		array[1] = 1;
		System.out.println(fibo.fiboRecursive(array, 3));
		
	}

	public BigInteger fiboIterative(BigInteger n){
		BigInteger[] fibi = new BigInteger[n.intValue()];
		
		fibi[0] = new BigInteger("0");
		fibi[1] = new BigInteger("1");
		
		for(int i=2; i< n.intValue();i++){
			fibi[i] = fibi[i-1].add(fibi[i-2]); 
		}
		
		return fibi[(n.subtract(new BigInteger("1"))).intValue()];
	}
	
	public int fiboRecursive(int[] fiboarray , int n){
		if (n==0 || n == 1){
			return fiboarray[n];
		}else{
			if (fiboarray[n] !=0){
				return fiboarray[n];
			}else{
				fiboarray[n] = fiboRecursive(fiboarray , n-2) + fiboRecursive(fiboarray, n-1);
			}
		}
		return fiboarray[n-1];
	}
	
}
