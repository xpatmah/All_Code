package com.org.problemsolving.ds.first;

import java.util.ArrayDeque;
import java.util.Deque;

public class DeQueueExample {

	public static void main(String[] args) {
		Deque<Integer> intDeque = new ArrayDeque<>();
		
		intDeque.offerFirst(23);
		intDeque.offerLast(27);
		
		System.out.println(intDeque.removeLast());
		
	}
	
}
