package com.org.dynamic.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HDS1 {

	// Program Name => Maximum no negative Sub Array
	
	public static void main(String[] args) {
	 
		int[] array = {0, 0, -1, 0};
		
		HDS1 hds1 = new HDS1();
		System.out.println(hds1.getMaxIndex(array));
		
	}
	
	private  List<Integer> getMaxIndex(int[] array) {
	
		int[] sumArray = new int[array.length]; 
		
		for(int i = 0 ;i < array.length ; i++) {
			
			if(array[i] < 0) {
				sumArray[i] = array[i];
				continue;
			}else if(i==0) {
				sumArray[i] = array[i];
			}else {
				if(sumArray[i-1] >0) {
					sumArray[i] = sumArray[i-1]+array[i];
				}else {
					sumArray[i] = array[i];
				}
			}
		}
		return findMaxIndexInterval(sumArray,array);
	}

	private List<Integer> findMaxIndexInterval(int[] array , int[] realArray) {
		// TODO Auto-generated method stub
		int maxIndex = 0;
		int maxNumber = array[0];
		List<Integer> list = new ArrayList<>();
		
		for(int i=1 ; i< array.length ;i++) {
			if(maxNumber <= array[i]) {
				maxIndex = i;
				maxNumber = array[i];
			}
		}
		
		for(int i = maxIndex ; i >= 0 ; i--) {
			if(realArray[i] > 0) {
				list.add(realArray[i]);
			}
		}
		
		Collections.reverse(list);
		return list;
	}
	
	

}
