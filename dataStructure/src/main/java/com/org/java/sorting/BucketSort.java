package com.org.java.sorting;

import java.util.ArrayList;
import java.util.List;

import com.org.java.ds.DataStructureHelper;

public class BucketSort {

	private static final int DEFAULT_BUCKT_COUNT = 5;
	
	public static void main(String[] args) {
		
		int[] array = DataStructureHelper.getArray();
		
		BucketSort sort = new BucketSort();
		int[] sortedArray = sort.sort(array,DEFAULT_BUCKT_COUNT);
		DataStructureHelper.printArray(sortedArray);
	}
	
	private int[] sort(int[] array, int bucketSize){
		if(array.length <=0 ){
			return new int[]{0};
		}
		
		// Step 1 get min max in the list and determine the bucket count
		int min = array[0];
		int max = array[0];

		for(int i = 0 ; i< array.length ; i++){
			if(array[i] > max ){
				max = array[i];
			}else if(array[i] < min){
				min = array[i];
			}
		}
		
		int bucketCount = ((max - min)/bucketSize)+1;
		
		List<Integer>[] buckets = new ArrayList[bucketCount];
		
		for(int i=0;i<bucketCount;i++){
			buckets[i]=new ArrayList<Integer>();
		}
		
		for(int i = 0 ; i< array.length ; i++){
			buckets[(array[i]-min)/bucketSize].add(array[i]);
		}
		array = sorryListAndGetArray(buckets, array.length);
		
		return array;
	}

	private int[] sorryListAndGetArray(List<Integer>[] buckets , int length) {
		int[] array = new int[length];
		int i = 0;
		for(List<Integer> intLst : buckets){
			if(intLst.size()>0){
				int[] arrayys = getArraySorted(intLst);  
				for(int ele : arrayys){
					array[i++]= ele;
				}
			}
		}
		return array;
	}
	
	private int[] getArraySorted(List<Integer> ints){
		//Do the insertion sort for each list
		int[] arrayList = new int[ints.size()];
		// int i= 0;
		 for(int i=0 ; i< arrayList.length;i++){
			 int ele = ints.get(i);
	           if(i==0){
	        	   arrayList[i] = ele;
	           }else{
	        	   int j = i-1;
	        	   while(j >= 0){
	        		    if(arrayList[j] > ele){
	        		    	arrayList[j+1] = arrayList[j];
	        		    	j--;
	        		    } else{
	        		    	break;
	        		    }
	        	   }
	        	   arrayList[j+1]= ele;
	           } 
		 }
		return arrayList;
	}

}
