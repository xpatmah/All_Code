package com.org.java.ds;

import java.util.Arrays;

public class DataStructureHelper {

	public static int[] getArray(){
		int[] arr ={98,32,21,67,22,12,34,56,76,54,33};
		return arr;
	}
	
	public static int[] getRedixArray(){
		int[] arr ={989,332,221,167,222,12,344,569,796,574,363};
		return arr;
	}
	
	public static int[] getArrayWithMinusValues(){
		int[] arr ={12,-1,21,67,-22,98,-34,56,-76,54,-33};
		return arr;
	}
	
	public static void printArray(int[] array){
		
		String arrayinString = Arrays.toString(array);
		
		System.out.println(arrayinString);
	}
	
	public static int[] getSortedArray(){
		int[] arr ={12,15,21,45,48,54,58,67,84,89,97};
		return arr;
	}
	
	public static int[][] get2Darray(){
		int[][] TwoDarray ={{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5}};
		return TwoDarray;
	}
	
	public static int[] getArrayWithPlusAndMinus(){
		int[] arr ={-12,4,21,-67,22,0,34,56,0,54,-24};
		return arr;
	}
	
	
}
