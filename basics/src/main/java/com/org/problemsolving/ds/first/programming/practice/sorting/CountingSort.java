package com.org.problemsolving.ds.first.programming.practice.sorting;

import java.util.Arrays;

import com.org.problemsolving.ds.first.programming.practice.ds.DataStructureHelper;

public class CountingSort {
	
	public static void main(String[] args) {
		int[] array = DataStructureHelper.getArray();
		
		CountingSort countingSort = new CountingSort();
		
		array = countingSort.countingSort(array);
		
		DataStructureHelper.printArray(array);
	    
	}
	
	
	private int[] countingSort(int[] array){
		if(array.length<0){
			throw new RuntimeException("No Array for sorting");
		}
		
		int[] count = new int[getMax(array)+1];
		
		int[] output = new int[array.length];
		
		Arrays.fill(count, 0);
		
		for(int ele : array){
			count[ele]++;
		}
		
		for(int i=1 ; i< count.length ;i++){
			count[i]+=count[i-1];
		}
		
		for(int ele : array){
			output[count[ele]-1] = ele;
			count[ele]--;
		}
		return output;
	}
	
	private int getMax(int[] array){
	         
		int max = array[0];
		
		for(int ele :array){
			if(ele > max){
				max = ele;
			}
		}
		return max;
	}
}


