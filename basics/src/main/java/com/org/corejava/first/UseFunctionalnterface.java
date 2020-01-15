package com.org.corejava.first;

import java.util.ArrayList;
import java.util.List;

import com.org.interfaces.IInterface;

public class UseFunctionalnterface {

	public static void main(String[] args) {
		
		List<String> stringList = new ArrayList<>();
		
		stringList.add("Mahesh");
		stringList.add("Ramesh");
		stringList.add("Ram");
		
		UseFunctionalnterface f1 = new UseFunctionalnterface();
		
		IInterface<String> str = f1::findElements;
		
		System.out.println(f1.findEmelemet(stringList, "Ramkdld"));
		
	}
	
	
	
	public <T> boolean findEmelemet(List<T> string , T rlr) {
		IInterface<T> lists = (listOf , strs ) -> {
			return listOf.stream().anyMatch((oneStr)-> strs.equals(oneStr));
		};
		return lists.findElement(string, rlr);
	}
	
	public <T> boolean findElements(List<T> string , T rlr) {
		
		return string.stream().anyMatch((onestring)-> onestring.equals(rlr));
		
		
	}
	
}
