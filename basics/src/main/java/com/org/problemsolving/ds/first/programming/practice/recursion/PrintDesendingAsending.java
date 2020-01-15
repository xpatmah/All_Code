package com.org.problemsolving.ds.first.programming.practice.recursion;

public class PrintDesendingAsending {

	public static void main(String[] args) {
		printNo(6);
	}
	
	private static void printNo(int no) {
		if(no<1) {
			return;
		}
		else {
			System.out.print(no+",");
			printNo(no-1);
			System.out.print(no+",");
		}
	}	
}
