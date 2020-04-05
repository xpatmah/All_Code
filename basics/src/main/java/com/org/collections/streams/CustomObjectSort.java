package com.org.collections.streams;

import com.org.domain.collection.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CustomObjectSort {

	public static void main(String[] args) {
		
		List<Book> arryList = new ArrayList<Book>();
		
		arryList.add(new Book("ABC", "SJHDSS", 34));
		arryList.add(new Book("DHD", "SHDSS", 367));
		arryList.add(new Book("ADDKC", "JHDSS", 37));
		arryList.add(new Book("AKK", "SJHDSDD", 38));
		
		Collections.sort(arryList , (b1 , b2)-> b1.getTitle().compareTo(b2.getTitle()));
		
		arryList.stream().forEach(e -> System.out.println(e.getAuthname()));
		
		
	}
	
}
