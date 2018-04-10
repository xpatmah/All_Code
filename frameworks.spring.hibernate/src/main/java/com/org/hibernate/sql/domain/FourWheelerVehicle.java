package com.org.hibernate.sql.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CAR")
public class FourWheelerVehicle extends Vehicle{

	private String forWheelerHandle;

	public String getForWheelerHandle() {
		return forWheelerHandle;
	}

	public void setForWheelerHandle(String forWheelerHandle) {
		this.forWheelerHandle = forWheelerHandle;
	}
	
}
