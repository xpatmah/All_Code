package com.org.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class HashMapClassUsage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<>();
		Map<String, Integer> linkedHashMap = new LinkedHashMap<>();		
	
		map.put("Mahesh", 31);
		map.put("Ramesh", 14);
		map.put("Suresh", 24);
		map.put("Naman", 33);
		map.put("kashmira", 39);
		
		
	    List<Integer> intList = new ArrayList<>();
	    
	    intList.add(2);
	    intList.add(3);
	    intList.add(4);
	    intList.add(5);
	    intList.add(6);
		
	    
	    Predicate<Integer> cond = (i) -> i > 100;
	   
	    boolean value =  intList.stream().anyMatch(cond);
	    
		
		map.entrySet().stream().sorted(
				(k1,k2) -> {
					if(k1.getValue() > k2.getValue()) {
						return 1;
					}else if(k1.getValue() < k2.getValue())  {
						return -1;
					}else {
						return 0;
					}
				}).forEach(k -> linkedHashMap.put(k.getKey(), k.getValue()));
		
		linkedHashMap.entrySet().stream().forEach(k->System.out.println(k.getKey() +" "+ k.getValue()));
		
	}

}
