package com.org.java.ds.gen;

import java.util.ArrayList;
import java.util.List;

public class MyCollection {

	
	public static <T> List<T> toList(T... arr){
	   
		List<T> t1 = new ArrayList<T>();
		for(T ele : arr){
			t1.add(ele);
		}		
		return t1;
	}
	
	
}
