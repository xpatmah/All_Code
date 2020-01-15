package com.org.problemsolving.ds.first.programming.practice;

public class TraverseMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 int M[][] = {
			        {1, 2, 3, 4},     
			        {5, 6, 7, 8},     
			        {9, 10, 11, 12},
			        {13, 14, 15, 16}, 
			        {17, 18, 19, 20},
			        };
		 int rowCount = M.length;
		 int columnCount = M[0].length;
	 
		 int k =0;
		 int l =0;
		 
		 while(k < rowCount && l < columnCount) {
			 
			 for(int i = l ; i < columnCount ;i++) {
				 System.out.print(M[k][i]);
			 }
			 
			 k++;
			 
			 for(int i = k ;i< rowCount ;i++) {
				 System.out.print(M[i][columnCount-1]);
			 }
			 
			 columnCount--;
			 
			 if(k < rowCount) {
				 for(int i = columnCount -1 ; i >= l ; i--) {
					 System.out.print(M[rowCount-1][i]); 
				 }
				 rowCount--;
			 }
			 
			 if(l < columnCount) {
				 for(int i = rowCount-1 ; i >= k ; i--) {
					 System.out.print(M[i][l]); 
				 }
				 l++;
			 }
		 }
	}

}
