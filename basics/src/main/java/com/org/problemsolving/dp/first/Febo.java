package com.org.problemsolving.dp.first;

public class Febo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          int[][] array = {{1,1},{1,0}};
          
          int[][] sarray = {{1,1},{1,0}};
          
          int n = 7;
          Febo f1 = new Febo();
          System.out.println(f1.fibo(array , n-1));
          System.out.println(f1.fiboWithPower(sarray, n-1));
		
	}
	
	
	private int fibo(int[][] sary , int n) {
		
		int[][] cary = {{1,1},{1,0}};
		
		for(int i = 0 ; i < n-2;i++) {
			multiply(sary, cary);
		}
		return sary[0][0];
	}

	private void multiply (int[][] sary, int[][] cary) {
		
		int a = sary[0][0]*cary[0][0] + sary[0][1]*cary[1][0];
		int b = sary[0][0]*cary[0][1] + sary[0][1]*cary[1][1];
		int c = sary[1][0]*cary[0][0] + sary[1][1]*cary[1][0];
		int d = sary[1][0]*cary[0][1] + sary[1][1]*cary[1][1];
				
		sary[0][0] = a;
		sary[0][1] = b;
		sary[1][0] = c;
		sary[1][1] = d;
		
	}
	
	private int fiboWithPower(int[][] sary , int n) {
		
		if(n==0) {
			return 0;
		}else if(n==1) {
			return 1;
		}
		
		int[][] cary = {{1,1},{1,0}};
		
		fiboWithPower(sary , n/2);
		multiply(sary, sary);
		
		if(n%2==0) {
			multiply(sary, cary);
		}
		return sary[0][0];
	}

	
}
