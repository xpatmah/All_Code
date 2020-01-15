package com.org.designpatterns.first.adaptor;

import java.io.IOException;

public class AdaptoDesignPatternUsage {
		
	public static void main(String[] args) throws IOException {
		
		Client c = new BankCustomer();
		c.giveBankDetails();
		System.out.println(c.getBankDetails());
		
	}
}
