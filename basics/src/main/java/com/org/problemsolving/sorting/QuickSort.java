package com.org.problemsolving.sorting;

import com.org.problemsolving.ds.first.tree.DataStructureHelper;

public class QuickSort {

		public static void main(String[] args){
			
			QuickSort sort = new QuickSort();
			sort.quickSort(DataStructureHelper.getArray());
			
		}
		
		public  void quickSort(int[] array){
			quickSort(array , 0 , array.length-1);
			
			DataStructureHelper.printArray(array);
		}
		
		private void quickSort(int[] array ,int lo , int hi){
			 
            if(lo >=hi){
            	return;
            }			
			
			int pivot = array[(lo + hi) >> 1]; 
		    
			int partitionIndex = partitioning(array , lo , hi , pivot);
			
			quickSort(array , lo ,partitionIndex );
			quickSort(array ,partitionIndex+1 ,hi);
			
		}
		
		private int partitioning(int[] array ,int lo , int hi , int pivot){
		    while(lo < hi){
                 while(array[lo] < pivot){
                	 lo++;
                 }
                 while(array[hi] > pivot ){
                	 hi--;
                 }
                 if(lo<hi){
                	 int temp = array[lo];
                	 array[lo] = array[hi];
                	 array[hi] = temp;
                 }
		    }
			return lo;
		}
}
