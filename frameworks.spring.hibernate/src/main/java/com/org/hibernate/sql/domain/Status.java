package com.org.hibernate.sql.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Status {
	
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
