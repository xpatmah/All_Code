package com.java.basic.ds;

import java.util.stream.IntStream;

public class EggerLazyNess {
		
	public static void main(String[] args) {
		IntStream intStream  = IntStream.of(1,2,3,5,8);
		intStream.filter(i->i%2==0).map(i->++i).forEach(System.out::println);
		
	}
}
