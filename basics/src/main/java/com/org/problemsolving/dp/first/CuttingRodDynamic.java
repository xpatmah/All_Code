package com.org.problemsolving.dp.first;

public class CuttingRodDynamic {

	public static void main(String[] args) {
		CuttingRodDynamic road = new CuttingRodDynamic();
		
		int price[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
	    
		int maxValueObtained  = road.cutMax(price, price.length);

	    System.out.println(maxValueObtained);
	}

	public int cutMax(int[] price, int length) {
		
		int[] table = new int[length+1];
		
		table[0] = 0;
		
		for(int i =1 ;i<= length;i++) {
			int maxValue = Integer.MIN_VALUE;
			
			for(int j = 0 ; j < i;j++) {
				maxValue = Math.max(maxValue, price[j] + table[i-j-1]);
			}
			table[i] = maxValue;
		}
		
		return table[length];
	}
	
	
	
}


