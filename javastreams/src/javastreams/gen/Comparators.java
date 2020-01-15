package com.org.java.gen;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Comparators {

	
	public static <T extends Comparable<? super T>> Comparator<T> getNaturalorder(){
		
		return new Comparator<T>() {
			@Override
			public int compare(T o1, T o2) {
				return o1.compareTo(o2);
			}
		};
	}
	
	public static <T extends Comparable<? super T>> Comparator<T> reverseCom(){
		
		return new Comparator<T>() {
			@Override            
			public int compare(T o1, T o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		};
	}
	
	
	
	public static <T extends Comparable<? super T>> T max(Collection<? extends T> coll , Comparator<? super T> comp){
		
		Iterator<? extends T> it = coll.iterator();
		
		T candidate = it.next();
		
		for(T obj3 : coll){
			if(comp.compare(candidate, obj3)<0){
				candidate = obj3;
			}
		}
		return candidate;
	} 
	
	
	public static <T extends Comparable<? super T>> T min(Collection<? extends T> coll){
		return max(coll,reverseCom());
	}
    	
	
	public static <T extends Comparable<? super T>> T max(Collection<? extends T> coll){
		return max(coll,Comparators.getNaturalorder());
	}
	
	public static <T extends Comparable<? super T>> Comparator<List<T>> getListComparator(Comparator<T> comp){

		return new Comparator<List<T>>() {
			@Override
			public int compare(List<T> o1, List<T> o2) {
				int size1 = o1.size();
				int size2 = o2.size();
				for(int i=0;i<Math.min(size1, size2);i++){
					int result = comp.compare(o1.get(i), o2.get(i));
					if(result!=0){
						return result;
					}
				}	
				return size1>size2 ? 1: size1==size2 ? 0 :-1;
			}
		} ;
	}
}
