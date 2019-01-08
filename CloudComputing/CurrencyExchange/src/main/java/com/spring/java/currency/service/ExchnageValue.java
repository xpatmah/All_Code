package com.spring.java.currency.service;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExchnageValue {

	@Id
	private Long id;
	private String from;
	private String to;
	
	private BigDecimal converionMultiple;

	public ExchnageValue() {
		// TODO Auto-generated constructor stub
	}
	
	public ExchnageValue(Long id, String from, String to, BigDecimal converionMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.converionMultiple = converionMultiple;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConverionMultiple() {
		return converionMultiple;
	}

	public void setConverionMultiple(BigDecimal converionMultiple) {
		this.converionMultiple = converionMultiple;
	}
	
}
