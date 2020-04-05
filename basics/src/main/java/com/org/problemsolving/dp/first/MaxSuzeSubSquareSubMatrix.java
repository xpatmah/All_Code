package com.org.problemsolving.dp.first;

public class MaxSuzeSubSquareSubMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int M[][] =  {	{0, 1, 1, 0, 1}, 
				 		{1, 1, 0, 1, 0}, 
				 		{0, 1, 1, 1, 0},
				 		{1, 1, 1, 1, 0},
				 		{1, 1, 1, 1, 1},
				 		{0, 0, 0, 0, 0}
				 	  };
         
		 	printMaxSubSquare(M);
	}

	private static void printMaxSubSquare(int[][] m) {
		// TODO Auto-generated method stub
		
		int[][] copyArray = new int[m.length][m[0].length];
		int i_max =0;
		int j_max = 0;
		int max = 0;
		
		for(int i = 0 ; i< m.length; i++){
			for(int j = 0 ; j < m[0].length ; j++){
				if(i ==0 || j ==0){
					copyArray[i][j] = m[i][j];
				}else{
					if( m[i][j]==1){
						copyArray[i][j] = min(copyArray[i-1][j-1],copyArray[i-1][j],copyArray[i][j-1]) + 1;
					}else{
						copyArray[i][j] = 0;
					}
					
				}
				if(max <= copyArray[i][j]){
					max = copyArray[i][j];
					i_max = i;
					j_max = j;
				}
			}
		}
		
		for(int i = i_max ; i > i_max - max ; i--){
			for(int j = j_max ; j > j_max - max ; j--){
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private static int min(int a , int b , int c){
		if(a > b){
			return b > c ? c :b;
		}else{
			return a > c ? c :a;
		}
	}
	
	

}
