package com.springstarterjdbc.jdbc.repo;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springstarterjdbc.jdbc.entity.Person;

@Repository
public class PersonJdbcDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private EntityManager manager;
	
	// lets do the select * 
	
	public List<Person> findall(){
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper(Person.class));
		
	}
	
	
	
	
}
