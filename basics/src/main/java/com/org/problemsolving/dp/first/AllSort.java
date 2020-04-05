package com.org.problemsolving.dp.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AllSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = {98,32,21,67,22,12,34,56,76,54,33};

		int[] mergrarray  = {98,32,21,67,22,12,34,56,76,54,33};

		insertionSort(array);

		System.out.println(Arrays.toString(mergeSort(mergrarray)));	

		System.out.println(Arrays.toString(quickSort( new int[]{98,32,21,67,22,12,34,56,76,54,33} , 0 , mergrarray.length-1)));

		System.out.println(Arrays.toString(counting(new int[]{98,32,21,67,22,12,34,56,76,54,33})));

        dateSort();
		for(int i =2 ;i < 5 ;i++){
			allpossibleCombination(new int[]{98,32,21,67,22,12,34,56,76,54,33},i);
		}
       
		 for(String str : string){
			  System.out.println(str);
		  }
		}
	
	    private static void allpossibleCombination(int[] array , int r) {
		
		  int[] data = new int[r];
		  getAllPossibleCombination(array, data, 0, array.length-1, 0, r);

	    }
	    
	    static List<String> string = new ArrayList<>();
	    
	    private static void getAllPossibleCombination(int[] array , int[] data , int start , int end , int index , int r){
	    	
	    	if(index ==r){
	    		string.add(Arrays.toString(data));
	    		return;
	    	}

	        for (int i = start ; i <= end && end-i+1 >= r-index ; i++){
	        	data[index] = array[i];
	        	getAllPossibleCombination(array, data, i+1, end, index+1, r);
	        }	
	    }

		private static int[] counting(int[] array) {
	    	
	    	int maxEle = getMaxElement(array);
	    	
	    	int[] countArray = new int[maxEle];
	    	
	    	int[] outputarray = new int[array.length];
	    	
	    	Arrays.fill(countArray, 0);
	    	
	    	for(int ele : array){
	    		countArray[ele]++;
	    	}
	    	
	        for(int i =1 ; i< countArray.length ; i++){
	        	countArray[i] += countArray[i-1];
	        }	
	    	
	    	for (int ele : array){
	    		outputarray[countArray[ele]-1] = ele;
	    		countArray[ele]--;
	    	}
	    	
	    	
		return outputarray;
	}

		private static int getMaxElement(int[] array) {
			
			int max=  array[0];
			
			for(int i=1; i < array.length;i++){
				if(max < array[i]){
					max = array[i];
				}
			}
			
			return max+1;
		}

		private static void dateSort() {
	    		String[] arrayList = { "27-01-2017", "01-02-2011", "3-8-2018", "9-9-2010"};
		       
	    	List<String> strings = Arrays.asList(arrayList);
	    	Collections.sort(strings, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					// TODO Auto-generated method stub
					String[] splito1 = o1.split("-");
					String[] splito2 = o2.split("-");
					
					if(Integer.parseInt(splito1[2]) == Integer.parseInt(splito2[2])){
						if(Integer.parseInt(splito1[1]) == Integer.parseInt(splito2[1])){
							if(Integer.parseInt(splito1[0]) == Integer.parseInt(splito2[0])){
								return 0;
							}else if(Integer.parseInt(splito1[0]) > Integer.parseInt(splito2[0])){
								return 1;
							}else {
								return -1;
							}
						}else if(Integer.parseInt(splito1[1]) > Integer.parseInt(splito2[1])){
							return 1;
						}else {
							return -1;
						}
					}else if(Integer.parseInt(splito1[2]) > Integer.parseInt(splito2[2])){
						return 1;
					}else {
						return -1;
					}
				}
			});
	    	for(String str : strings){
	    		String[] spli = str.split("-");
	    		StringBuffer buffer = new StringBuffer();
	    		
	    		for(String str2 : spli){
	    			if(Integer.parseInt(str2) < 10){
	    				buffer.append(str2.replace("0", "")).append("-");
	    			}else{
	    				buffer.append(str2).append("-");
	    			}
	    		}
               
	    		buffer.setLength(buffer.length()-1);
	    		
	    		System.out.println(buffer.toString());
	    	}
		
	}

		private static int[] quickSort(int[] array, int lo, int hi) {
		// TODO Auto-generated method stub
	      if(lo >= hi){
	    	  return array;
	      } 	
	    	
	      int pivot = array[(lo+hi)>>1];
	      
	    int partioning = partioning(array, lo, hi , pivot);
	    
	    quickSort(array, lo, partioning);
	   
	    quickSort(array, partioning+1, hi);
	    
		return array;
	}

	    public static int partioning(int[] array , int lo , int hi, int pivot){
	    	
	    	while(lo < hi){
	    		while(array[lo] < pivot){
	    			lo++;
	    		}
	    		while(array[hi] > pivot){
	    			hi--;
	    		}
	    		
	    		if(lo < hi){
	    			int temp = array[lo];
	    			array[lo] = array[hi];
	    			array[hi] = temp;
	    		}
	    		
	    	}
	    	return lo;
	    	
	    }
	    
		public static void insertionSort(int[] array){
	    	
	    	for(int i = 1 ; i< array.length;i++){
	    		
	    		int key = array[i];
	    		
	    		int j = i-1;
	    		
	    		while(j >= 0 && array[j] > key){
	    			
	    			array[j+1] = array[j];
	    			j--;
	    		}
	    		
	    		array[j+1] = key;
	    	}
	    	System.out.println(Arrays.toString(array));	
	    }
	    
	    public static int[] mergeSort(int[] array){
	    	
	    	if(array.length==1){
	    		return array;
	    	}
	    	
	    	int mid = array.length>>1;
	    	
	    	int[] l1 = mergeSort(getArray(array , 0 , mid));
	    	
	    	int[] l2 = mergeSort(getArray(array , mid , array.length));
	    	 
	    
	    	return merge(l1,l2);
	    }
	    
	    public static int[] getArray(int[] array , int start , int end){
	    	int[] newArray = new int[end-start];
	    	for(int i = start ,j=0 ; i< end;i++,j++){
	    		newArray[j] = array[i];
	    	}
	    	//System.out.println(Arrays.toString(newArray));
	    	return newArray;
	    }
	
	    public static int[] merge(int[] l1 , int[] l2){
	    	
	    	int[] mergeArray = new int[l1.length + l2.length];

	    	int i=0;
	    	int j=0;
	    	int k=0;
	    	
	    	while(i < l1.length && j< l2.length){
	    		if(l1[i] > l2[j]){
	    			mergeArray[k++] = l1[i++];
	    		}else{
	    			mergeArray[k++] = l2[j++];
	    		}
	    	}
	    	
	    	while(i < l1.length){
	    		mergeArray[k++] = l1[i++];
	    	}
	    	
	    	while(j< l2.length){
	    		mergeArray[k++] = l2[j++];
	    	}
	    	
	    	return mergeArray;
	    }
	    
}
