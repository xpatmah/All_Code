package com.org.java.design.flyweight;

import java.util.HashMap;
import java.util.Map;

public class Menu {
  
	private Map<String , CoffeFlavor> menu = new HashMap<>();
	
	public CoffeFlavor lookup(String flavor){
		synchronized (menu) {
			if(!menu.containsKey(flavor)){
				menu.put(flavor, new CoffeFlavor(flavor));
			}	
		}
		return menu.get(flavor);
	}
	
	public int totalOrderWehave(){
		return  menu.size();
	}
	
	
}
