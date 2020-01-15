package com.org.cms.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CMS {

	public static void main(String[] args) throws IOException {
		
		
		
		
		
		
	}
	
	public void startProcessing() throws IOException {
		InputStream stream = CMS.class.getClassLoader().getResourceAsStream("Contact.txt");

		if(stream!=null){
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

			String br = null;

			while(null!= (br = reader.readLine())){

			}
		}

	}
	
}
