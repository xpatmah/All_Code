package com.org.java.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethodReferencing {

	public static void main(String[] args) {
		
		Function<String, String> funct = MethodReferencing::getUpper; 
		
		Predicate<String> str2 = String::isEmpty;
		
		Supplier<List<Integer>> supplier = () -> {
			List<Integer> intList = new ArrayList<Integer>();
			return intList;
		};
		
		List<String> stringList = new ArrayList<>();
		
		Local local = new Local();
		
		//String
		
		Consumer<String> con = local::add;
		
		Comparator<String> str = String::compareTo;  
		
		System.out.println(funct.apply("this is my game"));
		
		List<Integer> intList = supplier.get();
		
		con.accept("Apple");
		
		System.out.println(stringList.get(0));
	}
	
	private static String getUpper(String s) {
		return s.toUpperCase();
	}
	
	
	
}
