package com.org.problemsolving.dp.first;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = {100,80,29,1,5,9,7,28};
		QuickSort sort = new QuickSort();
		sort.quickSort(array, 0, array.length-1);
		
		System.out.println(Arrays.toString(array));
	}
	
	
	public int[] quickSort(int[] array , int start , int end){
		if(start >= end){
			return array;
		}
		
		int pivot = (start + end) >> 1 ; 
		
		int partition = partition(array, start, end, array[pivot]);
		
		array = quickSort(array, start, partition-1);
		
		array = quickSort(array, partition, end);
		
		return array;
	}
	
	
	public int partition(int[] arr , int start , int end , int pivot){
		
		int i = start;
		int j  = end;
		
		while(i <= j){
			while(pivot > arr[i]){
				i++;	
			}
			while(pivot < arr[j] ){
				j--;
			}
			if(i<= j){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		return i;
	}

}
