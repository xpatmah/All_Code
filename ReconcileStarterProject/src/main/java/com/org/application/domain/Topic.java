package com.org.application.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic {

	@Id
    private Integer id ;
    
	private String name;
    
	private String description;
	
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
