package com.org.noobjective;

import java.util.Arrays;

public class ClothExposedToSun {

	private int[] array = new int[10];
	
	int maxindex = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] stringPairs =  {"2,4","6,8","10,12","3,11","13,14","14,16","20,23","1,17"}; // Considering i will get the sorted array if 
		// it is not the case i will have to sort the array based on the length
		ClothExposedToSun cloths = new ClothExposedToSun();
		cloths.start(stringPairs);
		System.out.println(cloths.getCount());
	}
	
	public void start(String[] stringPairs){
		Arrays.fill(array, 1);
		for(String pairs : stringPairs ){
		    String[] pairArray = pairs.split(",");
			int start = Integer.parseInt(pairArray[0]);
			int end = Integer.parseInt(pairArray[1]);
			if(end > maxindex){
				maxindex = end;
			}
			fillArray(start , end);
			System.out.println();
		}
	}

	public int getCount() {
		// TODO Auto-generated method stub
		int count = 0;
		for(int i = 0 ; i < array.length;){
			if(array[i]==0){
				while(i< array.length-1 && array[i+1]!=0){
					i = i+1;
				}
				i++;
				count++;
				if(i< array.length-1 && array[i+1] !=-1 && array[i+1] ==0){
					continue;
				}else{
					i++;
				}
			}else{
				i++;
			}
		}
		return count;
	}

	private void fillArray(int start, int end) {
		if(end >= array.length){
			int previousLength = array.length;
			array = Arrays.copyOf(array, end+4);
			for(int i = previousLength ; i < end+4 ; i++ ){
				array[i] = 1;
			}
		}
		for(int i = start ; i <= end ; i++){
			if (i == start || i == end){
				array[i] = 0;
			}else if( i > start && i < end){
				array[i] = 1;
			}
		}
		if(end+1 > maxindex){
			array[end+1] = -1;
		}
	}
}
