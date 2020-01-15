package com.org.hibernate.sql.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	@Column(name="STREAT_ADDR")
	String streat;
	
	@Column(name="CITY_ADDR")
	String city;
	
	@Column(name="STATE_ADDR")
	String state;
	
	@Column(name="PINCODE")
	String pincode;
	
	public String getStreat() {
		return streat;
	}
	public void setStreat(String streat) {
		this.streat = streat;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	

}
