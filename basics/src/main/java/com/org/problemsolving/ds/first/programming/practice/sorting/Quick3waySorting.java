package com.org.problemsolving.ds.first.programming.practice.sorting;

import com.org.problemsolving.ds.first.programming.practice.ds.DataStructureHelper;

public class Quick3waySorting {

	public static void main(String[] args) {
		
		int[] array  = DataStructureHelper.getArray();
		
		Quick3waySorting sort = new Quick3waySorting();
		
		sort.sort(array , 0,array.length-1);
     
		DataStructureHelper.printArray(array);
	}

	private void sort(int[] array, int lo, int hi) {
		if(lo >= hi){
			return;
		}
		
		int pivot = array[lo];
		int lt = lo;
		int gt = hi;
		
		int i = lo;
		
		while(i<=gt){
		   if(array[i] < pivot){
			   swap(array , lt++ , i++);
		   }else if (array[i] > pivot){
			   swap(array , gt-- , i);
		   }else{
			   i++;
		   }
		}
		
		sort(array , lo , lt-1);
		sort(array , gt+1 , hi);
		
	}
	
	
	private void swap (int[] array , int i , int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
}
