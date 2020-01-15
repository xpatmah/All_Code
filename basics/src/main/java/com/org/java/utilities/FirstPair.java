package com.org.java.utilities;

import java.util.HashMap;
import java.util.Map;

public class FirstPair {

	public static void main(String[] args) {

		int[] array = new int[]{-10,0,10,5,-1,7,4,1,2,-1,9,19};
		
		Map<Integer , Integer> map= new HashMap<Integer , Integer>();
		int sum=10;
		Map<Integer , String> savedPair = new HashMap<Integer, String>();
		
		for(int i=0;i<array.length ;i++){
			if(i>0){
				int checkforKey = sum-array[i];
				boolean result = map.containsKey(checkforKey);
				if(!result){
					if(!map.containsKey(array[i])){
						map.put(array[i], i);
					}
				}else{
					if(!savedPair.containsKey((map.get(checkforKey)+1))){
						savedPair.put((map.get(checkforKey)+1), "Pair found at "+ (map.get(checkforKey)+1) +" and " + (i+1));
					}
				}
			}else{
				map.put(array[0], i);
			}
		}
		
		int minKey = Integer.MAX_VALUE;
		for(Map.Entry<Integer, String> entry : savedPair.entrySet()){
            if(entry.getKey()<minKey){
            	minKey = entry.getKey();
            }
		}
		System.out.println(savedPair.get(minKey));
		
	}

}
