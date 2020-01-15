package com.org.problemsolving.ds.first.programming.practice.ds;

public class SortingAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = {23,45,67,12,34,62,44,33};
	
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+", ");
		}
		
		selectionSort(array);
		System.out.println("");
		System.out.println("");
		System.out.println("After sorting");
		
		System.out.println("");
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+", ");
		}
	}
	
	
	public static int[] selectionSort(int[] arr){
		
		for(int i=0;i<arr.length;i++){
			int min = arr[i];
			int index=i;
			for(int j=i+1;j<arr.length;j++){
				if(min>arr[j]){
					min=arr[j];
					index=j;				
				}
			}
				if(index!=i){
					arr[index]=arr[i];
					arr[i]=min;
				}
		}
		return arr;
	}
}
