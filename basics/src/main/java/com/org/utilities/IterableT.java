package com.org.utilities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterableT<E> implements Iterator<E>{

	List<Iterator<E>> list = new ArrayList<>(); 
	
	public IterableT(Iterator<? extends Iterator<E>> root) {
		// TODO Auto-generated constructor stub
		while(root.hasNext()){
			list.add(root.next());
		}
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E next() {
		// TODO Auto-generated method stub
		return null;
	}

}
