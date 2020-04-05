package com.org.problemsolving.dp.first;

import java.util.Arrays;

import com.org.problemsolving.ds.first.tree.DataStructureHelper;

public class MinimumPairInArraySol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = DataStructureHelper.getArray();
		int[] arra2 = DataStructureHelper.getArray();
		
		int[] mergerArray = new MinimumPairInArraySol().mergeSort(array);
		
		
		System.out.println(Arrays.toString(arra2));
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(mergerArray));
		
		int minValue = getMinDiffrence(mergerArray);
		
		System.out.println(minValue);
		
	}

	private static int getMinDiffrence(int[] mergeSort) {
		// TODO Auto-generated method stub
		int minDiffrence=mergeSort[0];
		for(int i=0;i<mergeSort.length-1;i++){
			 int tempMinDiffrence = mergeSort[i]-mergeSort[i+1];
			 if(minDiffrence>tempMinDiffrence){
				 minDiffrence=tempMinDiffrence;
			 }
		}
		
		return minDiffrence;
	}

	private int[] mergeSort(int[] array){
		  
		if(array.length==1){
			return array;
		}
		int mid  = array.length/2;

		int[] l1 = mergeSort(getArray(array, 0, mid)) ;
		int[] l2 = mergeSort(getArray(array, mid, array.length));		
		int[] mergedArray = merge(l1,l2);
		
		return mergedArray;
		
	}
	
	private int[] merge(int[] l1 , int[] l2){

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
	
	
	private int[] getArray(int[] array,int beginIndex,int endIndex){
	    int[] subArray = new int[endIndex-beginIndex];
		  for(int i=beginIndex,j=0 ; i<endIndex;i++,j++){
			  subArray[j] = array[i];
		  }
		return subArray;
	}
}
