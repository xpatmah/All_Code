package com.org.java.ds.prog;

public class SortIdentificationUsingRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = {23,56,67,78,79,90};
		
	   boolean result = reconnizeSorting(array , array.length);
		
	}

	private static boolean reconnizeSorting(int[] array ,int index ) {
		// TODO Auto-generated method stub
		if(array.length==1){
			return true;
		}
		
		if(index==1){
			return true;
		}
		
		return array[index-1] > array[index-2] ? reconnizeSorting(array, --index) : false ;
	}
	
	

}
