package com.org.java.ds.prog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class GreatestNumber {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		File f = new File("C:/Users/mpathak/Desktop/CD DRIVE/JavaCode/JavaProject/src/GreatestNoInput.txt");
		
	    BufferedReader reader = new BufferedReader(new FileReader(f));
		int noOfInput  = Integer.parseInt(reader.readLine());
	    
	    System.out.println(noOfInput);
	    String str=null;
	    while(null!=(str=reader.readLine())){
	    	char[] charray = str.toCharArray();
	    	int[] unsortedArray = new int[charray.length];
	    	int i=0;
	    	for(char ch : charray){
	    		unsortedArray[i++] = Integer.parseInt(ch+""); 
	    	}
	    	
	        int[] array = getSortedArray(unsortedArray);
	    	
	    }
	    
	}

	private static int[] getSortedArray(int[] array) {
		// TODO Auto-generated method stub
		return null;
	}

}
