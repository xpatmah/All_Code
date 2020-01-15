package com.org.problemsolving.ds.first;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Vector;

public class GenericsExample {

	public static void main(String[] args) {
		
		List<? super Number> list = new ArrayList<Object>();
                                            
		list.add(3);
		list.add(3.4);
		
		Vector<Integer> vector = new Vector<>();
		
		vector.add(23);
		vector.add(245);
		vector.add(26);
		vector.add(43);
		vector.add(63);
		vector.add(27);
		vector.add(23);
		
		for(Integer inter : vector) {
			System.out.println(inter);
		}

		
		Queue<Person> person = new PriorityQueue<>();
		
		person.add(new Person("John" , 23));
		
		person.add(new Person("John" , 27));
		
		while(null!=person.peek()) {
			System.out.println(person.poll());
		}
		
	}
	
}
