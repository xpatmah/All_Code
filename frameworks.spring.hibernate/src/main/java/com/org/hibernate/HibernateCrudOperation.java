package com.org.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.org.hibernate.sql.domain.Employee;

public class HibernateCrudOperation {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		session.beginTransaction();
		// Create in Hibernate
		for(int i =0 ; i < 10;i++) {
			Employee emp = new Employee();
			emp.setName("Employee "+i);
            session.save(emp);			
		}
		
		// Read in hibernate
		
		Employee emps = session.get(Employee.class, 3);
		
		System.out.println(emps.getName());
		
		// Update the user
		
		emps = session.get(Employee.class, 5);
		
		Employee x = emps;
		
		emps.setName("Updated Employee");
		
		session.update(emps);
		
		// delete the user
		
		emps = session.get(Employee.class, 9);
		session.delete(emps);
		
		session.getTransaction().commit();
		session.close();
		factory.close();
		
	}
	
}
