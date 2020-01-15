package com.sprinboot.starter.project.springbootdemo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import com.sprinboot.starter.project.springbootdemo.bean.Person;

@Repository
public class PersonJpaRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}
	
	public Person update(Person entity) {
		return entityManager.merge(entity);
	}
	
	
}
