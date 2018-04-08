package com.tricky;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex1 {
	
	public static void main(String[] args) {
		
		List<String> strList = new ArrayList<String>();
		strList.add("ldv");
		strList.add("kda");
		strList.add("skadca");
		strList.add("vvdv");
		strList.add("dvadvz");
		for(String forString : strList) {
			System.out.println(forString);
		}
		System.out.println("********************************");
		Ex1 e1 = new Ex1();
		e1.iterationExmple(strList);
	}
	
	public void iterationExmple(List<String> strList) {
		
		Iterator<String> str =  strList.iterator();
		while(str.hasNext()) {
			String stre = str.next();
			if (stre.contains("z")) {
				str.remove();
			}
		//	strList.remove(stre);
		}
		
		for(String forString : strList) {
			System.out.println(forString);
		}
		
		
	}
}
