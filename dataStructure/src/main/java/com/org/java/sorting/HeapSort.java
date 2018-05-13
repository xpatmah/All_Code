package com.org.java.sorting;

import com.org.java.ds.DataStructureHelper;

public class HeapSort {

	public static void main(String[] args) {
		
		int[] arr = DataStructureHelper.getArray();
		
		HeapSort sort = new HeapSort();
		
		sort.sort(arr);
		
		DataStructureHelper.printArray(arr);

	}

	
	public void sort(int[] arr){
		//Step 1  Build a heap
        int n =  arr.length;
		
		for(int i = (n>>1)-1 ; i>=0;i-- ){
			heapify(arr , n , i);
		}
		// Step 3  Swap the last element in case of 
		
		for(int i = n-1 ;i >=0 ;i--){
			int temp = arr[0];
			arr[0] = arr[i];
			
			arr[i] = temp;
			heapify(arr, i, 0);
		}
	}
	
	
	
	private void heapify(int[] arr, int n, int i){
		
		int largestElement = i;
		int left = (i<<1)+1;
		int right = (i<<1)+2;
		
		if(left < n && arr[left] > arr[largestElement]){
			largestElement = left;
		}
		
		if(right < n && arr[right] > arr[largestElement]){
			largestElement = right;
		}
		
		if(largestElement!=i){
			int temp = arr[largestElement];
			arr[largestElement] = arr[i];
			arr[i] = temp;
			
			heapify(arr, n , largestElement);
		}
	}
}
