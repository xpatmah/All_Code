package com.org.gfg.mathematics;

public class CelsiusToFahrenheit {

	public static void main(String[] args) {
		
		CelsiusToFahrenheit ctoF = new CelsiusToFahrenheit();
		System.out.println(ctoF.getFahrenheit(32));
	}
	
	private int getFahrenheit(int C) {
		return  (C * 9/5) + 32;
	}
}
