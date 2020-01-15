package com.org.problemsolving.dp.first;

import java.util.Arrays;

public class ArrayRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int rotation = 3;
		
		int[] arrayTorotation =  {1, 2, 3, 4, 5, 6, 7};
		
		System.out.println(Arrays.toString(arrayTorotation));
		
		ArrayRotation arrayrotate = new ArrayRotation();
		arrayrotate.rotate(rotation, arrayTorotation);
		System.out.println(Arrays.toString(arrayTorotation));
		
	}
	
	private void rotate(int countToRotate , int[] array) {
		
		for(int i = 0 ; i < countToRotate ; i++) {
			
			int temp = array[0];
			
			int j = 1 ; 
			
			while(j<array.length) {
				array[j-1] = array[j];
				j++;
			}
			
			array[j-1] = temp;
		}
		
	}
	

}
