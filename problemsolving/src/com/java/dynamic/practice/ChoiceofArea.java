package com.java.dynamic.practice;

import java.util.HashMap;
import java.util.Map;

public class ChoiceofArea {

	public static void main(String[] args) {
        
		Area x = new Area(3,2);
		Area y = new Area(-5,-10);
		Area z = new Area(-20,5);
		
		ChoiceofArea choiceArea = new ChoiceofArea();
		
		System.out.print(choiceArea.initRecursion(x , y , z , 100 , 18));
		
	}
	
	
	private int initRecursion(Area x, Area y, Area z, int powerA, int powerB) {
		
		Map<String , Integer> map = new HashMap<String, Integer>();
		
		int time = Integer.max(moveIntoArea(x, y, z, powerA, powerB, 1, map), Integer.max(moveIntoArea(x, y, z, powerA, powerB, 2, map), moveIntoArea(x, y, z, powerA, powerB, 3, map)));
		
		return time;
	}
	
	

	private int moveIntoArea(Area x, Area y, Area z, int powerA, int powerB, int landPosition,
			Map<String, Integer> map) {

		if(powerA<=0 || powerB<=0) {
			return 0;
		}
		
		String key = String.valueOf(powerA)+"-"+String.valueOf(powerB)+"-"+String.valueOf(landPosition);
		
		if(map.containsKey(key)) {
			return map.get(key);
		}
		
		int time = 0;
	    
		switch (landPosition) {
		case 1:
			time = 1 + Integer.max(moveIntoArea(x, y, z, powerA+y.a, powerB+y.b, 2, map), moveIntoArea(x, y, z, powerA+z.a, powerB+z.b, 3, map));
			break;
		case 2:
			time = 1 + Integer.max(moveIntoArea(x, y, z, powerA+x.a, powerB+x.b, 1, map), moveIntoArea(x, y, z, powerA+z.a, powerB+z.b, 3, map));
			break;
		case 3:
			time = 1 + Integer.max(moveIntoArea(x, y, z, powerA+x.a, powerB+x.b, 1, map), moveIntoArea(x, y, z, powerA+y.a, powerB+y.b, 2, map));
			break;	
		}
		
		map.put(key, time);

		return time;
		
		
	}
}
