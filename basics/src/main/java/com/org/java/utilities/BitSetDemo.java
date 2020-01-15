package com.org.java.utilities;

import java.util.BitSet;

public class BitSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BitSet set = new BitSet();
		set.set(12);
		
		BitSet set2 = new BitSet();
		set2.set(12);
		set2.set(15);
		set.and(set2);
		System.out.println(set);
		
		
		
	}

}
