package com.org.hibernate;

import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.org.hibernate.sql.domain.Employee;

public class HibernateQueryLanguage {

	public static void main(String[] args) {
		
		Random ran = new Random();
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		session.beginTransaction();
		
		for(int i = 1 ; i < 100;i++) {
			Employee emp = new Employee();
			emp.setName("Employee "+i);
			emp.setSalary(ran.nextInt(9999)*i);
			session.save(emp);
			
		}
		
		session.getTransaction().commit();
		session.close();

		session = factory.openSession();
		session.beginTransaction();
		
      //  Query query = session.createQuery("select name from Employee where salary > 100000");		
        //query.setFirstResult(60);
        //query.setMaxResults(10);
        
		Query query = session.getNamedQuery("Employee.id");
        
        query.setString(0, "Employee 1");
        
        List<String> list= (List<String>)query.list();
        
        session.getTransaction().commit();
        
        System.out.println("size of list is"+list.size());
        
        list.stream().forEach(System.out::println);
		
        session  = factory.openSession();
        
        session.beginTransaction();
        
        Criteria c = session.createCriteria(Employee.class);
        
        c.add(Restrictions.eq("name", "Employee 4"));        
        
        List<Employee> empDetails = c.list();
        
        session.getTransaction().commit();
        
        empDetails.stream().forEach(System.out::println);
		factory.close();
		
	}
	
}
