package com.org.designpatterns.first.adaptor;

import java.io.IOException;

public interface Client {

	public void giveBankDetails() throws IOException;
	
	public String getBankDetails();
	
}
