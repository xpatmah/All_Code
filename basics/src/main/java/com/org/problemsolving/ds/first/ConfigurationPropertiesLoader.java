package com.org.problemsolving.ds.first;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class ConfigurationPropertiesLoader {

	private static ConfigurationPropertiesLoader fileLoader = null;
	
	static final Properties PROPERTIES = new Properties();
	
	private ConfigurationPropertiesLoader() {
	}
	
	public static ConfigurationPropertiesLoader getInstance(){
		
		if(fileLoader==null){
			synchronized (ConfigurationPropertiesLoader.class) {
               if(fileLoader==null){
            	   fileLoader = new ConfigurationPropertiesLoader();
               }				
			}
		}
		return fileLoader;
	}
	
	public void loadPropertiesFile(String path) throws Exception {
		// TODO Auto-generated method stub
         try {
        	FileInputStream propertiesFile = new FileInputStream(new File(path)); 
			PROPERTIES.load(propertiesFile);
		} catch (IOException e) {
			System.out.println("Please provide the absolute path for the file");
			System.exit(1);
		}
	}
	
	
	 public Enumeration<Object> getProperties() throws Exception {
	     return PROPERTIES.keys();  
	     
	  }
	
}
