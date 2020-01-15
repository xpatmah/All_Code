package com.org.problemsolving.ds.first.programming.practice.dynamic;

public class FindNumbers {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr ={1, 2, 3, 2, 1, 4};
		FindNumbers quickSortBasic = new FindNumbers();
		quickSortBasic.basicQuickSort(arr, 0, arr.length-1);
		for (int i = 0 ;i < arr.length ; i++){
			System.out.print(" "+arr[i]+",");
		}
		System.out.println();
		quickSortBasic.printTwoUniqueNo(arr);
		
	}

	
	public void printTwoUniqueNo(int[] arr){
		for(int i = 0 ; i < arr.length ;i++){
			if(i+1 < arr.length && arr[i] == arr[i+1]){
				continue;
			}else if(arr[i] == arr[i-1]){
				continue;
			}else{
				System.out.println(arr[i]);
			}
		}
	}
	
	public void basicQuickSort(int[] array , int lo , int hi){
        
		if(lo >= hi){
			return;
		}
		int pivot = array[(lo+hi) >> 1];
		
		int partitioarray = partionSort(array, lo, hi, pivot);
		
		basicQuickSort(array, lo, partitioarray-1);
        basicQuickSort(array, partitioarray, hi);
	
	}
	
	public int partionSort(int[] array , int lo , int hi , int pivot){
		while(lo <= hi){
			while(array[lo] < pivot){
				lo++;
			}
			while(array[hi] > pivot){
				hi--;
			}
			if(lo <= hi){
				int temp = array[hi];
				array[hi] = array[lo];
				array[lo] = temp;
				lo++;
				hi--;
			}
		}
		return lo;
	}
	
}
