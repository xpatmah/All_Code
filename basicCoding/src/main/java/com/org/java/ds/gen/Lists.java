package com.org.java.ds.gen;

import java.util.ArrayList;
import java.util.List;

public class Lists {

	public static <T> List<T> toList(T... arr){
		List<T> arrayList = new ArrayList<T>();
		for(T ele : arr){
			arrayList.add(ele); 
		}
		return arrayList;
		
	}
}
