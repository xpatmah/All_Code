package com.org.cms.managers;

import java.util.ArrayList;
import java.util.List;

import com.org.cms.domain.Contact;
import com.org.cms.interfaces.IRecordManager;

public class RecordManager implements IRecordManager{

	List<Contact> contactList = new ArrayList<>();
	
	@Override
	public void addRecord(String str) {
		// TODO Auto-generated method stub
		String[] splitString = str.split(",");
		
		Contact c1 = new Contact();
	//	c1.setAddress(splitString[]);
		
		
	}

	@Override
	public void removeRecord(String str) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findRecord(String str) {
		// TODO Auto-generated method stub
		
	}

}
