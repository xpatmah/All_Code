package com.org.problemsolving.sorting;

import java.util.Arrays;

import com.org.problemsolving.ds.first.tree.DataStructureHelper;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		int[] arr = DataStructureHelper.getArray();
	
		int[] resultantArra = mergeSort(arr);
		
		System.out.print(Arrays.toString(resultantArra));
		
	}
	
	public static  int[] mergeSort(int[] arr){
		if(arr.length==1){
			return arr;
		}
		
		int mid = arr.length/2;
		
		int[] arr1 = mergeSort(getArray(arr,0,mid));
		int[] arr2=  mergeSort(getArray(arr,mid,arr.length));
		return merge(arr1 , arr2);
	}
	
	public static int[] merge(int[] l1 , int[] l2){

		int i=0;
		int j=0;
		int k=0;
		int[] combinedArray = new int[l1.length+l2.length];

		while(i<l1.length && j< l2.length){
			if(l1[i] >= l2[j]){
				combinedArray[k++]= l1[i];
				i++;
			}else{
				combinedArray[k++]=l2[j];
				j++;
			}
		}
		while(i<l1.length){
			combinedArray[k++]=l1[i++];
		}
		while(j<l2.length){
			combinedArray[k++]=l2[j++];
		}
		return combinedArray;
	}
	
	
	public static int[] getArray(int[] arr ,int initialIndex , int endIndex){
		 int[] subArray = new int[endIndex-initialIndex];
		  for(int i=initialIndex,j=0 ; i<endIndex;i++,j++){
			  subArray[j] = arr[i];
		  }
		return subArray;
		
	}
	
}
