package com.org.loging.servlet;

import java.util.HashMap;

import com.org.database.manager.DataBaseManager;

public class LogingTasks {

	
	public static boolean validateUser(String user, String password){
		
		HashMap<String, String> map = DataBaseManager.getInstance().retreiveAllUsers();
		String storedPassword = map.get(user);
		if(password.equals(storedPassword)){
			return true;
		}
		return false;
		
	}
	
	
}
