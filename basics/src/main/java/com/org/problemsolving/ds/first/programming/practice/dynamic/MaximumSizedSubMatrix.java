package com.org.problemsolving.ds.first.programming.practice.dynamic;

public class MaximumSizedSubMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int M[][] =  {{0, 1, 1, 0, 1}, 
						{1, 1, 0, 1, 0}, 
						{0, 1, 1, 1, 0},
						{1, 1, 1, 1, 0},
						{1, 1, 1, 1, 1},
						{0, 0, 0, 0, 0}};

			printMaxSubSquare(M);

	}

	private static void printMaxSubSquare(int[][] m) {
		// TODO Auto-generated method stub
		int[][] array = new int[m.length][m[0].length];
		
		int maxno = 0;
		int max_i = 0 ;
		int max_j = 0 ;
		
		for(int i = 0 ; i < m.length;i++) {
			for (int j = 0 ; j < m[0].length ; j++) {
			   if(i ==0 || j==0) {
				   array[i][j] = m[i][j];
			   }else if(m[i][j]==1){
				   array[i][j] = minNumber(array[i-1][j-1],array[i][j-1],array[i-1][j])+1;
			   }else {
				   array[i][j] = 0;
			   }
			   
			   if(maxno < array[i][j]) {
				   maxno = array[i][j];
				   max_i = i;
				   max_j = j;
			   }
			   
			}
		}
		
		for(int i = max_i ; i > max_i - maxno ; i--) {
			for(int j = max_j ; j > max_j - maxno ; j--) {
				System.out.print(m[i][j]);
			}
			System.out.println();
		}
		
	}
	
	private static int minNumber(int x, int y , int z) {
		if(x<y) {
			return z < x ? z : x;
		}else {
			return z < y ? z : y;
		}
	}

}
