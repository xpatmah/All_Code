package com.org.java.ds.prog;

import com.org.java.ds.DataStructureHelper;

public class DiagonalSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		int[][] TwoDarray =DataStructureHelper.get2Darray();
	
		System.out.println(Math.abs(getSumOfbackWordDiagnal(TwoDarray)-getSumOfforWordDiagnal(TwoDarray)));
		
	}

	private static int getSumOfforWordDiagnal(int[][] twoDarray) {
		// TODO Auto-generated method stub
		int sum=0;
		for(int row=0,column=twoDarray[0].length-1;row<twoDarray[0].length;row++,column--){
			sum+=twoDarray[row][column];
		}
		
		return sum;
	}

	private static int getSumOfbackWordDiagnal(int[][] TwoDarray) {
		// TODO Auto-generated method stub
		int width =TwoDarray[0].length;
		int sum=0;
		for(int i=0;i<width;i++){
			sum+=TwoDarray[i][i];
		}
		return sum;
	}
	
}
