package com.org.java.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	
	public static void main(String[] args) {
		
		Predicate<String> strPredicate = s -> s.length() > 20;
		
		strPredicate = strPredicate.add(s-> s.length() < 30);
		
	    boolean length  = strPredicate.test("FJJFJFJFasdffdsfsdfsdfsdf");
	    
	    System.out.println(length);
	    
	    List<Integer> intList = new ArrayList<Integer>();
	    intList.add(2);
	    intList.add(3);
	    intList.add(4);
	    intList.add(5);
	    
	    List<Integer> intList2 = new ArrayList<Integer>();
	    
	    
	    
	    intList2.stream().reduce(identity, accumulator, combiner)
	    
	    intList.stream().filter(t-> t%2==0).forEach(intList2::add);
	    
	    System.out.println("");
	    
	    Map<String , String> hashMap = new HashMap<>();
	    hashMap.put("wr", "werewrwe");
	    hashMap.put("w3r", "werewrwe");
	    hashMap.put("wdr", "werewrwe");
	    hashMap.put("wfr", "werewrwe");
	    
	    Map<String , String> hashMap2 = new HashMap<>();
	    hashMap2.put("wr", "werewrwe");
	    hashMap2.put("w3r3", "werewrwe");
	    hashMap2.put("wdr4", "werewrwe");
	    hashMap2.put("wfr4", "werewrwe");
	    //List<String> keySet = new ArrayList<String>();
	  //  hashMap2.forEach((key, valye)-> keySet.add(key));
	    
	    
	    hashMap2.forEach((key , value)-> {
	    	hashMap.merge(key, value, (str1,str2)-> str1+"_"+str2);
	    });
	    
	    System.out.println("");
	    
	}
}
