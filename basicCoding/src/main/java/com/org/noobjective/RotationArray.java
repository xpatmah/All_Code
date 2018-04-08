package com.org.noobjective;

import java.util.Arrays;

public class RotationArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = {1, 2, 3, 4, 5, 6, 7};
		System.out.println(Arrays.toString(rotation(array, 3,8)));
		
	}
	
	
	public static int[] rotation(int[] array, int d , int size){
		for (int i =0 ; i < d ; i++){
			int temp = array[0];
			int j;
			for(j=0;j< array.length-1;j++){
				array[j] = array[j+1];
			}
			array[j] =  temp;
		}
		return array;
	}

}
