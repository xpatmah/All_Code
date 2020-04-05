package com.org.problemsolving.dp.first;

public class UglyNumbers {

	public static void main(String[] args){
		
		int input = 7;
		
		System.out.println(getNthUglyNo(input));
		
	}
	
	public static int getNthUglyNo(int no){
		
		int i=0;
		int count = 0;
		while(no > count){
			i++;
			if(isUgly(i)){
              count++;				
			}
		}
		return i;
		
	}
	
	public static boolean isUgly(int a){
		a = divide(a, 2);
		a = divide(a, 3);
		a = divide(a, 5);
		boolean result = a == 1 ? true : false; 
		return result;
	}
	
	public static int divide(int a , int b){
		while(a%b ==0){
			a = a/b;
		}
		return a;
	}
	
}
