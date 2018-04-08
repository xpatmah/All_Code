package com.java.webnms.response;

import java.io.Serializable;

public class Alarm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5824117045473316954L;

	private String ip;
	
	private String alarmid;
	
	private String nename;
	
	private String unit;
	
	private String seviourity;
	
	private String time;
	
	private String discription;
	
	private String location;
	
	private String documentid;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getAlarmid() {
		return alarmid;
	}

	public void setAlarmid(String alarmid) {
		this.alarmid = alarmid;
	}

	public String getNename() {
		return nename;
	}

	public void setNename(String nename) {
		this.nename = nename;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getSeviourity() {
		return seviourity;
	}

	public void setSeviourity(String seviourity) {
		this.seviourity = seviourity;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDocumentid() {
		return documentid;
	}

	public void setDocumentid(String documentid) {
		this.documentid = documentid;
	}

	
	
}
