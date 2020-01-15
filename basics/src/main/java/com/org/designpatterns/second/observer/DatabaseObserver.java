package com.org.designpatterns.second.observer;

import java.util.ArrayList;
import java.util.List;

public class DatabaseObserver implements Observer<IDatabaselistner<String,String>,String,String>{

	
     List<IDatabaselistner<String, String>> listnerList = new ArrayList<IDatabaselistner<String,String>>();
	
     
     public void updateRecord(String name, String number){
    	 notfy(name,number);
     }
     
	
	@Override
	public void removeListner(IDatabaselistner<String,String> listner) {
		// TODO Auto-generated method stub
		listnerList.remove(listner);
	}

	@Override
	public void addListner(IDatabaselistner<String,String> lintner) {
		// TODO Auto-generated method stub
		listnerList.add(lintner);
	}

	@Override
	public void notfy(String obj , String obj2) {
		for(IDatabaselistner<String,String> listner : listnerList){
			listner.update(obj, obj2);
		}
	}

}
