package com.org.bits.webNMS.domain.interfaces;

import java.util.HashMap;

public class NeDashBoard {

	private String user;
	
	private HashMap<String, String> neportinfo = new HashMap<String, String>();

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public HashMap<String, String> getNeportinfo() {
		return neportinfo;
	}

	public void setNeportinfo(HashMap<String, String> neportinfo) {
		this.neportinfo = neportinfo;
	}
	
}
