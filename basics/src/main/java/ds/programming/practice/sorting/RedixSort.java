package com.org.java.sorting;

import com.org.java.ds.DataStructureHelper;

public class RedixSort {

	public static void main(String[] args){
        
		int[] array = DataStructureHelper.getRedixArray();
		
		RedixSort sort = new RedixSort();
		
		DataStructureHelper.printArray(sort.sort(array));
		
	}

	public int[] sort(int[] array){
		int m = getMaxNumber(array);
		
		
		for(int i=1 ; (m/i)>1 ; i*=10){
			array = countingBasedOnLSD(array,i);
		}
		return array;
	}
	
	private int[] countingBasedOnLSD(int[] array , int divisor){
		
		int[] count = new int[10];
		int[] output = new int[array.length];

		for(int i=0 ;i < count.length;i++){
			count[i]=0;
		}
		
		for(int i=0 ;i<array.length;i++){
			count[(array[i]/divisor)%10] += 1;
		}

		for(int i=1;i<count.length;i++){
			count[i] = count[i-1]+count[i];
		}
		
		for(int i =array.length-1 ;i >=0;i--){
			
			output[count[(array[i]/divisor)%10]-1] = array[i];
			count[(array[i]/divisor)%10]--;
		}
		
		for(int i=0;i< array.length;i++){
			array[i] = output[i];
		}
		return array;
		
	}
	
	private int getMaxNumber(int[] array){
		if(array.length==0){
			return Integer.MAX_VALUE;
		}
		int max = array[0];
		
		for(int ele : array){
			if(ele > max){
				max = ele;
			}
		}
		return max;
	}
	
}
