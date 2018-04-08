package com.org.noobjective;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = {98,32,21,67,22,12,34,56,76,54,33};
		
		int[] mergrarray  = {98,32,21,67,22,12,34,56,76,54,33};
		
		insertionSort(array);
		
		System.out.println(Arrays.toString(mergeSort(mergrarray)));	
		
		System.out.println(Arrays.toString(quickSort( new int[]{98,32,21,67,22,12,34,56,76,54,33} , 0 , mergrarray.length-1)));
		
		System.out.println(Arrays.toString(counting(new int[]{98,32,21,67,22,12,34,56,76,54,33})));
		
	}

	
	public static void insertionSort(int[] array){
		
		for (int i = 1 ; i < array.length ; i++){
		 
			int key = array[i];
			
			int j = i-1;
			
			while ( j >= 0 && key < array[j]){
				array[j+1] = array[j];
				j--;
			}
			 array[j+1] = key;
		}
		
		System.out.println(Arrays.toString(array));	
	}
	
	public static int[] mergeSort(int[] array){
		
		if(array.length==1){
			return array;
		}

		int mid  = array.length >> 1; 
			
		int[] l1 = mergeSort(getArray(array, 0, mid));
		int[] l2 = mergeSort(getArray(array, mid, array.length));
		
		return merge(l1,l2);
	}
	
	public static int[] quickSort(int[] array , int lo , int hi){
		
		if(lo >= hi){
			return array;
		}

		int pivot  =  array[(lo+hi) >> 1]; 
			
		int partinioning  = partioning(array ,lo , hi ,pivot);
		
	    quickSort(array, lo, partinioning);
	    
	    quickSort(array, partinioning+1, hi);
		
	    return array;
	}
	
	public static int[] counting(int[] array){
		
		int maxelement = getMax(array);
		
		int[] count = new int[maxelement+1];
		
		int[] output = new int[array.length];
		
		Arrays.fill(count, 0);
		
		for (int ele : array){
			count[ele]++;
		}
		
		for (int i = 1 ;i < count.length ;i ++){
			count[i] += count[i-1];
		}
		
		for ( int ele : array ){
			output[count[ele]-1] = ele;
			count[ele]--;
		}
		return output;
	}
	
	private static int getMax(int[] array) {
		int max = array[0];
		for (int i = 1 ; i < array.length ; i++){
			if(max < array[i]){
				max = array[i];
			}
		}
		return max;
	}


	public static int partioning(int[]array , int lo , int hi,int pivot){
		
		while(lo < hi){
			
			while(array[lo] < pivot){
				lo++;
			}
			while(array[hi] > pivot){
				hi--;
			}
			if(lo < hi){
				int temp = array[hi];
				array[hi] = array[lo];
				array[lo] = temp;
			}
		}
		return lo;
	}
	
	
	public static int[] merge(int[] l1 , int[] l2){
		
		int[] array = new int[l1.length+l2.length];
		int i=0 ; 
		int j=0;
		int k=0;
		
		while( i < l1.length && j < l2.length){
			if(l1[i] > l2[j]){
				array[k++] = l1[i++];
			}else{
				array[k++] = l2[j++];
			}
		}
		while(i < l1.length){
			array[k++] = l1[i++];
		}
		while(j < l2.length){
			array[k++] = l2[j++];
		}
		return array;
	}
	
	
	private static int[] getArray(int[] array , int start , int end){
		int[] newArray = new int[end-start]; 
		
		for(int i = start, j=0 ; i < end;i++,j++){
			newArray[j] = array[i];
		}
	//	System.out.println(Arrays.toString(newArray));
		return newArray;
	}
	
}
