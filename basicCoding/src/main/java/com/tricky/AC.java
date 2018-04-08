package com.tricky;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class AC
{
	int methodOfA()
	{
		return 1; //(true ? null : 0);
	}
	
	
	public static void main(String[] args) {
		
		int[] arrat = {2,4,5,6,7};
		
		int a1 = -1 & 15;
		
		System.out.println(a1);
		
		int numElements = 10;
		int initialCapacity =8;
		
		  if (numElements >= initialCapacity) {
	            initialCapacity = numElements;
	            initialCapacity |= (initialCapacity >>>  1);
	            initialCapacity |= (initialCapacity >>>  2);
	            initialCapacity |= (initialCapacity >>>  4);
	            initialCapacity |= (initialCapacity >>>  8);
	            initialCapacity |= (initialCapacity >>> 16);
	            initialCapacity++;

	            if (initialCapacity < 0)   // Too many elements, must back off
	                initialCapacity >>>= 1;// Good luck allocating 2 ^ 30 elements
	        }
		
		ArrayDeque<String> dequeue = new ArrayDeque<>(10);
		ArrayList<String> l1  = new ArrayList<>();

		dequeue.addFirst("local");
		dequeue.addFirst("dddd");
		
		System.out.println();
		
		int[] newArray = Arrays.copyOfRange(arrat, 0 , arrat.length-1);
		
		System.out.println(Arrays.toString(newArray));
		
		AC a = new AC();
		int ab = a.methodOfA();
		System.out.println(ab);
	}
}