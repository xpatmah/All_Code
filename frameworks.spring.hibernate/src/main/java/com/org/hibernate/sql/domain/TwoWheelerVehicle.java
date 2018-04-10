package com.org.hibernate.sql.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BIKE")
public class TwoWheelerVehicle extends Vehicle{

	private String twoWheelerHandle;

	public String getTwoWheelerHandle() {
		return twoWheelerHandle;
	}

	public void setTwoWheelerHandle(String twoWheelerHandle) {
		this.twoWheelerHandle = twoWheelerHandle;
	}
	
}
