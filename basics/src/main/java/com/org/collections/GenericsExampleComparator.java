package com.org.collections;

import java.util.Collection;
import java.util.Comparator;


class Comparatorsss{
	
	public static < T extends Object> T max(Collection<? extends T> coll , Comparator<? super T> com){
		
		T maximum = coll.iterator().next();
		for(T ele : coll){
			if(com.compare(maximum, ele)>0){
				maximum=ele;
			}
		}
		return maximum;
	}
	
}

public class GenericsExampleComparator {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
	}

}
