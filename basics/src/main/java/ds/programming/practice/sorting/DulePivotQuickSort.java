package com.org.java.sorting;

import com.org.java.ds.DataStructureHelper;

public class DulePivotQuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DulePivotQuickSort sort = new DulePivotQuickSort();
		int[] array = DataStructureHelper.getArray();
		sort.quickSort(array, 0 , array.length-1);
		DataStructureHelper.printArray(array);
	}

	private void quickSort(int[] array, int start, int end) {
		if(start >= end){
			return;
		}
		
		int i = start+1 ; 
		int lo = start ;
		int hi = end;

		//this is very important and critical condition 
		if(array[lo] > array[hi]){
			swap(array , lo , hi);
		}
		int lt = start+1;
		int gt = end -1;
		
		while(i<=gt){
			if(array[i] < array[lo]){
				swap(array , lt++, i++);
			}else if(array[i] > array[hi]){
				swap(array , gt-- , i);
			}else{
				i++;
			}
		}
		
		swap(array , lo , --lt);
		swap(array , hi , ++gt);
		
		quickSort(array , lo , lt-1);
		if(array[lt] < array[gt]){
			quickSort(array , lt+1 , gt-1);
		}
		quickSort(array , gt+1 , hi);
		
	}
	
	public void swap(int[] arr , int i , int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	

}

