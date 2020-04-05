package com.org.problemsolving.dp.first;

public class UglyNumber {
	
	
	public static void main(String[] args) {
		System.out.println(new UglyNumber().findNthNumber(150));
	}
	
	public int findNthNumber(int n) {
		
		int i = 1;
		int k=0;
		
		while(k!=n) {
			if(isUgly(i)) {
				k++;	
			}
			i++;
		}
		return i-1;
	}
	
	public boolean isUgly(int no) {
		
		no = divide(no, 2);
		no = divide(no, 3);
		no = divide(no, 5);
		
		if(no==1) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	protected final int divide(int no , int divisor) {
		
		while(no%divisor==0) {
			no = no/divisor;
		}
		
		return no;
	}
	
	
}
