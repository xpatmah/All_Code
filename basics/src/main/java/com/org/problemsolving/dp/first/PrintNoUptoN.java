package com.org.problemsolving.dp.first;

public class PrintNoUptoN {

	public static void main(String[] args) {
		
		PrintNoUptoN no = new PrintNoUptoN();
		no.printtheNo(10);
	}
	
	
	private void printtheNo(int n){
		if(n==0) {
			return;
		}else {
			printtheNo(n-1);
		}
		System.out.println(n);
	}
	
	
}
