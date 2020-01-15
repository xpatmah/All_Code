package com.org.problemsolving.ds.first.programming.practice.sorting;

import com.org.problemsolving.ds.first.programming.practice.ds.DataStructureHelper;

public class InPlaceQuickSort {

	public static void main(String[] args) {
		
		InPlaceQuickSort sort = new InPlaceQuickSort();
		int[] array = DataStructureHelper.getArray();
		sort.quickSort(array, 0, array.length-1);
		DataStructureHelper.printArray(array);
	}
    
	
	private void quickSort(int[] arr , int start , int end){
		if(start>= end ){
			return ;
		}
		
		int index = partioningArray(arr , start , end);
		quickSort(arr , start , index-1);
		quickSort(arr , index+1 , end);
	}


	private int partioningArray(int[] arr, int start, int end) {
		int pivot = arr[end];
		
		int partition = start;
		
		for(int i = start; i< end ;i++){
			if(arr[i] < pivot){
				 int temp  = arr[i];
				 arr[i] = arr[partition];
				 arr[partition] = temp;
				 partition++;
			}
		}
		
		int swap = arr[end];
		arr[end] = arr[partition];
		arr[partition] = swap;
		
		return partition;
	}
	
	

}


