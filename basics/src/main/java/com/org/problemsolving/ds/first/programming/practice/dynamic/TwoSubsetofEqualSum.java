package com.org.problemsolving.ds.first.programming.practice.dynamic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TwoSubsetofEqualSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TwoSubsetofEqualSum sum = new TwoSubsetofEqualSum();
		List<Integer> array = Arrays.asList(1,5,11,5);
		Collections.sort(array);
		System.out.println(sum.calculateSum(array));
		
	}
	
	public boolean calculateSum(List<Integer> array){
		int leftSum = array.get(0);
		int rightSum = 0;
		for(int i =1 ; i< array.size();i++){
			rightSum = rightSum + array.get(i);					
		}
		for(int i=1 ; i< array.size();i++){
			if(leftSum == rightSum){
				return true;
			}else{
				leftSum = leftSum + array.get(i);
				rightSum = rightSum - array.get(i);
			}
		}
		return false;
	}

}
